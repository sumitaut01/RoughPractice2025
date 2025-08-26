package restassured;

import io.restassured.path.json.JsonPath;

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

    }
}
