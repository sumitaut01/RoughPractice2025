package restassured.aiandpojos;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class R1_OpenAIWork {
    @Test
    public void generateData() throws JsonProcessingException {

        generateUsernames(5);




    }


    public static List<String> generateUsernames(int count) throws JsonProcessingException {

        String prompt = "Generate " + count +
                " unique random usernames. " +
                "Rules: Only lowercase letters and numbers. " +
                "No spaces. Between 6 and 12 characters. " +
                "Return output strictly as a JSON array.";

        String requestBody = """
        {
          "model": "gpt-4.1-mini",
          "input": "%s"
        }
        """.formatted(prompt);

        Response response =
                given()
                        .baseUri("https://api.openai.com/v1/responses")
                        .header("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY"))
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .post()
                        .then()
                        .extract().response();

        String result = response.jsonPath()
                .getString("output[0].content[0].text");

        return new ObjectMapper().readValue(result, List.class);
    }
}
