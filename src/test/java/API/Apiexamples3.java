package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Apiexamples3 {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxOTM1NjksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTIzNjc2OSwidXNlcklkIjoiODMifQ.bs8dVpCx6keQWVoc8prDcoSbfpad1NX5qqbORz5L200";
@Test
    public void createAnEmployee(){
    RequestSpecification preparedrequest = given().header("Content-Type", "application/json").
            header("Authorization", token).body("{\n" +
                    "  \"emp_firstname\": \"BEN\",\n" +
                            "  \"emp_lastname\": \"50\",\n" +
                            "  \"emp_middle_name\": \"10\",\n" +
                            "  \"emp_gender\": \"M\",\n" +
                            "  \"emp_birthday\": \"2021-07-11\",\n" +
                            "  \"emp_status\": \"Employee\",\n" +
                            "  \"emp_job_title\": \"Cloud Architect\"\n" +
                            "}");
    Response response = preparedrequest.when().post("/createEmployee.php");
    response.then().assertThat().statusCode(201);
  String result= String.valueOf(response.then().assertThat().body("message",equalTo("Employee record Updated")));
    System.out.println(result);
}


}
