package steps;

import screens.ExploreScreen;

public class ExploreScreenStep {
    ExploreScreen exploreScreen = new ExploreScreen();

    public void clickExploreBtn() {
        exploreScreen.clickExploreBtn();
    }

    public boolean explorePageDisplyed() {
        return exploreScreen.explorePageDisplyed();
    }

    public void clickText() {
        exploreScreen.clickText();
    }

    public boolean postIsDisplayed() {
        return exploreScreen.postIsDisplayed();
    }

    public int searchFieldLocationX() {
        return exploreScreen.searchFieldLocationX();
    }

    public int searchFieldLocationY() {
        return exploreScreen.searchFieldLocationY();
    }

    public void clickSearchField() {
        exploreScreen.clickSearchField();
    }

    public void enterTextIntoSearch() {
        exploreScreen.enterTextIntoSearch();
    }

    public String getTextFromSearch() {
        return exploreScreen.getTextFromSearch();
    }

    public void clearSeachField() {
        exploreScreen.clearSeachField();
    }

    public void swipe(int count) {
        exploreScreen.swipe(count);

    }

    public boolean namePostDisplayed() {
        return exploreScreen.namePostDisplayed();
    }

    public void swipeToFirstPost() {
        exploreScreen.swipeToFirstPost();
    }
    public void swipeToTwenty(int times){
        exploreScreen.swipeMultipleTimes(times);
    }

}
