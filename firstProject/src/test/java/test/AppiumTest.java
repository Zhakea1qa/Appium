package test;
import aquality.appium.mobile.actions.ITouchActions;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementFactory;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IElement;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.selenium.core.elements.ElementState;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class AppiumTest extends BaseTest {
    private final ITouchActions touchActions = AqualityServices.getTouchActions();
   // private final IButton newButton = AqualityServices.getElementFactory().getButton(By.id(""), "");
    private final IButton pickAnotherServerBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_get_started"), "pich another server");
    private final ILabel mastodonLbl = AqualityServices.getElementFactory().getLabel(By.xpath("@text='mastodon.uno']"),"label");
    private final IButton nextBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_next"), "next button");
    private final ILabel rulesLabel = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[@text='Server rules']"), "fsad") ;
    private final ILabel yourPrivacyLabel = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[@text='Your privacy']"), "fsad") ;
    private final ITextBox userNameTextBox = AqualityServices.getElementFactory().getTextBox(By.id("org.joinmastodon.android:id/username"), " text box");
    private final ITextBox mastodonUno = AqualityServices.getElementFactory().getTextBox(By.id("org.joinmastodon.android:id/domain"), " text box");
    AndroidDriver driver = (AndroidDriver) AqualityServices.getApplication().getDriver();

@DataProvider(name = "loginData")
public Object[][] loginDataProvider() {
    return new Object[][]{
            {"mas.to"},
            {"c.im"}
    };
}
    @Test(dataProvider = "loginData")
    public void logInTest(String data) {

//        pickAnotherServerBtn.state().waitForClickable();
        pickAnotherServerBtn.click();
        ILabel label  = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("//*[@text = '%s']", data)), "fsfds");
        //MobileElement elementByXpath = driver.findElement(By.xpath("//*[contains(@class, 'menu_item')]"));'
//
        label.click();
        nextBtn.state().waitForClickable();
        nextBtn.click();
        rulesLabel.state().waitForExist();
        nextBtn.click();
        yourPrivacyLabel.state().waitForExist();
        nextBtn.click();
        userNameTextBox.state().waitForExist();
        Assert.assertEquals(mastodonUno.getText(),"@"+data);
//        driver.openNotifications();

     }
     @Test(enabled = false)
    public void proverka(){

        SoftAssert.getSoftAssertions().assertThat(1 == 2).as("1 не равен 2").isTrue();
        SoftAssert.getSoftAssertions().assertThat(1 == 1).as("один не равен 1").isTrue();
        SoftAssert.getSoftAssertions().assertThat("str" != "str").as("str not equal str").isTrue();
        SoftAssert.assertAll();
     }

}



//AndroidDriver androidDriver = (AndroidDriver) AqualityServices.getApplication().getDriver();
//        androidDriver.openNotifications();

//WebElement imageElement = driver.findElement(By.id("image_element_id"));
//
//int centerX = imageElement.getLocation().getX() + imageElement.getSize().getWidth() / 2;
//int centerY = imageElement.getLocation().getY() + imageElement.getSize().getHeight() / 2;
//
//PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
//
////First finger action
//Sequence sequence1 = new Sequence(finger1, 0)
//        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
//        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//        .addAction(finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX + 100, centerY + 100))
//        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
////Second finger action
//Sequence sequence2 = new Sequence(finger2, 0)
//        .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
//        .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//        .addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX - 100, centerY - 100))
//        .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
////Performing multi-touch actions
//         driver.perform(Arrays.asList(sequence1, sequence2));

//@DataProvider(name = "loginData")
//public Object[][] loginDataProvider() {
//    return new Object[][]{
//            {"user1", "password1"},
//            {"user2", "password2"},
//            {"admin", "adminpass"}
//    };
//}
//
//@Test(dataProvider = "loginData")
//public void testLogin(String username, String password) {
//    System.out.println("Testing with Username: " + username + ", Password: " + password);
//
//    // Здесь ты бы использовал логику взаимодействия с приложением:
//    // 1. Ввести username
//    // 2. Ввести password
//    // 3. Нажать Login
//    // 4. Проверить результат (например, что пользователь залогинен)
//}