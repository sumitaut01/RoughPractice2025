package restassured;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.build.ToStringPlugin;

public class R17_JsonIncludeIngoreDefaults {


    public static void main(String[] args) throws JsonProcessingException {


        Employee emp=new Employee();
        emp.setName("Sumit");

        ObjectMapper mapper = new ObjectMapper();
       // mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);

        String json = mapper.writeValueAsString(emp);
        System.out.println(json);//{"name":"Sumit"}  Ignored default values




    }

}

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
class Employee{

    String name;
    int salary;
    String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}



