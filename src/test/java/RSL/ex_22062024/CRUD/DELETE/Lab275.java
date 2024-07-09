package RSL.ex_22062024.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab275 {

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;
        String token ="1a9d574e5c41e37";
        String bookingId = "493";

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        @Test
        public void testNonBDDStyleDeletePositive() {

            String Base_Path_Updated = Base_Path + "/" + bookingId;
            System.out.println(Base_Path_Updated);

            rs.baseUri(Base_URL);
            rs.basePath(Base_Path_Updated);
            rs.contentType(ContentType.JSON);
            rs.cookie("token", token);
            rs.log().all();

            response = rs.when().log().all().delete();

            vr = response.then().log().all();
            vr.statusCode(201);


        }
    }

