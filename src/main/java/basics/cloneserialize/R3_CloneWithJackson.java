package basics.cloneserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.common.mapper.TypeRef;

public class R3_CloneWithJackson {

    public static void main(String[] args) {

        MyObject obj1=new MyObject("Sumit",38);
        MyObject obj2=obj1;

        obj1.age=35;

        System.out.println(obj1);
        System.out.println(obj2);
        //MyObject{name='Sumit', age=35}
        //MyObject{name='Sumit', age=35}


        ObjectMapper objectMapper=new ObjectMapper();
        MyObject o3=objectMapper.convertValue(obj1, MyObject.class);

        System.out.println(o3);//MyObject{name='Sumit', age=35}

        o3.age=40;

        System.out.println(o3);//MyObject{name='Sumit', age=40}











    }
}



class MyObject{
    public String name;
    public int age;

    public String getName() { return name; }
    public int getAge() { return age; }
    public MyObject(String name,int age){
     this.name=name;
     this.age=age;
    }

    public MyObject(){

    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
