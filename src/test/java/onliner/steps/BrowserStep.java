package onliner.steps;

import framework.configuration.Browser;

import framework.configuration.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import onliner.helpers.PropertyConfig;

public class BrowserStep extends BaseStep {
    private Browser browser;

    @Given("Onliner Main page is opened")
    public void userOpenBrowserAndOnlinerHomepage() {
        PropertyConfig.loadProperties("src/test/resources/config.properties");
        browser = new Browser(BrowserFactory.BROWSER_TYPE);
        browser.navigateToUrl(PropertyConfig.getUrl());
    }

    @After
    public void afterScenario() {
        softAssert.assertAll();
        browser.closeBrowser();
    }
}
