package RSL.ex_ra01;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;

public class Lab261 {

    public static void main(String[] args) {

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(200);
    }
}
