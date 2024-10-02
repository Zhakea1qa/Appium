package test;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.application.IMobileApplication;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected AppiumDriver driver;
    protected IMobileApplication mobileApplication;

    @BeforeTest
    public void setup() {
        driver =AqualityServices.getApplication().getDriver();
        mobileApplication = AqualityServices.getApplication();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
