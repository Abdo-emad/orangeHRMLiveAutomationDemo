package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By dashboardText = By.cssSelector(".oxd-input");

    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }
    public boolean CheckDashboardElement(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dashboardText));
        return   driver.findElement(dashboardText).isDisplayed();
    }

}
