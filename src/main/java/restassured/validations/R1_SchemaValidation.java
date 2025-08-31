package restassured.validations;

import java.io.File;
import static io.restassured.RestAssured.with;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class R1_SchemaValidation {

    public static void main(String[] args) {

        String resp= """
                {
                "id": 1,
                "name": "Sumit",
                "email": "sumit@example.com"
                }    
                """;

        String respMissingEmail= """
                {
                "id": 1,
                "name": "Sumit"
                }    
                """;

        String respSchema= """
                {
                "type": "object",
                "properties": {
                "id": { "type": "integer" },
                "name": { "type": "string", "minLength": 1 },
                "email": { "type": "string", "format": "email" }
                },
                "required": ["id", "name", "email"],
                "additionalProperties": false
                }
                
                """;


        //WIP
        //Note we would need actual endpoints, this dummy implementtion not failing
        with()
                .body(resp)   // supply raw string
                .then()
                .body(matchesJsonSchema(new File("src/main/resources/respSchema.json")));
        //will work


        with()
                .body(respMissingEmail)   // supply raw string missing required field email
                .then()
                .body(matchesJsonSchema(new File("src/main/resources/respSchema.json")));


    }
}
