package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AuthoriseScreenStep;
import steps.ExploreScreenStep;
import steps.HomeScreenStep;
import steps.WelcomeScreenStep;
import utils.Constants;

import static utils.Constants.apkName;


public class AppiumTest extends BaseTest {

    protected WelcomeScreenStep welcomeScreenStep = new WelcomeScreenStep();
    protected AuthoriseScreenStep authoriseScreenStep = new AuthoriseScreenStep();
    protected HomeScreenStep homeScreenStep = new HomeScreenStep();
    protected ExploreScreenStep exploreScreenStep = new ExploreScreenStep();

    @Test(enabled = false)
    public void logInTest() {
        Assert.assertTrue(welcomeScreenStep.homeScreenDisplayed(), "welcome screen is not displayed");
        mobileApplication.terminate(apkName);
        mobileApplication.activate(apkName);
        Assert.assertTrue(welcomeScreenStep.homeScreenDisplayed(), "welcome screen is not displayed");
        welcomeScreenStep.authoriseStep();
        authoriseScreenStep.clickAuthorizeBtn();
        Assert.assertTrue(homeScreenStep.homeScreenDisplayed(), "home screen is not displayed");
        exploreScreenStep.clickExploreBtn();
        Assert.assertTrue(exploreScreenStep.explorePageDisplyed(), "Posts screen is not opened");
        exploreScreenStep.clickText();
        Assert.assertTrue(exploreScreenStep.postIsDisplayed(), "post is not open");
    }

    @Test(enabled = false)
    public void intesctionWithElement() {
        Assert.assertTrue(welcomeScreenStep.homeScreenDisplayed(), "welcome screen is not displayed");
        welcomeScreenStep.authoriseStep();
        authoriseScreenStep.clickAuthorizeBtn();
        Assert.assertTrue(homeScreenStep.homeScreenDisplayed(), "home screen is not displayed");
        exploreScreenStep.clickExploreBtn();
        Assert.assertTrue(exploreScreenStep.explorePageDisplyed(), "post is not displayed state");
        Assert.assertTrue(exploreScreenStep.searchFieldLocationX() > 0 && exploreScreenStep.searchFieldLocationY() > 0, "Element is not properly positioned.");
        exploreScreenStep.clickSearchField();
        exploreScreenStep.enterTextIntoSearch();
        Assert.assertTrue(Constants.textForTestSearchField.equals(exploreScreenStep.getTextFromSearch()), "text is not equal");
        exploreScreenStep.clearSeachField();
        Assert.assertTrue(Constants.defaultText.equals(exploreScreenStep.getTextFromSearch()), "text from the search is not equal with defold text");
    }

    @Test(enabled = false)
    public void keyboardProcessing() {
        Assert.assertTrue(welcomeScreenStep.homeScreenDisplayed(), "welcome screen is not displayed");
        welcomeScreenStep.authoriseStep();
        authoriseScreenStep.clickAuthorizeBtn();
        Assert.assertTrue(homeScreenStep.homeScreenDisplayed(), "home screen is not displayed");
        exploreScreenStep.clickExploreBtn();
        Assert.assertTrue(exploreScreenStep.explorePageDisplyed(), "post is not displayed state");
        exploreScreenStep.clickSearchField();

    }

    @Test(enabled = true)
    public void swipes() {
        welcomeScreenStep.authoriseStep();
        authoriseScreenStep.clickAuthorizeBtn();
        Assert.assertTrue(homeScreenStep.homeScreenDisplayed(), "home screen is not displayed");
        exploreScreenStep.clickExploreBtn();
        Assert.assertTrue(exploreScreenStep.explorePageDisplyed(), "post is not displayed state");
        exploreScreenStep.swipe(4);
        Assert.assertTrue(exploreScreenStep.namePostDisplayed(), "4 posts is not displayed");
        exploreScreenStep.swipeToFirstPost();
        Assert.assertTrue(exploreScreenStep.namePostDisplayed(), "first post is not displayed");
        exploreScreenStep.swipeToTwenty(20);
    }
}
 