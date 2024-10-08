package screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import utils.Constants;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class ExploreScreen extends Screen {

    private final IButton exploreBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/tab_search"), "Explore Button");
    private final IButton exploreSearchBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/search_text"), "Explore Search Button");
    private final IButton textBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/text"), "Text Button");
    private final IButton postLabel = getElementFactory().getButton(By.id("org.joinmastodon.android:id/reblogs"), "Posts Label");
    private final ITextBox searchTextBox = getElementFactory().getTextBox(By.className("android.widget.EditText"), "search text box");
    private final ILabel frameLayout = getElementFactory().getLabel(By.xpath("//androidx.viewpager.widget.ViewPager[@resource-id='org.joinmastodon.android:id/pager']/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]"), "Frame Layout");
    private final By firstPostLocator = By.id("org.joinmastodon.android:id/time_and_username");
    private final ILabel postName = getElementFactory().getLabel(By.id("org.joinmastodon.android:id/name"), "Locator post label");

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

    public void swipe(int count) {
        postLabel.state().waitForDisplayed();
        for (int i = 1; i < count; i++) {
            frameLayout.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        }

    }

    public boolean namePostDisplayed() {
        return postName.state().waitForDisplayed();
    }

    public String getFirstPostText() {
        ILabel firstPost = getElementFactory().getLabel(firstPostLocator, "First Post");
        return firstPost.getText();
    }

    public void swipeUp() {
        frameLayout.getTouchActions().scrollToElement(SwipeDirection.UP);
    }

    public void swipeToFirstPost() {
        String previousFirstPostText = getFirstPostText();
        while (true) {
            swipeUp();
            String currentFirstPostText = getFirstPostText();
            if (previousFirstPostText.equals(currentFirstPostText)) {
                break;
            }
            previousFirstPostText = currentFirstPostText;
        }
    }

    public void swipeDown() {
        AndroidDriver driver = (AndroidDriver) AqualityServices.getApplication().getDriver();
        Dimension dimension = driver.manage().window().getSize();

        int startX = dimension.width / 2;
        int startY = (int) (dimension.height * 0.7);
        int endY = (int) (dimension.height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeMultipleTimes(int times) {
        for (int i = 0; i < times; i++) {
            swipeDown();
        }
    }

}