package objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class R_01ReadJson {

    public static void main(String[] args) throws IOException {

 // Json Array Map[].class
        ObjectMapper objectMapper=new ObjectMapper();
        List<Map<String,String>> lHm= Arrays.asList
                (objectMapper.readValue(new File("src//main//java//objectmapper//data.json"), Map[].class));
        System.out.println(lHm);//[{username=admin, password=admin123}, {username=user1, password=pass123}]
        System.out.println(lHm.get(0).get("username"));//admin


        TT tt=new TT(34,"Sumit",12);

        ObjectMapper obj=new ObjectMapper();
        String stt=obj.writeValueAsString(tt);//java object to json string
        System.out.println(stt);//{"age":34,"name":"Sumit","salary":12}




        //json string to java object
        ObjectMapper objx=new ObjectMapper();
        TT ttx=new TT(34,"Sumit",14);

        System.out.println(objx.writeValueAsString(ttx));//{"age":34,"name":"Sumit","salary":14}



       TT ttx11= objx.readValue(objx.writeValueAsString(ttx), TT.class);

        System.out.println(ttx11);







        //

        // json is single object now and not an array.. below will run into error
        //Exception in thread "main" com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize value of type `java.util.Map<java.lang.Object,java.lang.Object>[]` from Object value (token `JsonToken.START_OBJECT`)
        // at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]
//        List<Map<String,String>> lHm2= Arrays.asList
//                (objectMapper.readValue(new File("src//main//java//objectmapper//singlejson.json"), Map[].class));
//        System.out.println(lHm2);
//        System.out.println("hi");

// notice Map.class instead of Map[].class
        Map<String,String> lHm2=
                (objectMapper.readValue(new File("src//main//java//objectmapper//singlejson.json"), Map.class));
        System.out.println(lHm2);
        System.out.println("hi");























    }
}



@AllArgsConstructor
@NoArgsConstructor
@ToString

class TT{
   int age;
   String name;
   transient  int salary=200;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
