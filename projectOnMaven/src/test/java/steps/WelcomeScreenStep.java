package steps;

import screens.WelcomeScreen;

public class WelcomeScreenStep {
    WelcomeScreen welcomeScreen = new WelcomeScreen();

    public boolean homeScreenDisplayed() {
        return welcomeScreen.isDisplayed();
    }

    public void authoriseStep(){
        welcomeScreen.clickLogIn();
        welcomeScreen.clickRadioBtn();
        welcomeScreen.clickNextbtn();
    }
}
