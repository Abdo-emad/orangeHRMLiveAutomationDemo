package Listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener  implements ITestListener {
    WebDriver driver;
    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver ;
       File file= takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./Screenshots/"+ result.getMethod().getMethodName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
