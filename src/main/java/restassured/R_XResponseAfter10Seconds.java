package restassured;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


//Commonly Tuned Parameters
//
//Here are a few useful params you might see in RestAssured + Apache HttpClient:
//
//Parameter	Meaning
//http.connection.timeout	Max time (ms) to establish connection with server.
//http.socket.timeout	Max time (ms) waiting for data after connection established.
//http.connection-manager.timeout	Max time (ms) waiting for a connection from connection pool.
//http.connection.stalecheck	Whether to check if a connection is still valid before reusing.

public class R_XResponseAfter10Seconds {

    public static void main(String[] args) {
       Response10SecondDelayHandled();

        Response10SecondDelayNOTHandled();//Exception in thread "main" java.net.SocketTimeoutException: Read timed out
    }





    static void Response10SecondDelayHandled() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://httpbin.org");
        request.basePath("/delay/{valuefordelayinseconds} ");
        request.pathParam("valuefordelayinseconds", 5);
        request.accept(ContentType.JSON);
        RestAssuredConfig config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        //setParam("http.connection.timeout", 5000));//if fails to establish connection with server
        .setParam("http.socket.timeout", 8000));//Response expected in this time
        request.config(config);

        request.post().then().log().all();

        //HTTP/1.1 200 OK
        //Date: Wed, 27 Aug 2025 09:24:17 GMT
        //Content-Type: application/json
        //Content-Length: 543
        //Connection: keep-alive
        //Server: gunicorn/19.9.0
        //Access-Control-Allow-Origin: *
        //Access-Control-Allow-Credentials: true
        //
        //{
        //    "args": {
        //
        //    },
        //    "data": "",
        //    "files": {
        //
        //    },
        //    "form": {
        //
        //    },
        //    "headers": {
        //        "Accept": "application/json, application/javascript, text/javascript, text/json",
        //        "Accept-Encoding": "gzip,deflate",
        //        "Content-Length": "0",
        //        "Content-Type": "application/x-www-form-urlencoded; charset=ISO-8859-1",
        //        "Host": "httpbin.org",
        //        "User-Agent": "Apache-HttpClient/4.5.13 (Java/21.0.2)",
        //        "X-Amzn-Trace-Id": "Root=1-68aecebb-74e66b1f5cb96a5339a6d299"
        //    },
        //    "origin": "114.69.230.38",
        //    "url": "https://httpbin.org/delay/5"
        //}
        //
        //Process finished with exit code 0


    }


    static void Response10SecondDelayNOTHandled() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://httpbin.org");
        request.basePath("/delay/{valuefordelayinseconds} ");
        request.pathParam("valuefordelayinseconds", 10);
        request.accept(ContentType.JSON);
        RestAssuredConfig config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        //.setParam("http.connection.timeout", 4000));//Response is coming after 5 and we only wait 4 seconds

        .setParam("http.socket.timeout", 4000));//Gemini suggested this
        //By changing the parameter to http.socket.timeout, you are telling RestAssured to fail if it doesn't receive the complete response within 4 seconds, which will cause the test to fail when the server delays for 10 seconds.
        request.config(config);

        request.post().then().log().all();


    }
}
