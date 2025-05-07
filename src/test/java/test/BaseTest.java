package test;
import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected AppiumDriver driver;
    @BeforeTest
    public void setup() {
        driver = AqualityServices.getApplication().getDriver();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
