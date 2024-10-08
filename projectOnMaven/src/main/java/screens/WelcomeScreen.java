package screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class WelcomeScreen extends Screen {
    private final ILabel welcomeLabel = getElementFactory().getLabel(By.xpath("//android.widget.FrameLayout[@resource-id=\"org.joinmastodon.android:id/fragment_wrap\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView"), "Welcome Label");
    private final IButton logInBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_log_in"), "log in button");
    private final IButton radioBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/radiobtn"), "radio button");
    private final IButton nextBtn = getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_next"), "next button ");

    public WelcomeScreen() {
        super(By.xpath("org.joinmastodon.android:id/blue_fill"), "Welcome Screen");
    }

    public boolean isDisplayed() {
        return welcomeLabel.state().waitForDisplayed();
    }

    public void clickLogIn() {
        logInBtn.click();
    }

    public void clickRadioBtn() {
        radioBtn.click();
    }

    public void clickNextbtn() {
        nextBtn.click();
    }
}