package objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class R_01ReadJson {

    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper=new ObjectMapper();
        List<Map<String,String>> lHm= Arrays.asList
                (objectMapper.readValue(new File("src//main//java//objectmapper//data.json"), Map[].class));
        System.out.println(lHm);//[{username=admin, password=admin123}, {username=user1, password=pass123}]
        System.out.println(lHm.get(0).get("username"));//admin


        






    }
}
