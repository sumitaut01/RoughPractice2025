package basics.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ReadJson {

    public static void main(String[] args) throws IOException, ParseException {

        //jsonArraySyntaxDemo.json
//
        String sPath="src//main//resources/jsonArraySyntaxDemo.json";
//        JSONParser  parser=new JSONParser();
//        FileReader fileReader=new FileReader(sPath);
//        Object obj=parser.parse(fileReader);
//        JSONObject jsonObject=(JSONObject) obj;
//        System.out.println(jsonObject.get("first_name").toString());






        //Reading with ObejectMapper
       var  data=new ObjectMapper().readValue(new File(sPath), Map[].class);
        // we are reading as map of string,objects
        System.out.println(data);

        System.out.println("hi");
    }



}
