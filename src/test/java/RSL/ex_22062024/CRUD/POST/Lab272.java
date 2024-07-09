package RSL.ex_22062024.CRUD.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab272 {

    RequestSpecification r = RestAssured.given();
    Response rp;
    ValidatableResponse vr;

    @Description("TC#1 -  Verify that create booking is working with valid payload ")
    @Test
    public void testNonBDDStylePOSTPositive() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String payload = "{\n" +
                "    \"firstname\": \"Jim\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";


        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        rp = r.when().log().all().post();
        String reponseString  = rp.asString();
        System.out.println(reponseString);

        vr = rp.then().log().all();
        vr.statusCode(200);

    }

    @Description(" Verify that create booking is not working with, 500 Error")
    @Test
    public void testNonBDDStylePOSTNegative() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String payload = "{}";


        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        rp = r.when().log().all().post();
        String reponseString  = rp.asString();
        System.out.println(reponseString);

        vr = rp.then().log().all();
        vr.statusCode(500);

    }
}
