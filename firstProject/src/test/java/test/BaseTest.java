package test;

import Utils.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Utils.CapabilitiesLoader;
import pages.AuthorisePage;
import pages.ExplorePage;
import pages.LoginPage;
import pages.NotificationPage;
import java.net.MalformedURLException;
import java.net.URL;
public class BaseTest {

    protected static AppiumDriver driver;
    protected LoginPage loginPage;
    protected AuthorisePage authorisePage;
    protected ExplorePage explorePage;
    protected NotificationPage notificationPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // Инициализация драйвера и страниц
        DesiredCapabilities cap = CapabilitiesLoader.loadCapabilities(Constants.CAPABILITIES_PATH);
        URL url = new URL(Constants.APPIUM_SERVER_URL);
        driver = new AppiumDriver(url, cap);
        loginPage = new LoginPage(driver);
        authorisePage = new AuthorisePage(driver);
        explorePage = new ExplorePage(driver);
        notificationPage = new NotificationPage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
