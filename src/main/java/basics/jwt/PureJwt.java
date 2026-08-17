package basics.jwt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * PureJwt - a minimal, dependency-free JWT (JSON Web Token) implementation.
 *
 * Why this exists:
 *   You often don't need a full library (jjwt / auth0-java-jwt / Spring Security)
 *   just to UNDERSTAND or DEMO how JWT works. A JWT is nothing more than:
 *
 *      base64url(header) + "." + base64url(payload) + "." + base64url(HMAC-SHA256(header.payload, secret))
 *
 *   This class builds and verifies that string using only classes already
 *   inside the JDK (java.util.Base64, javax.crypto.Mac) - no Maven/Gradle
 *   dependency, no Spring Boot, nothing to download.
 *
 * NOTE: This is for LEARNING / DEMO purposes. For production, use a vetted
 * library (jjwt, nimbus-jose-jwt, auth0 java-jwt) which handles edge cases,
 * algorithm-confusion attacks, clock skew, etc.
 */
public class PureJwt {

    private static final Base64.Encoder ENCODER = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder DECODER = Base64.getUrlDecoder();
    private static final String ALGO = "HmacSHA256";

    /**
     * Creates a signed JWT.
     *
     * @param payloadJson raw JSON string for the payload, e.g. {"sub":"sagar","role":"QA"}
     * @param secret      shared secret used to sign (HS256)
     * @return the 3-part JWT string: header.payload.signature
     */
    public static String create(String payloadJson, String secret) {
        String headerJson = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";

        String encodedHeader = ENCODER.encodeToString(headerJson.getBytes(StandardCharsets.UTF_8));
        String encodedPayload = ENCODER.encodeToString(payloadJson.getBytes(StandardCharsets.UTF_8));

        String unsignedToken = encodedHeader + "." + encodedPayload;
        String signature = hmacSha256(unsignedToken, secret);

        return unsignedToken + "." + signature;
    }

    /**
     * Verifies a JWT's signature and expiry-less integrity.
     * Throws if the token is malformed or the signature doesn't match.
     *
     * @return the decoded payload JSON if verification succeeds
     */
    public static String verifyAndGetPayload(String token, String secret) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Not a valid JWT - expected 3 parts, got " + parts.length);
        }

        String unsignedToken = parts[0] + "." + parts[1];
        String expectedSignature = hmacSha256(unsignedToken, secret);

        if (!constantTimeEquals(expectedSignature, parts[2])) {
            throw new SecurityException("Signature verification failed - token has been tampered with or secret is wrong");
        }

        return new String(DECODER.decode(parts[1]), StandardCharsets.UTF_8);
    }

    /** Decodes payload WITHOUT verifying signature - useful to show "anyone can read a JWT". */
    public static String decodeWithoutVerifying(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Not a valid JWT");
        }
        return new String(DECODER.decode(parts[1]), StandardCharsets.UTF_8);
    }

    private static String hmacSha256(String data, String secret) {
        try {
            Mac mac = Mac.getInstance(ALGO);
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), ALGO));
            byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return ENCODER.encodeToString(rawHmac);
        } catch (Exception e) {
            throw new RuntimeException("Failed to sign JWT", e);
        }
    }

    /** Avoids timing attacks when comparing signatures. */
    private static boolean constantTimeEquals(String a, String b) {
        if (a.length() != b.length()) return false;
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }

    // ---- Standalone demo runner: `java PureJwt.java` (JDK 11+, no compile step needed) ----
    public static void main(String[] args) {
        String secret = "my-super-secret-key-change-me";

        System.out.println("=== 1. CREATE a token ===");
        String payload = "{\"sub\":\"sumit.sagar\",\"role\":\"QA_ENGINEER\",\"iat\":" + (System.currentTimeMillis() / 1000) + "}";
        String token = create(payload, secret);
        System.out.println("Token: " + token);

        System.out.println("\n=== 2. DECODE without verifying (anyone can do this - it's just Base64) ===");
        System.out.println("Payload (unverified): " + decodeWithoutVerifying(token));

        System.out.println("\n=== 3. VERIFY with correct secret ===");
        String verifiedPayload = verifyAndGetPayload(token, secret);
        System.out.println("Verified payload: " + verifiedPayload);

        System.out.println("\n=== 4. VERIFY with WRONG secret (should fail) ===");
        try {
            verifyAndGetPayload(token, "wrong-secret");
            System.out.println("ERROR: this should not print - verification should have failed!");
        } catch (SecurityException e) {
            System.out.println("Correctly rejected: " + e.getMessage());
        }

        System.out.println("\n=== 5. TAMPER with the payload and try to verify (should fail) ===");
        String[] parts = token.split("\\.");
        String tamperedPayload = ENCODER.encodeToString(
                "{\"sub\":\"attacker\",\"role\":\"ADMIN\"}".getBytes(StandardCharsets.UTF_8));
        String tamperedToken = parts[0] + "." + tamperedPayload + "." + parts[2];
        try {
            verifyAndGetPayload(tamperedToken, secret);
            System.out.println("ERROR: this should not print - tampering should have been detected!");
        } catch (SecurityException e) {
            System.out.println("Correctly rejected tampered token: " + e.getMessage());
        }
    }
}