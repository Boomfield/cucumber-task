package onliner.pages;

import framework.Logger;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import onliner.pages.helpers.ProductInfoHelper;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductPage extends BaseOnlinerPage {
    private static By productTitleLinkLocator = By.className("catalog-content");
    private Button btnFilter = new Button("//div[contains(@class,'catalog-form__group') and .//div[contains(text(),'%s')]]//div[contains(text(),'%s')]", "filter");
    private Input inpBeforePrice = new Input(By.xpath("//input[@placeholder='до']"), "before price");
    private Label lblPriceValue = new Label(By.xpath("//div[contains(@class,'part_control')]//a[contains(@class,'catalog-form__link_huge-additional')]/span[not(@class)]"), "price");
    private Label lblProductName = new Label(By.xpath("//a[contains(@class, 'catalog-form__link_base-additional')]"), "product name");
    private Label lblProductDescription = new Label(By.xpath("//div[@class= 'catalog-form__parameter-part catalog-form__parameter-part_1']"), "product description");
    private Label lblProductBlock = new Label(By.className("catalog-form__offers"), "product block");

    public ProductPage() {
        super(productTitleLinkLocator, "Product page");
    }

    public void clickFilter(String filterBlock, String filter) {
        btnFilter.getElementWithTwoText(filterBlock, filter).scrollToElementAndClick();
    }

    public void sendTextInBeforePrice(Double price) {
        inpBeforePrice.sendKey(Double.toString(price));
    }

    public List<Double> getPricesValue() {
        List<String> productsPrInString = lblPriceValue.getElementsTextList();
        return productsPrInString.stream()
                .map(ProductInfoHelper::convertPriceToString)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> getProductsName() {
        return lblProductName.getElementsTextList();
    }

    public List<String> getProductsDescription() {
        return lblProductDescription.getElementsTextList();
    }

    public List<Integer> extractPropertyFromDescription(Function<String, Integer> extractData) {
        List<String> descriptions = getProductsDescription();
        return descriptions.stream()
                .map(extractData)
                .collect(Collectors.toList());
    }

    public void waitForResultsLoaded() {
        try {
            lblProductBlock.waitAttributeBe("class",
                    "catalog-form__offers catalog-form__offers_processing");
            lblProductBlock.waitAttributeBe("class",
                    "catalog-form__offers");
        } catch (Exception ignored) {
            Logger.logInfo(ignored.getMessage());
        }
    }
}
