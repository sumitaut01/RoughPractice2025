package restassured;

import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class R19_JsonPath {

    public static void main(String[] args) {


        String simple1= """
                {
                  "store": {
                    "book": [
                      {
                        "category": "fiction",
                        "author": "Sumit",
                        "price": 10
                      },
                      {
                        "category": "tech",
                        "author": "Sagar",
                        "price": 20
                      }
                    ]
                  }
                }   
                """;


        JsonPath jsonpath=new JsonPath(simple1);
        System.out.println(jsonpath.getString("store.book[0].category"));//fiction
        System.out.println(jsonpath.getString("store.book[0].price"));//10
        System.out.println(jsonpath.getInt("store.book[0].price"));//10
        System.out.println(jsonpath.getString("$"));//[store:[book:[[category:fiction, author:Sumit, price:10], [category:tech, author:Sagar, price:20]]]]
        System.out.println(jsonpath.getList("store.book"));//[{category=fiction, author=Sumit, price=10}, {category=tech, author=Sagar, price=20}]

        System.out.println(jsonpath.getList("book"));//null


       //Without Root
        String jsonArrayString = "{\r\n" +
                "  \"firstName\": \"Amod\",\r\n" +
                "  \"lastName\": \"Mahajan\",\r\n" +
                "  \"address\": [\r\n" +
                "    {\r\n" +
                "      \"type\": \"permanent\",\r\n" +
                "      \"city\": \"Bengaluru\",\r\n" +
                "      \"state\": \"KA\"\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"type\": \"temp\",\r\n" +
                "      \"city\": \"Bhopal\",\r\n" +
                "      \"state\": \"MP\"\r\n" +
                "    }\r\n" +
                "  ]\r\n" +
                "}";
        JsonPath jsonpath2=new JsonPath(jsonArrayString);
        System.out.println(jsonpath2.getList("address"));//[{type=permanent, city=Bengaluru, state=KA}, {type=temp, city=Bhopal, state=MP}]

        List<Map<String,Object>> allAddress =jsonpath2.getList("address");
        for(Map<String,Object> address : allAddress)
        {
            System.out.println(address);
        }
        //{type=permanent, city=Bengaluru, state=KA}
        //{type=temp, city=Bhopal, state=MP}



        //3  Nested array

        String data = """
{
  "firstName": "Amod",
  "lastName": "Mahajan",
  "address": [
    [
      {
        "type": "permanent",
        "city": "Bengaluru",
        "state": "KA"
      },
      {
        "type": "temp",
        "city": "Bhopal",
        "state": "MP"
      }
    ],
    [
      {
        "type": "communication",
        "city": "Delhi",
        "state": "DL"
      },
      {
        "type": "old",
        "city": "Kanpur",
        "state": "UP"
      }
    ]
  ]
}
""";


        JsonPath jsonpath3=new JsonPath(data);

        System.out.println(jsonpath3.getString("address[0].type"));//[permanent, temp]
        System.out.println(jsonpath3.getString("address[1].type"));//[communication, old]


        System.out.println(jsonpath3.getString("address[0][0].type"));//permanent
        System.out.println(jsonpath3.getString("address[0][1].type"));//temp
        System.out.println(jsonpath3.getString("address[1][0].type"));//communication
        System.out.println(jsonpath3.getString("address[1][1].type"));//old





        //How to validate that JSON array contains object with specific key-value?
        //.body("find { it.id == 10 }.name", equalTo("John"));






        System.out.println(jsonpath3.getString("address.findAll{it->it.type}.type"));
        //[[permanent, temp], [communication, old]]
    }
}
