package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthoriseScreen;
import screens.ExploreScreen;
import screens.HomeScreen;
import screens.WelcomeScreen;
public class AppiumTest extends BaseTest {
    protected WelcomeScreen welcomeScreen = new WelcomeScreen();
    protected AuthoriseScreen authoriseScreen = new AuthoriseScreen();
    protected HomeScreen homeScreen = new HomeScreen();
    ExploreScreen exploreScreen = new ExploreScreen();
    @Test
    public void logInTest() {
        Assert.assertTrue(welcomeScreen.isDisplayed(), "welcome screen is not displayed");
        welcomeScreen.clickLogIn();
        welcomeScreen.clickRadio();
        welcomeScreen.clickNextBtn();
        authoriseScreen.clickAuthorizeBtn();
        authoriseScreen.clickAllowBtn();
        Assert.assertTrue(homeScreen.homeScreenDisplayed(),"home screen is not displayed");
        exploreScreen.clickExploreBtn();
        Assert.assertTrue(exploreScreen.explorePageDisplyed(),"Posts screen is not opened");
        exploreScreen.clickText();
        Assert.assertTrue(exploreScreen.postIsDisplayed(),"post is not open");
    }
}
