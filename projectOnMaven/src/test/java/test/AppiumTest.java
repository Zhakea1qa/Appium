package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthoriseScreen;
import screens.ExploreScreen;
import screens.HomeScreen;
import screens.WelcomeScreen;
import utils.Constants;

import static utils.Constants.apkName;


public class AppiumTest extends BaseTest {
    protected WelcomeScreen welcomeScreen = new WelcomeScreen();
    protected AuthoriseScreen authoriseScreen = new AuthoriseScreen();
    protected HomeScreen homeScreen = new HomeScreen();
    ExploreScreen exploreScreen = new ExploreScreen();

    @Test(enabled = false)
    public void logInTest() {
        Assert.assertTrue(welcomeScreen.isDisplayed(), "welcome screen is not displayed");
        mobileApplication.terminate(apkName);
        mobileApplication.activate(apkName);
        Assert.assertTrue(welcomeScreen.isDisplayed(), "welcome screen is not displayed");
        welcomeScreen.clickLogIn();

        authoriseScreen.clickAuthorizeBtn();

        Assert.assertTrue(homeScreen.homeScreenDisplayed(),"home screen is not displayed");

        exploreScreen.clickExploreBtn();
        Assert.assertTrue(exploreScreen.explorePageDisplyed(),"Posts screen is not opened");
        exploreScreen.clickText();
        Assert.assertTrue(exploreScreen.postIsDisplayed(),"post is not open");
    }
    @Test(enabled = false)
    public void intesctionWithElement(){
        Assert.assertTrue(welcomeScreen.isDisplayed(),"welcome screen is not displayed");
        welcomeScreen.clickLogIn();
        authoriseScreen.clickAuthorizeBtn();
        Assert.assertTrue(homeScreen.homeScreenDisplayed(),"home screen is not displayed");
        exploreScreen.clickExploreBtn();
        Assert.assertTrue(exploreScreen.explorePageDisplyed(),"post is not displayed state");
        Assert.assertTrue(exploreScreen.searchFieldLocationX() > 0 && exploreScreen.searchFieldLocationY() > 0, "Element is not properly positioned.");
        exploreScreen.clickSearchField();
        exploreScreen.enterTextIntoSearch();
        Assert.assertTrue(Constants.textForTestSearchField.equals(exploreScreen.getTextFromSearch()), "text is not equal");
        exploreScreen.clearSeachField();
        Assert.assertTrue(Constants.defoldText.equals(exploreScreen.getTextFromSearch()),"text from the search is not equal with defold text");
    }
    @Test(enabled = false)
    public void keyboardProcessing(){
        Assert.assertTrue(welcomeScreen.isDisplayed(),"welcome screen is not displayed");
        welcomeScreen.clickLogIn();
        authoriseScreen.clickAuthorizeBtn();
        Assert.assertTrue(homeScreen.homeScreenDisplayed(),"home screen is not displayed");
        exploreScreen.clickExploreBtn();
        Assert.assertTrue(exploreScreen.explorePageDisplyed(),"post is not displayed state");
        exploreScreen.clickSearchField();


    }
    @Test(enabled = true)
    public void swipes(){
        welcomeScreen.clickLogIn();
        authoriseScreen.clickAuthorizeBtn();
        Assert.assertTrue(homeScreen.homeScreenDisplayed(),"home screen is not displayed");
        exploreScreen.clickExploreBtn();
        Assert.assertTrue(exploreScreen.explorePageDisplyed(),"post is not displayed state");
        exploreScreen.scrollToPostFour();

    }
}
 