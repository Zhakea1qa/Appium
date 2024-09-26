package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class AppiumTest extends BaseTest {

    @Test
    public void logInTest() {
        loginPage.logIn();
        authorisePage.authorize();
        notificationPage.openNotifications();
        explorePage.exploreSearch();
    }

}
