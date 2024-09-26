package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ExplorePage extends Base{
    private By searchTab = new By.ById("org.joinmastodon.android:id/tab_search");
    private By searchText = new By.ById("org.joinmastodon.android:id/text");

    public ExplorePage(AppiumDriver driver) {
        super(driver);
    }

    public void exploreSearch() {
        click(searchTab);
        click(searchText);
    }
}
