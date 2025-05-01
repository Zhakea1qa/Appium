package hooks;

import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseHooks {

    protected AppiumDriver driver;


    @Before
    public void setup() {
        driver = AqualityServices.getApplication().getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
