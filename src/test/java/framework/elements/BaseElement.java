package framework.elements;

import framework.Logger;
import framework.configuration.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class BaseElement {
    private Waiter waiter;
    private Actions actions;
    private By locatorType;
    private String locatorValue;
    private String elementName;

    public BaseElement() {
        this.waiter = new Waiter();
        this.actions = new Actions(Browser.getDriver());
    }

    public BaseElement(By locatorType, String elementName) {
        this();
        this.locatorType = locatorType;
        this.elementName = elementName;
    }

    public BaseElement(String locatorValue, String elementName) {
        this();
        this.locatorValue = locatorValue;
        this.elementName = elementName;
    }

    public BaseElement getElementByText(String text) {
        return new BaseElement(By.xpath(String.format(locatorValue, text)), elementName);
    }

    public BaseElement getElementWithTwoText(String text1, String text2) {
        return new BaseElement(By.xpath(String.format(locatorValue, text1, text2)), elementName);
    }

    protected WebElement findElement(By locator) {
        waiter.waitForElementPresent(locator);
        return getNativeDriver().findElement(locator);
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) getNativeDriver();
    }

    private void highlightElement(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void clickElement() {
        Logger.logInfo("click by " + elementName);
        WebElement el = waiter.waitElementIsClickable(locatorType);
        highlightElement(el);
        el.click();
    }

    public void clickElementAndWait() {
        Logger.logInfo("click by " + elementName);
        WebElement el = waiter.waitElementIsClickable(locatorType);
        highlightElement(el);
        el.click();
        waiter.waitForPageToLoad(getJavascriptExecutor());
    }

    public void scrollToElementAndClick() {
        Logger.logInfo("click by " + elementName);
        WebElement el = waiter.waitElementIsClickable(locatorType);
        highlightElement(el);
        scrollIntoView();
        el.click();
    }

    protected List<WebElement> findElements(By locator) {
        return getNativeDriver().findElements(locator);
    }

    public void moveMouseOnElement() {
        Logger.logInfo("move mouse on " + elementName);
        WebElement el = findElement(locatorType);
        highlightElement(el);
        actions.moveToElement(el).perform();
    }

    public void sendKey(String text) {
        Logger.logInfo("send key in " + elementName);
        WebElement el = findElement(locatorType);
        highlightElement(el);
        el.sendKeys(text);
    }

    public void waitAttributeBe(String attribute, String value) {
        waiter.waitAttributeToBe(locatorType, attribute, value);
    }

    public List<String> getElementsTextList() {
        List<WebElement> elements = findElements(locatorType);
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void scrollIntoView() {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView({block: 'center'});", findElement(locatorType));
    }

    private WebDriver getNativeDriver() {
        return Browser.getDriver();
    }
}
