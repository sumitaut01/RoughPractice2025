package restassured;

public class R8_FormParam {



}

//You said:
//In RestAssured, form parameters are the key-value pairs you send in a HTML form submission — usually with:
//
//Content-Type: application/x-www-form-urlencoded
//
//or multipart/form-data (for file uploads)
//
//They are often used in:
//
//Login forms
//
//OAuth token requests
//
//Web forms
//
//Old-style APIs
//
//✅ 1. Basic formParam example
//Sending form parameters to an endpoint
//given()
//    .baseUri("https://api.example.com")
//    .formParam("username", "sumit")
//    .formParam("password", "secret123")
//.when()
//    .post("/login")
//.then()
//    .statusCode(200);
//
//
//Behind the scenes, RestAssured sends this body:
//
//username=sumit&password=secret123
//
//
//with header:
//
//Content-Type: application/x-www-form-urlencoded
//
//✅ 2. Using multiple form params with a map
//Map<String, String> form = new HashMap<>();
//form.put("client_id", "abc");
//form.put("client_secret", "xyz");
//form.put("grant_type", "password");
//
//given()
//    .formParams(form)
//.when()
//    .post("/oauth/token")
//.then()
//    .statusCode(200);
//
//✅ 3. OAuth Token Request Example (Real-life)
//
//This is where form parameters are used most commonly:
//
//given()
//    .contentType("application/x-www-form-urlencoded")
//    .formParam("grant_type", "password")
//    .formParam("client_id", "myClientId")
//    .formParam("client_secret", "myClientSecret")
//    .formParam("username", "sumit")
//    .formParam("password", "pass123")
//.when()
//    .post("/oauth/token")
//.then()
//    .statusCode(200);
//
//✅ 4. Form Params vs Query Params vs Body
//Type	Where it goes	Example
//formParam	Body (URL-encoded)	username=sumit
//queryParam	URL ?key=value	/login?user=sumit
//body()	Raw JSON/XML	{"username":"sumit"}
//✅ 5. When do you use formParam?
//
//Use formParam when server expects:
//
//application/x-www-form-urlencoded
//
//HTML form fields
//
//OAuth 2.0 requests
//
//Login forms
//
//Payment gateways (old APIs)
//
//DO NOT use formParam when an API expects JSON — use body() instead.
//
//If you want, I can show you:
//
//✔ multipart file upload example
//✔ form parameters + headers example
//✔ how to capture cookies after login
//
//Just tell me!




