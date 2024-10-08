package screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class AuthoriseScreen extends Screen {
    private final IButton authorizeBtn = getElementFactory().getButton(By.xpath("//android.widget.Button[@text=\"Authorize\"]"), "authorize button");
    private final IButton notificationTab = getElementFactory().getButton(By.id("com.android.permissioncontroller:id/permission_allow_button"), "allow button");

    public AuthoriseScreen() {
        super(By.xpath("//android.widget.Button[@text=\"Authorize\"]"), "Authorize Screen");
    }

    public void clickAuthorizeBtn() {
        authorizeBtn.state().waitForDisplayed();
        authorizeBtn.click();

    }
    public void clickNotificationTab(){
        notificationTab.click();
    }

}
