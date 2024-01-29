package onliner.steps;

import io.cucumber.java.en.When;
import onliner.pages.MainPage;

public class MainStep extends BaseStep {
    private final MainPage mainPage;

    public MainStep() {
        this.mainPage = new MainPage();
    }


    @When("I click {string} in header menu on Main page")
    public void userNavigatesToTheSection(String headerMenu) {
        mainPage.headerComponent.clickByHeaderMenu(headerMenu);
    }
}
