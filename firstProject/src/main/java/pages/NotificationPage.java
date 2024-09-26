package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NotificationPage extends Base {
    private By notificationTab = new By.ById("com.android.permissioncontroller:id/permission_allow_button");

    public NotificationPage(AppiumDriver driver) {
        super(driver);
    }

    public void openNotifications() {
        click(notificationTab);
    }
}

