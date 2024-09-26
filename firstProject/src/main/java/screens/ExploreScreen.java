package screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ExploreScreen extends Screen {
    private final IButton exploreBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/tab_search"),"Explore Button");
    private final IButton exploreSearchBtn = getElementFactory().getButton(By.id(
            "org.joinmastodon.android:id/search_text"),"Explore Button");
    private final IButton textBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/text"),"Text Button");
    private final IButton postLabel = getElementFactory().getButton(By.id("org.joinmastodon.android:id/reblogs"),"Posts Label");
    public ExploreScreen(){
        super(By.id("org.joinmastodon.android:id/search_text"),"explore screen");
    }
    public void clickExploreBtn(){
        exploreBtn.click();
    }
    public boolean explorePageDisplyed(){
        return exploreSearchBtn.state().isDisplayed();
    }
    public void clickText(){
        textBtn.click();
    }
    public boolean postIsDisplayed(){
        return postLabel.state().isDisplayed();
    }

}
