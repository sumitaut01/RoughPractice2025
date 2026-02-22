package restassuredworkvalidations;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import java.util.List;

// validators/ResponseValidator.java
public class ResponseValidator {
    private  Response response;
    private  SoftAssert softAssert;
    // Builder-style — chain validations
    public ResponseValidator(Response response) {
        this.response = response;
        this.softAssert = new SoftAssert();
    }

    public ResponseValidator(Response response,SoftAssert softAssert) {
        this.response = response;
        this.softAssert = softAssert;
    }

    // ── Status Code ────────────────────────────────────────
    public ResponseValidator statusCode(int expected) {
        softAssert.assertEquals(response.statusCode(), expected,
            "Status code mismatch. Body: " + response.asPrettyString());
        return this;
    }

    // ── Response Time ──────────────────────────────────────
    public ResponseValidator responseTimeBelow(long milliseconds) {
        softAssert.assertTrue(response.time() < milliseconds,
            "Response time " + response.time() + "ms exceeded " + milliseconds + "ms");
        return this;
    }

    // ── Header Checks ──────────────────────────────────────
    public ResponseValidator hasHeader(String headerName, String expectedValue) {
        softAssert.assertEquals(response.header(headerName), expectedValue,
            "Header mismatch for: " + headerName);
        return this;
    }

    public ResponseValidator hasHeader(String headerName) {
        softAssert.assertNotNull(response.header(headerName),
            "Expected header missing: " + headerName);
        return this;
    }

    // ── Field Existence ────────────────────────────────────
    public ResponseValidator fieldExists(String jsonPath) {
        Object value = response.jsonPath().get(jsonPath);
        softAssert.assertNotNull(value, "Field not found in response: " + jsonPath);
        return this;
    }

    public ResponseValidator fieldNotNull(String jsonPath) {
        String value = response.jsonPath().getString(jsonPath);
        softAssert.assertNotNull(value, "Field is null: " + jsonPath);
        softAssert.assertFalse(value.isEmpty(), "Field is empty: " + jsonPath);
        return this;
    }

    // ── Field Value Checks ─────────────────────────────────
    public ResponseValidator fieldEquals(String jsonPath, Object expected) {
        Object actual = response.jsonPath().get(jsonPath);
        softAssert.assertEquals(actual, expected,
            "Mismatch at [" + jsonPath + "]. Expected: " + expected + ", Actual: " + actual);
        return this;
    }

    public ResponseValidator fieldContains(String jsonPath, String substring) {
        String actual = response.jsonPath().getString(jsonPath);
        softAssert.assertTrue(actual != null && actual.contains(substring),
            "Field [" + jsonPath + "] = '" + actual + "' does not contain '" + substring + "'");
        return this;
    }

    public ResponseValidator listNotEmpty(String jsonPath) {
        List<?> list = response.jsonPath().getList(jsonPath);
        softAssert.assertNotNull(list, "List is null at: " + jsonPath);
        softAssert.assertFalse(list.isEmpty(), "List is empty at: " + jsonPath);
        return this;
    }

    public ResponseValidator listSize(String jsonPath, int expectedSize) {
        List<?> list = response.jsonPath().getList(jsonPath);
        softAssert.assertEquals(list.size(), expectedSize,
            "List size mismatch at: " + jsonPath);
        return this;
    }

    // ── Deserialize to POJO ────────────────────────────────
    public <T> T as(Class<T> clazz) {
        return response.as(clazz);
    }

    // ── Extract values ────────────────────────────────────
    public String extract(String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

    // ── Finalize (triggers all soft asserts) ──────────────
    public void validate() {
        softAssert.assertAll();
    }
}