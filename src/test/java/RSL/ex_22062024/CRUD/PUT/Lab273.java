package RSL.ex_22062024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab273 {

    RequestSpecification  rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token ="1a9d574e5c41e37";
    String bookingId = "493";

    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";

    @Test
    public void testNonBDDStylePOSTPositive() {

        String Base_Path_Updated = Base_Path+ "/" + bookingId;
        System.out.println(Base_Path_Updated);

        String payload = "{\n" +
                "    \"firstname\" :\"Savi\",\n" +
                "    \"lastname\" : \"Telka\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast, lunch\"\n" +
                "}";

        rs.baseUri(Base_URL);
        rs.basePath(Base_Path_Updated);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);
        rs.body(payload).log().all();

        response = rs.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Savi"));
        vr.body("lastname", Matchers.equalTo("Telka"));


    }
}
