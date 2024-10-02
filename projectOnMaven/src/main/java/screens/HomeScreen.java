package screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class HomeScreen extends Screen {
    private final ILabel homeBtn = getElementFactory().getLabel(By.id("org.joinmastodon.android:id/empty_text"),"home button");

    public HomeScreen(){
        super(By.xpath("//android.widget.TextView[@resource-id=\"org.joinmastodon.android:id/empty_text\"]"), "Home Screen");
    }
    public boolean homeScreenDisplayed(){

        return homeBtn.state().waitForDisplayed();
    }
}
