package RSL.testNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class Lab263 {

    @Description("TC#1 - Verify GET request 1")
    @Test
    public void getRequest(){
        System.out.println("TC1");
    }

    @Description("TC#1 - Verify GET request 2")
    @Test(enabled = false)
    public void getRequest2(){
        System.out.println("TC2");
    }

    @Description("TC#1 - Verify GET request 3")
    @Test
    public void getRequest3(){
        System.out.println("TC3");
    }

}
