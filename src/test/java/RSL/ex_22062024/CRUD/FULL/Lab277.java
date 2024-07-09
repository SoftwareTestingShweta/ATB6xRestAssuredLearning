package RSL.ex_22062024.CRUD.FULL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Lab277 {

    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void getAToken(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        // Extract the Token from this

        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getBookingId(){

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        String reponseString = response.asString();
        System.out.println(reponseString);

        validatableResponse.statusCode(200);

        // Extract the bookingId from this

        bookingId = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);

    }

    @Test
    public void testPUTRequestPositive(){
        // token and BookingID
        System.out.println(" - Test Case PUT Request ");

        String payload = "{\n" +
                "    \"firstname\" :\"Tanavi\",\n" +
                "    \"lastname\" : \"Telka\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-11\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast, lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+ bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token" , token);

        // PUT request

        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().put();

        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);

        // *************************************************************************

        String fullResponseJSONString = response.asString();
        System.out.println(fullResponseJSONString);

        // Verify all the keys and value pairs in the response
        // firstname, lastname, deposit, totla,. checkin


        // 3 Ways You can verify the response

        // 1. RA - Matchers

        validatableResponse.body("firstname", Matchers.equalTo("Tanavi"));
        validatableResponse.body("lastname", Matchers.equalTo("Telka"));

        //  2. TestNG Asserts -
        //  Assert.assertEquals(firstNameResponse,"Tanavi");

        String firstNameResp = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResp, "Tanavi");

        // 3 TestNG Assertion with JSON Path Lib

        JsonPath jsonPath = new JsonPath(fullResponseJSONString);
        String firstNameJSONPathExtracted = jsonPath.getString("firstname");
        String lastNameJSONPathExtracted = jsonPath.getString("lastname");
        Integer totalpriceJSONPathExtracted = jsonPath.getInt("totalprice");
        Boolean depositpaidJSONPathExtracted = jsonPath.getBoolean("depositpaid");
        String checkin = jsonPath.getString("bookingdates.checkin");
        String checkout = jsonPath.getString("bookingdates.checkout");

        Assert.assertEquals(firstNameJSONPathExtracted , "Tanavi");
        Assert.assertEquals(lastNameJSONPathExtracted, "Telka");
        Assert.assertEquals(totalpriceJSONPathExtracted,123);
        Assert.assertEquals(depositpaidJSONPathExtracted,true);
        Assert.assertEquals(checkin,"2024-01-01");
        Assert.assertEquals(checkout,"2024-01-11");

        // 4. Assert J

        assertThat(firstNameJSONPathExtracted)
                .isEqualTo("Tanavi").isNotBlank().isNotEmpty();

        assertThat(totalpriceJSONPathExtracted)
                .isNotZero().isNotNegative();

    }
}
