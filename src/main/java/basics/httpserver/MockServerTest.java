package basics.httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MockServerTest {

    private HttpServer server;
    private static final int PORT = 8080;

    @BeforeClass
    public void startMockServer() throws Exception {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/employee", exchange -> {
            String response =
                    """
                    {
                        "id":101,
                        "name":"Sumit"
                    }
                    """;
            exchange.getResponseHeaders()
                    .add("Content-Type", "application/json");
            exchange.getResponseHeaders()
                    .add("X-Environment", "TEST");
            exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
            );
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });
        server.start();
        System.out.println("Mock Server Started");
    }

    @Test
    public void verifyEmployeeEndpoint() throws Exception {

        URL url = new URL("http://localhost:8080/employee");
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        String contentType =
                connection.getHeaderField("Content-Type");
        String envHeader =
                connection.getHeaderField("X-Environment");
        Assert.assertEquals(statusCode, 200);
        Assert.assertTrue(contentType.contains("application/json"));
        Assert.assertEquals(envHeader, "TEST");
        System.out.println("Status : " + statusCode);
        System.out.println("Content-Type : " + contentType);
        System.out.println("X-Environment : " + envHeader);
    }


    @Test
    public void verifyEmployeeEndpoint_RA() {
        given()
                .when()
                .get("http://localhost:8080/employee")
                .then()
                .statusCode(200)
                .header("X-Environment", "TEST")
                .contentType("application/json")
                .body("name", equalTo("Sumit"))
                .body("id", equalTo(101));
    }

    @AfterClass
    public void stopMockServer() {

        if (server != null) {
            server.stop(0);
            System.out.println("Mock Server Stopped");
        }
    }
}