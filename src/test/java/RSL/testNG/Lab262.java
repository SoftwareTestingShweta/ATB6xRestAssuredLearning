package RSL.testNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab262 {

    @Description("TC#1 -  Verify 262 GET request 1")
    @Test
    public void getRequest(){

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }

    @Description("TC#1 -  Verify 262 GET request 2")
    @Test
    public void getRequest2(){

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }
}
