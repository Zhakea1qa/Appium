package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected AppiumDriver driver;
    private static final int TIMEOUT = 10;
    public Base(AppiumDriver driver) {
        this.driver = driver;
    }
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click(By locator) {
        waitForElement(locator).click();
    }
    public void sendKeys(By locator, String inputText) {
        waitForElement(locator).sendKeys(inputText);
    }
}
