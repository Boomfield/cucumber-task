package onliner.pages;

import org.openqa.selenium.By;

public class MainPage extends BaseOnlinerPage {

    private static By bannerLinkLocator = By.className("b-tiles-banner");

    public MainPage() {
        super(bannerLinkLocator, "Main page");
    }
}
