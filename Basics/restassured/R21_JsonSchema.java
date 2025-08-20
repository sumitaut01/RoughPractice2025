package restassured;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

/*
We need below in pom for json schema validation
     <!-- ✅ JSON Schema Validator (optional, for validating against schema files) -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>5.3.2</version>
        </dependency>
 */
public class R21_JsonSchema {
    public static void main(String[] args) {

        String json = """
                        
                """;
        String jsonSchema = """  
                {
                        "$schema": "http://json-schema.org/draft-04/schema#",
                        "type": "object",
                        "properties": {
                        "received": {
                        "type": "object",
                        "properties": {
                        "name": {
                        "type": "string"
                        },
                        "age": {
                        "type": "integer"
                        }
                        },
                        "required": [
                        "name",
                        "age"
                        ]
                        },
                        "message": {
                        "type": "string"
                        }
                        },
                        "required": [
                        "received",
                        "message"
                        ]
                        }
                """;

        String jsonSchemaValidatorValid= """
                {
                   "$schema": "http://json-schema.org/draft-07/schema#",
                   "type": "object",
                   "properties": {
                     "message": {
                       "type": "string"
                     },
                     "received": {
                       "type": "object",
                       "properties": {
                         "name": { "type": "string" },
                         "age": { "type": "integer" }
                       },
                       "required": ["name", "age"]
                     }
                   },
                   "required": ["message", "received"]
                 }
                 
                
                """;


        String jsonSchemaValidatorInvalid= """
                {
                  "$schema": "http://json-schema.org/draft-04/schema#",
                  "type": "object",
                  "properties": {
                    "received": {
                      "type": "object",
                      "properties": {
                        "name": {
                          "type": "string"
                        },
                        "age": {
                          "type": "integer"
                        }
                      },
                      "required": [
                        "name",
                        "age"
                      ]
                    },
                    "message": {
                      "type": "string"
                    }
                  },
                  "required": [
                    "received",
                    "messag"
                  ]
                }
                
                """;

//Valid
        RestAssured.given().contentType(ContentType.JSON).body("{ \"name\": \"Sumit\", \"age\": 30 }")
                .header("Authorization","Bearer secret")
                .post("http://localhost:8080/api/secure-data")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidatorValid));


        //Invalid

        RestAssured.given().contentType(ContentType.JSON).body("{ \"name\": \"Sumit\", \"age\": 30 }")
                .header("Authorization","Bearer secret")
                .post("http://localhost:8080/api/secure-data")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidatorInvalid));

        //   required: ["messag","received"]
        //    missing: ["messag"]
        //
        //  Actual: {"message":"Secure data received successfully!","received":{"name":"Sumit","age":30}}

    }
}
