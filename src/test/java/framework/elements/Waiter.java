package framework.elements;

import framework.configuration.Browser;
import onliner.helpers.PropertyConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private static final int DEFAULT_ELEMENT_LOADED_TIMEOUT = PropertyConfig.getDefaultExplicitlyWait();

    private WebDriverWait wait;

    public boolean waitForElementPresent(By locator) {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(DEFAULT_ELEMENT_LOADED_TIMEOUT));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitElementIsClickable(By element) {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(DEFAULT_ELEMENT_LOADED_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageToLoad(JavascriptExecutor jsExecutor) {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(DEFAULT_ELEMENT_LOADED_TIMEOUT));
        wait.until((WebDriver driver) -> jsExecutor.executeScript("return document.readyState").equals("complete"));
    }

    public void waitAttributeToBe(By element, String attribute, String value) {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(DEFAULT_ELEMENT_LOADED_TIMEOUT));
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }
}

