package restassured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import java.io.File;
import java.util.List;

public class R_0BasicJson {
    //1. Print No of courses returned by API
    //2.Print Purchase Amount
    //3. Print Title of the first course
    //4. Print All course titles and their respective Price
    //5. Print no of copies sold by RPA Course
    //6. Verify if Sum of all Course prices matches with Purchase Amount

    public static void main(String[] args) {


        JsonPath jsonPath=new JsonPath(new File("src/main/java/restassured/BasicJson.json"));

       // JsonPath jsonPath=JsonPath.from(new File("src/main/java/restassured/BasicJson.json"));

        //    //1. Print No of courses returned by API
        System.out.println("----1----");
        System.out.println((jsonPath.getList("courses").size()));

        //2.Print Purchase Amount
        System.out.println("----2----");
        System.out.println((jsonPath.getDouble("dashboard.purchaseAmount")));


        //3. Print Title of the first course
        System.out.println("----3----");
        System.out.println((jsonPath.getString("courses[0].title")));


        ////4. Print All course titles and their respective Price
        System.out.println("----4----");
        System.out.println(jsonPath.getList("courses.title"));

        //  //5. Print no of copies sold by RPA Course


        System.out.println("----5----");
        //5. Print no of copies sold by RPA Course
        for(int i=0;i<jsonPath.getList("courses").size();i++){
            if(jsonPath.getString("courses["+i+"].title").equalsIgnoreCase("rpa")){
                System.out.println(jsonPath.getDouble("courses["+i+"].copies"));
            }

        }


        //5.1

        String copiesRPAfindAll =
                jsonPath.getString("courses.findAll { it.title == 'RPA' }.copies");

        System.out.println(copiesRPAfindAll);//10



        String copiesRPAfind =
                jsonPath.getString("courses.find { it.title == 'RPA' }.copies");

        System.out.println(copiesRPAfind);//10


                // //6. Verify if Sum of all Course prices matches with Purchase Amount

        System.out.println("----6----");
                Double pa=jsonPath.getDouble("dashboard.purchaseAmount");

        double total = jsonPath.getList("courses.price")
                .stream()
                .mapToDouble(x -> Double.parseDouble(x.toString()))
                .sum();

        Assert.assertEquals(pa, total);//expected [135.0] but found [910.0]
        //add logic to consider copies also... right now we skipped it

    }
}
