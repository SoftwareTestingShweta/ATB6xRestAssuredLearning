package RSL.ex_27062024.gson.serlization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab292 {

    // Payload - String, Map
    // Most Used - Class and Objects.
    // Swagger API - Document , File IO Binary File Payload
    // Non BDD - API Automation -

    // Cucumber BDD  - suite - Framework -. Cucumber BDD (Feature Files, Glue Other)


    // Payload -> RA -> Class or Objects -> JSONString ( Who Help, Library) - Serialization
    // Response -> jsonString -> Class or OBject ( Deserialization)

    //{
    //            "firstname" : "Jim",
    //    //                "lastname" : "Brown",
    //                "totalprice" : 111,
    //                "depositpaid" : true,
    //                "bookingdates" : {
    //            "checkin" : "2018-01-01",
    //                    "checkout" : "2019-01-01"
    //        },
    //            " " : "Breakfast"
    //        }

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testCaseGson(){

        String base_URL = "https://restful-booker.herokuapp.com";
        String Base_path = "/booking";


        Booking booking = new Booking();
        booking.setFirstname("Savi");
        booking.setLastname("Telka");
        booking.setTotalprice(145);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-11");
        booking.setBookingdates(bookingdates);

        System.out.println(booking.toString());

        rs.baseUri(base_URL);
        rs.basePath(Base_path);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(booking);

        response = rs.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.statusCode(200);



    }





}
