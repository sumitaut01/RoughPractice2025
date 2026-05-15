package restassured.soapproject;

//Difference
//Folder	Purpose
//src/main/resources	Application resources
//src/test/resources	Test resources



//http://www.dneonline.com/calculator.asmx?op=Add
/*
POST /calculator.asmx HTTP/1.1
Host: www.dneonline.com
Content-Type: text/xml; charset=utf-8
Content-Length: length
SOAPAction: "http://tempuri.org/Add"

<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <Add xmlns="http://tempuri.org/">
      <intA>int</intA>
      <intB>int</intB>
    </Add>
  </soap:Body>
</soap:Envelope>
 */

/*

HTTP/1.1 200 OK
Content-Type: text/xml; charset=utf-8
Content-Length: length

<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <AddResponse xmlns="http://tempuri.org/">
      <AddResult>int</AddResult>
    </AddResponse>
  </soap:Body>
</soap:Envelope>


 */

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

public class R1_Soap {

    @Test
    public void method1(){

        String baseUrl="http://www.dneonline.com";

        String SBody= """
                <soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
                  <soap:Body>
                    <Add xmlns="http://tempuri.org/">
                      <intA>2</intA>
                      <intB>3</intB>
                    </Add>
                  </soap:Body>
                </soap:Envelope>
                """;
       Response response= RestAssured.given()
                .baseUri(baseUrl).basePath("/calculator.asmx")
                //.contentType(ContentType.XML)
                .contentType("text/xml")
                .accept(ContentType.XML)
                .body(SBody)
                .post();


        XmlPath  xmlPath=response.xmlPath();
        System.out.println(xmlPath.get());//5
        System.out.println(response.statusCode());//200


        response.then()
                .statusCode(200)
                .body(hasXPath(
                        "//*[local-name()='AddResult']",
                        equalTo("5")
                ));


        //failing right now

        response.then()
                .assertThat()
                .body(matchesXsdInClasspath("xsd1.xsd"));



    }
}
