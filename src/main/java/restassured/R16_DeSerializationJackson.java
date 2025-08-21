package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//json object to Java Object
public class R16_DeSerializationJackson {

    public static void main(String[] args) throws JsonProcessingException {

        String json = """
                    {
                    "name": "Sumit",
                    "age":12
                     }
                """;


        ObjectMapper objectMapper=new ObjectMapper();
        Student stu= objectMapper.readValue(json, Student.class);
        System.out.println(stu);//Student{name='Sumit', age=12}



    }

}


class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
