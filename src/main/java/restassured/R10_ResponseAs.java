package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R10_ResponseAs {

    //String
    //byte aaray
    /// saving as json
    ///
    public static void main(String[] args) {

        WireMockServer wireMockServer = new WireMockServer(8089); // custom port
        wireMockServer.start();
        wireMockServer.stubFor(post(urlEqualTo("/api/path/1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\n" +
                                "  \"userProfile\": {\n" +
                                "    \"userId\": \"usr_123456\",\n" +
                                "    \"username\": \"coder_guru\",\n" +
                                "    \"email\": \"coder.guru@example.com\",\n" +
                                "    \"isVerified\": true,\n" +
                                "    \"lastLogin\": \"2025-09-19T21:29:53Z\",\n" +
                                "    \"preferences\": {\n" +
                                "      \"theme\": \"dark\",\n" +
                                "      \"notifications\": {\n" +
                                "        \"email\": true,\n" +
                                "        \"push\": false,\n" +
                                "        \"sms\": false\n" +
                                "      },\n" +
                                "      \"language\": \"en-US\"\n" +
                                "    },\n" +
                                "    \"location\": {\n" +
                                "      \"city\": \"San Francisco\",\n" +
                                "      \"country\": \"USA\",\n" +
                                "      \"coordinates\": {\n" +
                                "        \"latitude\": 37.7749,\n" +
                                "        \"longitude\": -122.4194\n" +
                                "      }\n" +
                                "    }\n" +
                                "  },\n" +
                                "  \"recentActivity\": [\n" +
                                "    {\n" +
                                "      \"activityId\": \"act_987654\",\n" +
                                "      \"type\": \"post_creation\",\n" +
                                "      \"timestamp\": \"2025-09-19T20:50:00Z\",\n" +
                                "      \"details\": {\n" +
                                "        \"postId\": \"pst_112233\",\n" +
                                "        \"title\": \"Introduction to Complex JSON\",\n" +
                                "        \"tags\": [\"JSON\", \"data-structures\", \"web-dev\"],\n" +
                                "        \"views\": 150\n" +
                                "      }\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"activityId\": \"act_654321\",\n" +
                                "      \"type\": \"comment_submission\",\n" +
                                "      \"timestamp\": \"2025-09-19T21:10:15Z\",\n" +
                                "      \"details\": {\n" +
                                "        \"commentId\": \"cmt_445566\",\n" +
                                "        \"postId\": \"pst_112233\",\n" +
                                "        \"commentText\": \"This is a great example!\",\n" +
                                "        \"authorId\": \"usr_998877\"\n" +
                                "      }\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"projects\": [\n" +
                                "    {\n" +
                                "      \"projectId\": \"proj_101\",\n" +
                                "      \"projectName\": \"API Gateway\",\n" +
                                "      \"status\": \"in-progress\",\n" +
                                "      \"teamMembers\": [\n" +
                                "        {\n" +
                                "          \"memberId\": \"dev_001\",\n" +
                                "          \"name\": \"Alice Johnson\",\n" +
                                "          \"role\": \"Lead Developer\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"memberId\": \"dev_002\",\n" +
                                "          \"name\": \"Bob Williams\",\n" +
                                "          \"role\": \"Backend Developer\"\n" +
                                "        }\n" +
                                "      ],\n" +
                                "      \"milestones\": [\n" +
                                "        {\n" +
                                "          \"milestoneId\": \"ms_01\",\n" +
                                "          \"name\": \"Initial Design\",\n" +
                                "          \"dueDate\": \"2025-10-15\",\n" +
                                "          \"completed\": true\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"milestoneId\": \"ms_02\",\n" +
                                "          \"name\": \"Beta Release\",\n" +
                                "          \"dueDate\": \"2025-12-01\",\n" +
                                "          \"completed\": false\n" +
                                "        }\n" +
                                "      ]\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"projectId\": \"proj_102\",\n" +
                                "      \"projectName\": \"Data Analytics Dashboard\",\n" +
                                "      \"status\": \"completed\",\n" +
                                "      \"teamMembers\": [\n" +
                                "        {\n" +
                                "          \"memberId\": \"dev_003\",\n" +
                                "          \"name\": \"Charlie Brown\",\n" +
                                "          \"role\": \"Data Scientist\"\n" +
                                "        }\n" +
                                "      ],\n" +
                                "      \"milestones\": [\n" +
                                "        {\n" +
                                "          \"milestoneId\": \"ms_03\",\n" +
                                "          \"name\": \"Data Integration\",\n" +
                                "          \"dueDate\": \"2025-08-20\",\n" +
                                "          \"completed\": true\n" +
                                "        }\n" +
                                "      ]\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"isDeletable\": false,\n" +
                                "  \"lastUpdatedBy\": \"admin_user\"\n" +
                                "}")));


        Response response = RestAssured.given()
                .baseUri("http://localhost:8089")
                .basePath("/api/")
                .pathParam("path", "path")
                .contentType(ContentType.JSON)
                .header("key", "value")
                .accept(ContentType.JSON)
                .body("some string")
                .post("{path}" + "/1");


        String resp = response.asString();
        JsonPath jsonpath = response.jsonPath();
        byte[] bArray = response.asByteArray();
        wireMockServer.stop();


    }
}
