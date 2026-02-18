package basics.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    public static void main(String[] args) throws IOException, ParseException {

        //jsonArraySyntaxDemo.json

        JSONParser  parser=new JSONParser();
        FileReader fileReader=new FileReader(new File("src//main//resources/jsonArraySyntaxDemo.json"));
        Object obj=parser.parse(fileReader);
        JSONObject jsonObject=(JSONObject) obj;
        System.out.println(jsonObject.get("first_name").toString());

    }
}
