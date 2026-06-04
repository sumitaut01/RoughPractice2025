package restassured;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class JSonPropertyHolder {

    public static void main(String[] args) throws JsonProcessingException {


    EmployeeX emp = new EmployeeX(
            1,
            "Sumit",
            new AddressX("India", "Pune", "Maharashtra")
    );

        String json = new ObjectMapper().writeValueAsString(emp);
        System.out.println(json);


 //this order obeyed @JsonPropertyOrder({"id","address", "name" })
//{"id":1,"address":{"city":"Pune","state":"Maharashtra","country":"India"},"name":"Sumit"}


}
}


@JsonPropertyOrder({"id","address", "name" })
@AllArgsConstructor
@Getter
 class EmployeeX {
    private int id;
    private String name;
    private AddressX address;

}

@JsonPropertyOrder({"city", "state", "country"})
@AllArgsConstructor
@Getter
 class AddressX {
    private String country;
    private String city;
    private String state;
}