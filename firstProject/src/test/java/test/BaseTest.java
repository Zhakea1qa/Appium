//package test;
//
//import aquality.appium.mobile.application.AqualityServices;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MultiTouchAction;
//import org.testng.annotations.*;
//
//public class BaseTest {
//    protected AppiumDriver driver;
//    @BeforeMethod
//    public void setup() {
//        driver = AqualityServices.getApplication().getDriver();
//    }
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//
//    }
//}
