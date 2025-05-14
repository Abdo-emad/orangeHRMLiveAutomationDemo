package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By userNameField = By.cssSelector("[name='username']");
    private final By passwordField = By.cssSelector("[type='password']");
    private final By submitButton = By.cssSelector("[type='submit']");
    private final By invalidCredentialsMessage = By.xpath(" //p[contains(.,'Invalid credentials')]");
    private final By requiredMessage = By.xpath("//span[contains(.,'Required')]");
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    public void setUserNameField(String userName){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setUPasswordField(String password){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }
    public DashBoardPage clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(submitButton));
        submitButton.findElement(driver).click();
        return new DashBoardPage(driver);
    }


    public boolean CheckInvalidCredentialsErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(invalidCredentialsMessage));
        return   driver.findElement(invalidCredentialsMessage).isDisplayed();
    }

    public boolean CheckRequiredErrorMessageWhileLeavingAllFieldsEmpty(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(requiredMessage));
        List<WebElement> elements = driver.findElements(requiredMessage);
        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                return false;
            }

        }
        return true;
    }
}
