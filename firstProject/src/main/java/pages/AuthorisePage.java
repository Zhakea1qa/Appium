package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
public class AuthorisePage extends Base {
    public static final String AUTHORIZE_BTN = "//android.widget.Button[@text='Authorize']";
    private By authorizeButton = new By.ByXPath(AUTHORIZE_BTN);
    public AuthorisePage(AppiumDriver driver) {
        super(driver);
    }
    public void authorize() {
        click(authorizeButton);
    }
}
