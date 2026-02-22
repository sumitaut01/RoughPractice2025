package restassuredworkvalidations;

import io.restassured.response.Response;

import java.io.InputStream;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

// validators/SchemaValidator.java
public class SchemaValidator {

    // Schema path: schemas/{env}/{country}/{schemaFile}
    public static void validate(Response response, String schemaFileName) {

        InputStream schemaStream = SchemaValidator.class
                .getClassLoader()
                .getResourceAsStream(schemaFileName);

        if (schemaStream == null) {
            throw new RuntimeException("Schema file not found: " + schemaFileName);
        }
        response.then().assertThat()
                .body(matchesJsonSchema(schemaStream));
    }
}