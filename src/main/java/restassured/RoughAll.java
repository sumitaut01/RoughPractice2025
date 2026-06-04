package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class RoughAll {

    public static void main(String[] args) throws JsonProcessingException {


        Response response = RestAssured.given().header("", "")
                .contentType(ContentType.JSON)
                .baseUri("")
                .basePath("")
                .queryParam("S", "s")
                .pathParam("pathparakey", "2")
                .auth().oauth2(" ")
                .post("{pathparakey}/somemoreurl");

        System.out.println("titme take is " + response.getTime());


        JsonPath jsonpath = response.jsonPath();

        Temp t = response.as(Temp.class);


        ObjectMapper objectMapper = new ObjectMapper();
        Temp xx = objectMapper.readValue(response.asString(), Temp.class);


    }


    @Test
    public void roughagain() {

        Response response = RestAssured.given().
                baseUri("")
                .basePath("")
                .header("", "")
                .contentType(ContentType.JSON)
                .queryParam("", "")
                .pathParam("", "")
                .body("")
                .post();


        JsonPath resp = response.jsonPath();

        resp.get("");
        resp.getMap("");


    }


    @Test
    public void RoughRA() {

        Response resp = RestAssured.given().baseUri("").basePath("").header("", "")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("", "")
                .queryParam("", "")
                .post();


        //new ObjectMapper().readValue(resp, TypeReferenceDemo)


    }


    @Test
    public void Rough290426() {

        Response response = RestAssured.given().baseUri("").basePath("")
                .queryParam("", "")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("first", "order")
                .header("", "").auth().oauth2(" ")
                .body("").post("/{first}");
        JsonPath respJsonPath = response.jsonPath();
        var x = response.as(Map[].class);
    }


    @Test
    public void Rough020626() {


        Response response = RestAssured.given().baseUri("https://swapi.info/").basePath("api")
                .get();

        System.out.println(response.time());//968
        System.out.println(response.jsonPath().getMap("$"));
        /*
        {
        films=https://swapi.info/api/films,
        people=https://swapi.info/api/people,
        planets=https://swapi.info/api/planets,
         species=https://swapi.info/api/species,
         vehicles=https://swapi.info/api/vehicles,
          starships=https://swapi.info/api/starships
          }
         */

       JsonPath jsonPath= response.jsonPath();

        System.out.println("---------");
        System.out.println(jsonPath.getString("films"));//https://swapi.info/api/films





        //
        System.out.println("pathparametr");
        Response resp=
        RestAssured.given().baseUri("https://swapi.info/").basePath("films")
                .pathParam("id", 1)
                .get("/{id}");

        System.out.println(resp.asPrettyString());
        System.out.println(resp.asString());

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        System.out.println(response.headers());
        /*
        Date=Wed, 03 Jun 2026 03:29:32 GMT
Content-Type=application/json
Content-Length=279
Connection=keep-alive
Accept-Ranges=bytes
access-control-allow-headers=Content-Type
access-control-allow-methods=GET, OPTIONS
access-control-allow-origin=*
Age=43241
Cache-Control=public, max-age=0, must-revalidate, no-store
cache-status="Netlify Edge"; fwd=miss
etag="c1074317587ab33f1a099355a6403e6a-ssl"
Server=cloudflare
strict-transport-security=max-age=31536000
x-nf-request-id=01KT4F7B1MA7JD7EXZQM65NDKE
cf-cache-status=HIT
Nel={"report_to":"cf-nel","success_fraction":0.0,"max_age":604800}
Report-To={"group":"cf-nel","max_age":604800,"endpoints":[{"url":"https://a.nel.cloudflare.com/report/v4?s=mXaDEtTBbX4J73gwPRWxcZXGSw1kc6kLnmjvqsJZe5i8GOYakNijcXxZbLXz3pB72mJZnd4hFiVnNxNPJfoT75%2F%2FF3WvI%2BC74am6oE1Ca82wqQ6qoYA%2B5j%2BTpbOk"}]}
CF-RAY=a05b9d32c926387e-BOM
alt-svc=h3=":443"; ma=86400

         */
        System.out.println(response.body());//comes as object  io.restassured.internal.RestAssuredResponseImpl@440ba649

        System.out.println(response.body().asString());
        /*

        {
	"films": "https://swapi.info/api/films",
	"people": "https://swapi.info/api/people",
	"planets": "https://swapi.info/api/planets",
	"species": "https://swapi.info/api/species",
	"vehicles": "https://swapi.info/api/vehicles",
	"starships": "https://swapi.info/api/starships"
}
         */

        System.out.println(response.then().extract().body().asString());
        /*
        {
	"films": "https://swapi.info/api/films",
	"people": "https://swapi.info/api/people",
	"planets": "https://swapi.info/api/planets",
	"species": "https://swapi.info/api/species",
	"vehicles": "https://swapi.info/api/vehicles",
	"starships": "https://swapi.info/api/starships"
}
         */

    }


}


class Temp {


}
