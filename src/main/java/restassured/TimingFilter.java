package restassured;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import static io.restassured.RestAssured.given;

public class TimingFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        long start = System.currentTimeMillis();
        Response response = ctx.next(requestSpec, responseSpec);
        long end = System.currentTimeMillis();

        System.out.println("API: " + requestSpec.getURI());
        System.out.println("Time taken: " + (end - start) + " ms");

        return response;
    }


    public static void main(String[] args) {

        given()
                .filter(new TimingFilter())
                .when()
                .get("/price");
    }
}
