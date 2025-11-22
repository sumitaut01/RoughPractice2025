package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;

import java.util.List;


//json object to Java Object
public class R16_DeSerializationJackson {

    public static void main(String[] args) throws JsonProcessingException {


        //When Single Object
        String json = """
                    {
                    "name": "Sumit",
                    "age":12
                     }
                """;


        ObjectMapper objectMapper=new ObjectMapper();
        Student stu= objectMapper.readValue(json, Student.class);
        System.out.println(stu);//Student{name='Sumit', age=12}


        System.out.println(stu.getAge());
        System.out.println(stu.getName());


        //When Array
        String jsonArray = """
                   [ {
                    "name": "Sumit",
                    "age":38
                     },
                     {
                    "name": "Amit",
                    "age":41
                     }
                     
                     ]
                     
                     
                """;


        //via jsonpath
        System.out.println("---via jasonPath----");
        List<Student> stuArr= new JsonPath(jsonArray).getList("", Student.class);
        System.out.println(stuArr);//[Student{name='Sumit', age=38}, Student{name='Amit', age=41}]


        System.out.println("---via Jackson----");
        Student[] stuArrJackson=new ObjectMapper().readValue(jsonArray, Student[].class);
        for(Student s:stuArrJackson){
            System.out.println(s.toString());
            //Student{name='Sumit', age=38}
            //Student{name='Amit', age=41}
        }





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
