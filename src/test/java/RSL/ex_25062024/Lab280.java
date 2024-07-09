package RSL.ex_25062024;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab280 {

    @Issue("TC123")
    @AllureId("TC#1")
    @Severity(SeverityLevel.NORMAL)
    @Description("Regression Testcase")
    @Test(groups = {"Regression"},priority = 2)
    public void RegRun() {
        System.out.println("Reg");
    }

    @Test(groups = {"sanity"},priority = 1)
    public void SanityRun() {
        System.out.println("sanity");
    }

    @Test(groups = {"smoke"},priority = 3)
    public void SmokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "prod"},priority = 3)
    public void QARun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"prod"},priority = 3)
    public void ProdRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
