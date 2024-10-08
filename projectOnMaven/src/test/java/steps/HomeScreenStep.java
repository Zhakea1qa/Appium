package steps;

import screens.HomeScreen;

public class HomeScreenStep {
    HomeScreen homeScreen = new HomeScreen();

    public boolean homeScreenDisplayed() {
        return homeScreen.homeScreenDisplayed();
    }
}
