package restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;

public class R19_JsonPathBigDecimal {
    public static void main(String[] args) {

        // ✅ Sample JSON payload
        String response = """
            [
              {
                "name": "Rohit",
                "department": "QA",
                "salary": 85000.50,
                "bonus": 85000.50
              },
              {
                "name": "Mahajan",
                "department": "QA Automation",
                "salary": 95000.51,
                "bonus": 95000.51
              }
            ]
            """;

        System.out.println("=== Default Double precision (may fail) ===");
        // ❌ Using default JsonPath (Double comparison)
        String name1 = JsonPath.from(response)
                .getString("find { it.salary == 95000.51 }.name");

        System.out.println("Matched Employee (Default): " + name1);

        // ✅ Correct approach: use BigDecimal precision
        System.out.println("\n=== Using BigDecimal precision (accurate) ===");
        String name2 = JsonPath.from(response)
                .using(JsonPathConfig.jsonPathConfig()
                        .numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL))
                .getString("find { it.salary == 95000.51 }.name");

        System.out.println("Matched Employee (BigDecimal): " + name2);
    }
}


//=== Default Double precision (may fail) ===
//Matched Employee (Default): null
//
//=== Using BigDecimal precision (accurate) ===
//Matched Employee (BigDecimal): Mahajan




//Explanation
//Mode	Description	Result
//Default JsonPath	Parses numbers as Double, causing floating-point rounding.	null (comparison fails)
//With BigDecimal	Parses numbers with exact precision.	✅ "Mahajan" found
//💡 Optional Improvement
//
//If you deal with money, tax, interest, or discount calculations frequently, you can make BigDecimal parsing global:
//
//import io.restassured.RestAssured;
//import io.restassured.config.JsonConfig;
//
//RestAssured.config = RestAssured.config()
//        .jsonConfig(JsonConfig.jsonConfig()
//                .numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL));
//
//
//That way, all your RestAssured and JsonPath extractions across tests will automatically use BigDecimal precision.