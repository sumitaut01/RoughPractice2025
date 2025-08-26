package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R_XMultiRecords {


    public static void main(String[] args) throws JsonProcessingException {


        WireMockServer wireMockServer = new WireMockServer(8089); // custom port
        wireMockServer.start();
        wireMockServer.stubFor(post(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("[\n" +
                                "  {\n" +
                                "    \"orderId\": \"ORD-123456789\",\n" +
                                "    \"customer\": {\n" +
                                "      \"customerId\": \"CUST-987654321\",\n" +
                                "      \"firstName\": \"John\",\n" +
                                "      \"lastName\": \"Doe\",\n" +
                                "      \"email\": \"john.doe@example.com\",\n" +
                                "      \"shippingAddress\": {\n" +
                                "        \"street\": \"123 Main Street\",\n" +
                                "        \"city\": \"Anytown\",\n" +
                                "        \"state\": \"CA\",\n" +
                                "        \"zipCode\": \"12345\",\n" +
                                "        \"country\": \"USA\"\n" +
                                "      },\n" +
                                "      \"billingAddress\": {\n" +
                                "        \"street\": \"123 Main Street\",\n" +
                                "        \"city\": \"Anytown\",\n" +
                                "        \"state\": \"CA\",\n" +
                                "        \"zipCode\": \"12345\",\n" +
                                "        \"country\": \"USA\"\n" +
                                "      }\n" +
                                "    },\n" +
                                "    \"items\": [\n" +
                                "      {\n" +
                                "        \"itemId\": \"ITEM-001\",\n" +
                                "        \"productName\": \"Wireless Mouse\",\n" +
                                "        \"quantity\": 2,\n" +
                                "        \"pricePerUnit\": 25.50,\n" +
                                "        \"totalPrice\": 51.00,\n" +
                                "        \"attributes\": {\n" +
                                "          \"color\": \"black\",\n" +
                                "          \"brand\": \"Logitech\"\n" +
                                "        }\n" +
                                "      }\n" +
                                "    ],\n" +
                                "    \"orderStatus\": \"Processing\",\n" +
                                "    \"createdAt\": \"2025-08-26T10:30:00Z\"\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"orderId\": \"ORD-987654321\",\n" +
                                "    \"customer\": {\n" +
                                "      \"customerId\": \"CUST-111222333\",\n" +
                                "      \"firstName\": \"Jane\",\n" +
                                "      \"lastName\": \"Smith\",\n" +
                                "      \"email\": \"jane.smith@example.com\",\n" +
                                "      \"shippingAddress\": {\n" +
                                "        \"street\": \"456 Oak Avenue\",\n" +
                                "        \"city\": \"Someplace\",\n" +
                                "        \"state\": \"NY\",\n" +
                                "        \"zipCode\": \"67890\",\n" +
                                "        \"country\": \"USA\"\n" +
                                "      }\n" +
                                "    },\n" +
                                "    \"items\": [\n" +
                                "      {\n" +
                                "        \"itemId\": \"ITEM-004\",\n" +
                                "        \"productName\": \"Laptop Sleeve\",\n" +
                                "        \"quantity\": 1,\n" +
                                "        \"pricePerUnit\": 30.00,\n" +
                                "        \"totalPrice\": 30.00\n" +
                                "      },\n" +
                                "      {\n" +
                                "        \"itemId\": \"ITEM-005\",\n" +
                                "        \"productName\": \"External SSD\",\n" +
                                "        \"quantity\": 1,\n" +
                                "        \"pricePerUnit\": 150.00,\n" +
                                "        \"totalPrice\": 150.00\n" +
                                "      }\n" +
                                "    ],\n" +
                                "    \"orderStatus\": \"Shipped\",\n" +
                                "    \"createdAt\": \"2025-08-25T14:45:00Z\"\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"orderId\": \"ORD-555444333\",\n" +
                                "    \"customer\": {\n" +
                                "      \"customerId\": \"CUST-444555666\",\n" +
                                "      \"firstName\": \"Peter\",\n" +
                                "      \"lastName\": \"Jones\",\n" +
                                "      \"email\": \"peter.jones@example.com\",\n" +
                                "      \"shippingAddress\": {\n" +
                                "        \"street\": \"789 Pine Lane\",\n" +
                                "        \"city\": \"Elsewhere\",\n" +
                                "        \"state\": \"TX\",\n" +
                                "        \"zipCode\": \"11223\",\n" +
                                "        \"country\": \"USA\"\n" +
                                "      }\n" +
                                "    },\n" +
                                "    \"items\": [\n" +
                                "      {\n" +
                                "        \"itemId\": \"ITEM-006\",\n" +
                                "        \"productName\": \"Monitor Stand\",\n" +
                                "        \"quantity\": 1,\n" +
                                "        \"pricePerUnit\": 45.00,\n" +
                                "        \"totalPrice\": 45.00\n" +
                                "      }\n" +
                                "    ],\n" +
                                "    \"orderStatus\": \"Delivered\",\n" +
                                "    \"createdAt\": \"2025-08-24T09:15:00Z\"\n" +
                                "  }\n" +
                                "]")));


        Response response = RestAssured.given().baseUri("http://localhost:8089/api/users").post();
        System.out.println(response.then().log().all());


       //Orders[] orders= response.as(Orders[].class);

        ObjectMapper objectMapper=new ObjectMapper();
        ArrayList<Orders> orders = (ArrayList<Orders>)
                objectMapper.readValue(response.asString(), new TypeReference<List<Orders>>() {});


        System.out.println(response.jsonPath().getString("[0].orderId"));//ORD-123456789
        System.out.println(response.jsonPath().getString("[0].customer.customerId"));//CUST-987654321


        System.out.println(orders.toString());


    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Orders {
    String orderId;
    String orderStatus;
    String createdAt;
    Customer customer;
    Items[] Items;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Customer {
    String customerId;
    String firstName;
    String lastName;
    String email;
    ShippingAddress shippingAddress;
    BillingAddress billingAddress;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ShippingAddress {
    String street;
    String city;
    String state;
    String zipCode;
    String country;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class BillingAddress {
    String street;
    String city;
    String state;
    String zipCode;
    String country;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Items {
    String itemId;
    String productName;
    String quantity;
    String pricePerUnit;
    String totalPrice;

    //Approach 1
   // since attribute may or may not be there.... we are using map below
    // Use a Map to handle the flexible attributes field
   // private Map<String, Object> attributes;

    //Approach 2
    Attributes attributes; // uncomment class declaration
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Attributes{
       String color;
       String brand;
}
