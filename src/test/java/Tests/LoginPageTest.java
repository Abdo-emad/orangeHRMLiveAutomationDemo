package Tests;

import Helper.ReadValidDataFromJson;
import Pages.DashBoardPage;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class LoginPageTest extends TestBase{
    SoftAssert softAssert = new SoftAssert();

    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    ReadValidDataFromJson readValidDataFromJson;

    @Test
    public void SuccessLogin() throws IOException, ParseException {
        readValidDataFromJson=new ReadValidDataFromJson();
        readValidDataFromJson.ReadValidCredentialsOnly();
        loginPage.setUserNameField(readValidDataFromJson.userName);
        loginPage.setUPasswordField(readValidDataFromJson.password);
        DashBoardPage dashBoardPage=loginPage.clickOnLoginButton();
        softAssert.assertTrue(dashBoardPage.CheckDashboardElement());
    }
    @Test
    public void loginByInvalidPassword() throws IOException, ParseException {
        readValidDataFromJson= new ReadValidDataFromJson();
        readValidDataFromJson.ReadValidCredentialsOnly();
        loginPage.setUserNameField(readValidDataFromJson.userName);
        loginPage.setUPasswordField(readValidDataFromJson.password + "Invalid");
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.CheckInvalidCredentialsErrorMessage());
    }
    @Test
    public void loginByInvalidUserName() throws IOException, ParseException {
        readValidDataFromJson= new ReadValidDataFromJson();
        readValidDataFromJson.ReadValidCredentialsOnly();
        loginPage.setUserNameField(readValidDataFromJson.userName+"Invalid");
        loginPage.setUPasswordField(readValidDataFromJson.password);
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.CheckInvalidCredentialsErrorMessage());
    }

    @Test
    public void loginByLeavingAllFieldsEmpty(){
        loginPage.setUserNameField("");
        loginPage.setUPasswordField("");
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.CheckRequiredErrorMessageWhileLeavingAllFieldsEmpty());
    }


}
