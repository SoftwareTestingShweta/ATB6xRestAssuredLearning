package RSL.ex_27062024.payloadFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class Lab298 {

    RequestSpecification r = RestAssured.given();
    Response rp;
    ValidatableResponse vr;

    @Test
    public void testPayloadFile() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        File file = new File("src/test/resources/postRequest.json");


        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON);
        r.body(file).log().all();

        rp = r.when().log().all().post();
        String reponseString  = rp.asString();
        System.out.println(reponseString);

        vr = rp.then().log().all();
        vr.statusCode(200);

    }
}
