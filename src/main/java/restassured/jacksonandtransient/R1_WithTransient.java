package restassured.jacksonandtransient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class R1_WithTransient {




    public static void main(String[] args) throws JsonProcessingException {


        Dummy d1=new Dummy("sumit", 200);
        String d1s= new ObjectMapper().writeValueAsString(d1);
        System.out.println(d1s);//{"name":"sumit"}  Objectmapper respects transiet field by default

        System.out.println("--Separator-----");


        DummyWithToString d2=new DummyWithToString("sumit", 200);
        String d2s= new ObjectMapper().writeValueAsString(d2);
        System.out.println(d2s);//


        System.out.println("--Separator-----");

        DummyWithToStringLombok d3=new DummyWithToStringLombok("sumit", 200);
        String d3s= new ObjectMapper().writeValueAsString(d3);
        System.out.println(d3s);//

        System.out.println("--Separator-----");

    }

}



//class 1
class Dummy {
    public String name;
    public transient int salry;

    // 1 No Stirng method
    Dummy(String name, int salry) {
        this.name = name;
        this.salry = salry;
    }

}



//class 2
class DummyWithToString{
    public String name;
    public transient  int salry;
    public DummyWithToString(String name,int salry){
        this.name=name;
        this.salry=salry;
    }

    @Override
    public String toString() {
        return "DummyWithToString{" +
                "name='" + name + '\'' +
                ", salry=" + salry +
                '}';
    }
}


//3 //class 3
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@ToString(exclude = "salry")
class DummyWithToStringLombok {
    public String name;
    public transient int salry;

}

