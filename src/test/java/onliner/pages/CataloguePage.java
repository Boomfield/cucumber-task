package onliner.pages;

import framework.elements.Button;
import org.openqa.selenium.By;

public class CataloguePage extends BaseOnlinerPage {
    private static By catalogTitleLinkLocator = By.className("catalog-navigation__title");
    private Button btnMainMenu = new Button("//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(),'%s')]", "category in main menu");
    private Button btnSubMenu = new Button("//div[@style='display: block;']//div[contains(text(),'%s')]", "category in sub menu");
    private Button btnTypeOfProduct = new Button("//div[contains(@class,'item_active')]//span[contains(@class,'dropdown-title') and normalize-space(text())='%s']", "type of product");

    public CataloguePage() {
        super(catalogTitleLinkLocator, "Catalog page");
    }

    public void selectProductsInNavigateMenu(String navigateMenu, String electronicMenu, String televisionSubMenu) {
        btnMainMenu.getElementByText(navigateMenu).clickElement();
        btnSubMenu.getElementByText(electronicMenu).moveMouseOnElement();
        btnTypeOfProduct.getElementByText(televisionSubMenu).clickElementAndWait();
    }
}
