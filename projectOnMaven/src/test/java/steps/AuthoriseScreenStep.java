package steps;

import screens.AuthoriseScreen;

public class AuthoriseScreenStep {
    AuthoriseScreen authoriseScreen = new AuthoriseScreen();

    public void clickAuthorizeBtn() {
        authoriseScreen.clickAuthorizeBtn();
        authoriseScreen.clickNotificationTab();
    }
}
