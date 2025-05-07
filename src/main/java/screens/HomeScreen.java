package screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class HomeScreen extends Screen {
    private final IButton homeBtn = getElementFactory().getButton(By.xpath("//android.widget.FrameLayout[@content-desc=\"Home timeline\"]/android.widget.ImageView\n"),"home button");
    public HomeScreen(){
        super(By.xpath("//android.widget.TextView[@resource-id=\"org.joinmastodon.android:id/empty_text\"]"), "Home Screen");
    }
    public boolean homeScreenDisplayed(){
        return homeBtn.state().isDisplayed();
    }
}
