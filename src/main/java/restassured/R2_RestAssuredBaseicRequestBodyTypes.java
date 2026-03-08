package restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class R2_RestAssuredBaseicRequestBodyTypes {



    @Test
    public void withJsonObject(){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("username", "sumit");
        jsonObject.put("lastname", "raut");
        System.out.println(jsonObject.toJSONString());//{"username":"sumit","lastname":"raut"}
        // this can be passed in bosy jsonObject.toJSONString()


    }

}
