package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//
public class R15_SerializationJackson {

    public static void main(String[] args) throws JsonProcessingException {

        Student stu = new Student("Sumit",12);
        ObjectMapper objectMapper=new ObjectMapper();
        String deser=objectMapper.writeValueAsString(stu);
        System.out.println(deser);//{"name":"Sumit","age":12}

    }

}
