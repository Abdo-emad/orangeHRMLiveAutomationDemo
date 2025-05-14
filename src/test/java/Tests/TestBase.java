package Tests;

import Pages.LoginPage;
import Helper.ReadURLFromPropFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod()
    @Parameters({"browser"})
    public void SetUp(@Optional("chrome") String browserName) throws IOException {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }else {
            driver= new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(ReadURLFromPropFile.ReadURLFromFile("baseURI"));
        loginPage = new LoginPage(driver);
    }
  /*  @AfterMethod
    public void takeScreenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./ScreenShots/"+result.getName()+".png"));

        }
    }*/
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }


}
