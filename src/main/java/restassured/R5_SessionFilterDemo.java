package restassured;


//In Rest Assured, a SessionFilter is a built-in filter used to store and reuse session information (like cookies) across multiple API requests — without manually handling cookies.
//It is extremely useful when working with APIs that use session-based authentication, such as:
//Web apps using login sessions
//Apps using JSESSIONID
//Apps that require login once and reuse the session for all other calls
//Form-based login systems (e.g., older web apps, some Java-based platforms)
//⭐ What is SessionFilter?
//
//SessionFilter captures session cookies from one request and automatically applies them to all subsequent requests.
//Example cookie:
//JSESSIONID
//SESSIONID
//auth_session
//
//Rest Assured normally does not keep session cookies unless you tell it to.
//SessionFilter makes this automatic.
//⭐ Why is it useful?
//✔ 1. For login-based authentication
//If your API requires login first and then uses a session cookie, you don’t want to manually extract and pass the cookie each time.
//
//✔ 2. When you need to maintain state between requests
//
//Some applications need a session to track a user’s activity.
//
//✔ 3. Avoid writing code for cookie extraction and management
//
//With SessionFilter, Rest Assured handles cookies behind the scenes.
//
//✔ 4. Works perfectly with UI-backend hybrid workflows
//
//If your backend acts like a server maintaining user state.
//
//⭐ How to Use SessionFilter (Example)
//Step 1: Create SessionFilter
//SessionFilter session = new SessionFilter();
//
//Step 2: Login and capture session
//given()
//    .filter(session)
//    .formParam("username", "admin")
//    .formParam("password", "password")
//    .post("https://example.com/login")
//    .then()
//    .statusCode(200);
//
//
//The session cookie (like JSESSIONID) is now stored.
//
//Step 3: Use the session for other requests
//given()
//    .filter(session)
//    .get("https://example.com/profile")
//    .then()
//    .statusCode(200);
//
//
//No need to set cookies manually.
//SessionFilter automatically attaches the session cookie.
//
//⭐ What happens internally?
//
//SessionFilter:
//
//Intercepts the response
//
//Extracts cookies (session cookie)
//
//Stores them
//
//Adds the stored cookies to every new request
//
//It uses Rest Assured’s Filter mechanism.
//
//⭐ When NOT to use SessionFilter?
//
//❌ When your authentication is stateless (RESTful):
//
//JWT tokens
//
//OAuth
//
//API keys
//
//Bearer tokens
//
//These don’t need session-based filtering.
//
//⭐ Summary (Interview Answer)
//
//SessionFilter in Rest Assured is used to capture and reuse session cookies (like JSESSIONID) across multiple requests.
//It is useful when APIs use session-based authentication. Instead of manually managing cookies, SessionFilter stores the session automatically and attaches it to future requests.
public class R5_SessionFilterDemo {

    //useful when session/cookie based session

}
