package screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import utils.Constants;

public class ExploreScreen extends Screen {
    private final IButton exploreBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/tab_search"), "Explore Button");
    private final IButton exploreSearchBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/search_text"), "Explore Search Button");
    private final IButton textBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/text"), "Text Button");
    private final IButton postLabel = getElementFactory().getButton(By.id("org.joinmastodon.android:id/reblogs"), "Posts Label");
    private final ITextBox searchTextBox = getElementFactory().getTextBox(By.className("android.widget.EditText"), "search text box");
    private ILabel frameLayout = getElementFactory().getLabel(By.xpath("//androidx.viewpager.widget.ViewPager[@resource-id='org.joinmastodon.android:id/pager']/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]"), "Frame Layout");
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

}