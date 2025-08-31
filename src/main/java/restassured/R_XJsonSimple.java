package restassured;

import org.json.simple.JSONObject;

import java.util.HashMap;


public class R_XJsonSimple {

    public static void main(String[] args) {


        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Name", "sumit");
        jsonObject.put("Age", "35");

        JSONObject localAddress = new JSONObject();  //note we created new jsonobject and not hashmap
        localAddress.put("Street", "123");
        localAddress.put("Landmark", "Grain Shoppe");
        jsonObject.put(localAddress, "LocalAddress");
        System.out.println(jsonObject);//{"{\"Landmark\":\"Grain Shoppe\",\"Street\":\"123\"}":"LocalAddress","Age":"35","Name":"sumit"}


        //we can pass it in restassured body  jsonObject.toString()


    }
}
