package basics.Generics.Rough;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.common.mapper.TypeRef;

public class ResponseGeneric {


    public static void main(String[] args) throws JsonProcessingException {

        String data= """
                
                 {
                 "nameXX": "Sumit",
                 "age":38,
                 "extra": "extra"
                 }
                """;


        Dem dem=getObject(data, Dem.class);
        System.out.println(dem); //Dem{name='Sumit', age=38}


        DemIgnoreUnknownFalse dem2=getObject(data, DemIgnoreUnknownFalse.class);
        System.out.println(dem2);//Unrecognized field "extra"r



    }
         public static <T>T  getObject(String json, Class<T> clazz) throws JsonProcessingException {
            return new ObjectMapper().readValue(json, clazz);
         }
}


@JsonIgnoreProperties(ignoreUnknown = true) //to bypass extra
class Dem {
    @JsonProperty("nameXX")  //notice the json input. this would match
    public String name;
    public Integer age;

    @Override
    public String toString() {
        return "Dem{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}




    @JsonIgnoreProperties(ignoreUnknown = false) //to bypass extra
    class DemIgnoreUnknownFalse{
        @JsonProperty("nameXX")  //notice the json input. this would match
        public String name;
        public Integer age;


        @Override
        public String toString() {
            return "DemIgnoreUnknownFalse{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }




