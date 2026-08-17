package basics.jwt;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TestNG tests for PureJwt.
 *
 * Add testng jar to your classpath (e.g. via your existing TestNG setup in
 * eclipse/IntelliJ, or `mvn test` if you drop this into a Maven project with
 * the testng dependency). No JWT library dependency is needed - PureJwt.java
 * only uses the JDK.
 *
 * Run standalone (no build tool) like:
 *   javac -cp testng.jar PureJwt.java PureJwtTest.java
 *   java -cp .:testng.jar org.testng.TestNG -testclass PureJwtTest
 */
public class PureJwtTest {

    private static final String SECRET = "my-super-secret-key-change-me";
    private String token;
    private String payloadJson;

    @BeforeClass
    public void setUp() {
        payloadJson = "{\"sub\":\"sumit.sagar\",\"role\":\"QA_ENGINEER\"}";
        token = PureJwt.create(payloadJson, SECRET);
        System.out.println("Generated token for test suite: " + token);
    }

    @Test(description = "A freshly created token should have exactly 3 dot-separated parts")
    public void tokenHasThreeParts() {
        String[] parts = token.split("\\.");
        Assert.assertEquals(parts.length, 3, "JWT must be header.payload.signature");
    }

    @Test(description = "Verifying with the correct secret returns the original payload")
    public void verifyWithCorrectSecretSucceeds() {
        String result = PureJwt.verifyAndGetPayload(token, SECRET);
        Assert.assertEquals(result, payloadJson);
    }

    @Test(description = "Verifying with the wrong secret must throw SecurityException")
    public void verifyWithWrongSecretFails() {
        Assert.assertThrows(SecurityException.class,
                () -> PureJwt.verifyAndGetPayload(token, "wrong-secret"));
    }

    @Test(description = "Anyone can decode the payload without the secret (JWT is not encrypted)")
    public void decodeWithoutVerifyingShowsPlainPayload() {
        String decoded = PureJwt.decodeWithoutVerifying(token);
        Assert.assertEquals(decoded, payloadJson);
    }

    @Test(description = "A tampered payload must be rejected even if the header/signature look valid")
    public void tamperedPayloadIsRejected() {
        String[] parts = token.split("\\.");
        String forgedPayload = java.util.Base64.getUrlEncoder().withoutPadding()
                .encodeToString("{\"sub\":\"attacker\",\"role\":\"ADMIN\"}".getBytes());
        String tamperedToken = parts[0] + "." + forgedPayload + "." + parts[2];

        Assert.assertThrows(SecurityException.class,
                () -> PureJwt.verifyAndGetPayload(tamperedToken, SECRET));
    }

    @Test(description = "A malformed token (missing parts) should raise IllegalArgumentException")
    public void malformedTokenThrows() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> PureJwt.verifyAndGetPayload("not-a-real-jwt", SECRET));
    }
}