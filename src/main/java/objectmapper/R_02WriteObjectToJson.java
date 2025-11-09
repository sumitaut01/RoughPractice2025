package objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class R_02WriteObjectToJson {



    @Test
    public void writeJsonObject() throws IOException {

        TestObject t1=new TestObject();
        TestObject t2=new TestObject();

        t1.setName("Sumit");
        t1.setSalary(10);

        t2.setName("Amit");
        t2.setSalary(20);

        ObjectMapper objectMapper=new ObjectMapper();
       // String st1=objectMapper.writeValueAsString(t1);


        //Writing to file
        //make sure that class has getters/setters
        //works without implements serialazble on class
        //No, you don’t need to implement Serializable for Jackson to work.

        objectMapper.writeValue(new File("src/main/java/objectmapper/writefromobject.json"),t1); //works
        //{"salary":10,"name":"Sumit"}




        List<TestObject> myList= List.of(t1, t2);
        objectMapper.writeValue(new File("src/main/java/objectmapper/writefromobjectwithlist.json"),myList); //works
       //[{"salary":10,"name":"Sumit"},{"salary":20,"name":"Amit"}]












    }


}


class TestObject {
 private int  salary;
 private String name;


 public TestObject(int Salary, String name){
   this.name=name;
     this.salary=salary;
 }

public TestObject(){};

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
