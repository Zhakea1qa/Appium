package stepdefinitions;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginSteps {

    private final IButton pickAnotherServerBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_get_started"), "pick another server");
    private final ILabel mastodonLbl = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[@text='mastodon.uno']"),"label");
    private final ITextBox mastodonUno = AqualityServices.getElementFactory().getTextBox(By.id("org.joinmastodon.android:id/domain"), "text box");

    @Given("пользователь находится на экране логина")
    @DisplayName("new name")
    @Story("it's story")
    public void givenUserIsOnLoginScreen() {
        pickAnotherServerBtn.state().waitForExist();
    }
    @DisplayName("second name")
    @Story("it's story")
    @When("пользователь выбирает сервер {string}")
    public void whenUserSelectsAServer(String server) {
        pickAnotherServerBtn.click();
        ILabel serverLabel = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("//*[@text = '%s']", server)), "server label");
        serverLabel.click();
    }

    @Then("поле для имени пользователя должно отображать {string}")
    public void thenUsernameFieldShouldDisplay(String expectedUsername) {
        assertEquals("Имя пользователя не совпадает", "@" + expectedUsername, mastodonUno.getText());
    }
}
