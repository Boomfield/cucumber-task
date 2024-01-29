package onliner.pages;

import framework.BasePage;
import framework.elements.BaseElement;
import framework.elements.Waiter;
import onliner.pages.components.HeaderComponent;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public abstract class BaseOnlinerPage extends BasePage {
    protected BaseElement baseElement;
    protected Waiter waiter;
    protected final SoftAssert softAssert;
    public HeaderComponent headerComponent;

    public BaseOnlinerPage(By locator, String currentPage) {
        super(locator, currentPage);
        this.baseElement = new BaseElement();
        this.softAssert = new SoftAssert();
        this.headerComponent = new HeaderComponent();
        this.waiter = new Waiter();
    }
}
