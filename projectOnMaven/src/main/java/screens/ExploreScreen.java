package screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IElement;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import utils.Constants;

import java.time.Duration;
import java.util.List;

import static java.sql.DriverManager.getDriver;
import static java.sql.DriverManager.getDrivers;

public class ExploreScreen extends Screen {
    private final IButton exploreBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/tab_search"), "Explore Button");
    private final IButton exploreSearchBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/search_text"), "Explore Search Button");
    private final IButton textBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/text"), "Text Button");
    private By accCoverLocator = By.id("org.joinmastodon.android:id");
    private final IButton postLabel = getElementFactory().getButton(By.id("org.joinmastodon.android:id/reblogs"), "Posts Label");
    private By postForm = By.className("android.widget.LinearLayout");
    private final ITextBox searchTextBox = getElementFactory().getTextBox(By.className("android.widget.EditText"), "search text box");
    private final ILabel postText = getElementFactory().getLabel(By.id("org.joinmastodon.android:id/text"), "Text Button");
    private ILabel postFormLbl =getElementFactory().getLabel (postForm, "Post form");
    private ILabel accCover = getElementFactory().getLabel(accCoverLocator, "Account cover");
    private final IButton secondRelativeLayout = getElementFactory().getButton(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"]/android.widget.RelativeLayout[2]"), "second button");
    private final IElement post4 = getElementFactory().getLabel(By.xpath("//xpath_to_post_4"), "Post 4");
    private ILabel frameLayout = getElementFactory().getLabel(By.xpath("//androidx.viewpager.widget.ViewPager[@resource-id='org.joinmastodon.android:id/pager']/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]"), "Frame Layout");
    public ExploreScreen() {
        super(By.id("org.joinmastodon.android:id/search_text"), "explore screen");
    }

    public void clickExploreBtn() {
        exploreBtn.click();
    }

    public boolean explorePageDisplyed() {
        return exploreSearchBtn.state().isDisplayed();
    }

    public void clickText() {
        textBtn.click();
    }

    public boolean postIsDisplayed() {
        return postLabel.state().isDisplayed();
    }

    public int searchFieldLocationX() {
        return exploreSearchBtn.getCenter().getX();
    }

    public int searchFieldLocationY() {
        return exploreSearchBtn.getCenter().getY();
    }

    public void clickSearchField() {
        exploreSearchBtn.click();
    }

    public void enterTextIntoSearch() {
        searchTextBox.sendKeys(Constants.textForTestSearchField);
    }

    public String getTextFromSearch() {
        return searchTextBox.getText();
    }

    public void clearSeachField() {
        searchTextBox.clear();
    }
//    public void scrollToPostInProfile(int index){
//        accCover.getTouchActions().scrollToElement(SwipeDirection.DOWN);
//        int cnt=0;
//        while(cnt!=index){
//            if (postFormLbl.state().isDisplayed()){
//                postFormLbl.getTouchActions().scrollToElement(SwipeDirection.DOWN);
//                cnt++;
//            } else {
//                postFormLbl.getTouchActions().scrollToElement(SwipeDirection.DOWN);
//            }
//        }
//    }
public void scrollToPostFour(){
    int postCount = 0;
    long startTime = System.currentTimeMillis();
    long timeLimit = 300000;
    ILabel prevLbl = getElementFactory().getLabel(By.xpath("//android.widget.RelativeLayout"), "Prev Label");
    String prevTxt = prevLbl.findChildElement(By.id("org.joinmastodon.android:id/time_and_username"), ElementType.TEXTBOX).getElement().getText();
    if (prevLbl.state().isDisplayed()){
        postCount++;
    }
    while (System.currentTimeMillis()-startTime<timeLimit) {
        try {
            ILabel postElement = getElementFactory().getLabel(By.xpath("//android.widget.RelativeLayout"), "Post Element");

            if (postElement.state().isDisplayed()){
                if (!prevTxt.equals(postElement.findChildElement(By.id("org.joinmastodon.android:id/time_and_username"), ElementType.TEXTBOX).getElement().getText())){
                    prevTxt = postElement.findChildElement(By.id("org.joinmastodon.android:id/time_and_username"), ElementType.TEXTBOX).getElement().getText();
                    postCount++;
                }
                if (postCount==4){
                    break;
                }
            }
            frameLayout.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        } catch (Exception e) {
            System.out.println("Post not found");
        }
    }
}

}