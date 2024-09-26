package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends Base
{
    public static final String LOGIN_BUTTON_ID = "org.joinmastodon.android:id/btn_log_in";
    public static final String RADIO_BUTTON_ID = "org.joinmastodon.android:id/radiobtn";
    public static final String NEXT_BUTTON_ID = "org.joinmastodon.android:id/btn_next";
    private By loginButton = new By.ById(LOGIN_BUTTON_ID);
    private By radioButton = new By.ById(RADIO_BUTTON_ID);
    private By nextButton = new By.ById(NEXT_BUTTON_ID);

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    public void logIn() {
        click(loginButton);
        click(radioButton);
        click(nextButton);
    }
}
