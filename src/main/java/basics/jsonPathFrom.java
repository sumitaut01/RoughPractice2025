package basics;

import io.restassured.path.json.JsonPath;

public class jsonPathFrom {

    public static void main(String[] args) {

        String single= """
                {
                     "name": "Sumit",
                     "age": 34,
                     "salary": 10000
                   }
                """;


        String data = """
                            
                [
                   {
                     "name": "Sumit",
                     "age": 34,
                     "salary": 10000
                   },
                   {
                     "name": "Amit",
                     "age": 40,
                     "salary": 4000
                   }
                 ]
                                
                    
                """;


        System.out.println(JsonPath.from(data).getString("age"));//[34, 40] //notice we used string for double and it works

        System.out.println(JsonPath.from(data).getString("name"));//[Sumit, Amit]


        System.out.println(JsonPath.from(data).getString("[0].name"));//Sumit

        System.out.println(JsonPath.from(data).getString("[1].name"));//Amit


       // System.out.println(JsonPath.from(data).getInt("age"));//failing when muliple objects

        System.out.println(JsonPath.from(single).getInt("age"));// works on single 34


    }
}
