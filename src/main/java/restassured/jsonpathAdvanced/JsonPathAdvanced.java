package restassured.jsonpathAdvanced;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.util.List;

//any
//every
//find findAll
//regex case insen
//nested



public class JsonPathAdvanced {

    static String resp = """                        
            {
              "status": "SUCCESS",
              "timestamp": "2025-01-15T10:45:30Z",
              "requestId": "req-123456",
              "data": {
                "category": {
                  "id": 1,
                  "name": "Electronics",
                  "active": true
                },
                "products": [
                  {
                    "productId": 101,
                    "name": "Laptop",
                    "price": 1200.50,
                    "currency": "USD",
                    "tags": ["computer", "portable", "office"],
                    "available": true,
                    "seller": {
                      "sellerId": "S001",
                      "sellerName": "TechStore",
                      "rating": 4.6
                    },
                    "inventory": {
                      "warehouse": "WH-1",
                      "stock": 25,
                      "locations": ["US", "EU"]
                    }
                  },
                  {
                    "productId": 102,
                    "name": "Smartphone",
                    "price": 799.99,
                    "currency": "USD",
                    "tags": ["mobile", "android"],
                    "available": false,
                    "seller": {
                      "sellerId": "S002",
                      "sellerName": "MobileHub",
                      "rating": 4.2
                    },
                    "inventory": {
                      "warehouse": "WH-2",
                      "stock": 0,
                      "locations": ["US"]
                    }
                  }
                ]
              },
              "errors": []
            }                                                                      
            """;


    public static JsonPath getJsonPathResponse() {
        return JsonPath.from(resp);
    }


    @Test
    public void Any() {
//        1️⃣ any {} – At least ONE element matches
//✔ Check if any product is available
        boolean anyAvailable =
                getJsonPathResponse().getBoolean("data.products.any { it.available == true }");
        System.out.println(anyAvailable);

//✅ Returns: true
//✔ Any product price greater than 1000
        boolean expensiveProduct =
                getJsonPathResponse().getBoolean("data.products.any { it.price > 1000 }");
        System.out.println(expensiveProduct);

    }


    @Test
    public void every() {
//        2️⃣ every {} – ALL elements must match
//✔ Check if all products are in USD
        boolean allUsd =
                getJsonPathResponse().getBoolean("data.products.every { it.currency == 'USD' }");

//❌ All products in stock (>0)
        boolean allInStock =
                getJsonPathResponse().getBoolean("data.products.every { it.inventory.stock > 0 }");
//➡️ Returns false (Smartphone has 0 stock)


    }


    @Test
    public void regex() {
//        4️⃣ Regex Matching =~
//✔ Products whose name starts with "Smart"
        List<String> smartProducts =
                getJsonPathResponse().getList(
                        "data.products.findAll { it.name =~ /^Smart.*/ }.name"
                );

//✔ Seller IDs ending with a digit
        List<String> sellerIds =
                getJsonPathResponse().getList(
                        "data.products.findAll { it.seller.sellerId =~ /.*\\d/ }.seller.sellerId"
                );


//⚠️ Double \\ required in Java strings.


//Regex + Case-Insensitive Match
        List<String> laptop =
                getJsonPathResponse().getList(
                        "data.products.findAll { it.name =~ /(?i)laptop/ }.name"
                );

    }


    @Test
    public void AndOR() {
//        Combine Conditions (AND / OR)
//✔ Available AND price < 1000
        List<String> affordable =
                getJsonPathResponse().getList(
                        "data.products.findAll { it.available == true && it.price < 1000 }.name"
                );

//✔ Available OR stock > 0
        List<String> activeProducts =
                getJsonPathResponse().getList(
                        "data.products.findAll { it.available == true || it.inventory.stock > 0 }.name"
                );

    }


    @Test
    public void deepNesting() {

//        Nested any / every
//✔ Any product sold in EU
        boolean soldInEU =
                getJsonPathResponse().getBoolean(
                        "data.products.any { it.inventory.locations.any { loc -> loc == 'EU' } }"
                );

//✔ Every product has at least one tag
        boolean tagsPresent =
                getJsonPathResponse().getBoolean(
                        "data.products.every { it.tags.size() > 0 }"
                );
    }


}





