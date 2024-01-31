package onliner.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pages.CataloguePage;
import onliner.pages.MainPage;
import onliner.pages.ProductPage;
import onliner.pages.helpers.ProductInfoHelper;

import java.util.List;
import java.util.Map;

public class ProductSearchSteps extends BaseSteps {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private ProductPage productPage;

    @When("I click {string} in header menu on Main page")
    public void userNavigatesToTheSection(String headerMenu) {
        mainPage = new MainPage();
        mainPage.headerComponent.clickByHeaderMenu(headerMenu);
    }

    @And("I select {string} in main menu, select {string} in sub menu and select {string} on Catalogue page")
    public void userNavigatesToTheSection(String mainMenu, String subMenu, String product) {
        cataloguePage = new CataloguePage();
        cataloguePage.selectProductsInNavigateMenu(mainMenu, subMenu, product);
    }

    @And("I write price before {double} and select filters on Product TV page")
    public void userNavigatesToTheSection(Double price, Map<String, String> filters) {
        productPage = new ProductPage();
        productPage.sendTextInBeforePrice(price);
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            productPage.clickFilter(entry.getValue(), entry.getKey());
        }
        productPage.waitForResultsLoaded();
    }

    @Then("I verify that price is less than {double}")
    public void verifyProductPrice(Double price) {
        List<Double> pricesValueList = productPage.getPricesValue();
        softAssert.assertTrue(pricesValueList.stream()
                        .allMatch(element -> element <= price),
                "This product has more then " + price);
    }

    @And("I verify that product is only {string}")
    public void verifyProductTitle(String titleText) {
        List<String> productsNameList = productPage.getProductsName();
        softAssert.assertTrue(productsNameList.stream()
                        .allMatch(element -> element.contains(titleText)),
                "This product doesn't contain " + titleText);
    }

    @And("I verify that resolution is only {string}")
    public void verifyProductResolution(String resolution) {
        List<String> productsDescriptionList = productPage.getProductsDescription();
        softAssert.assertTrue(productsDescriptionList.stream()
                        .allMatch(element -> element.contains(resolution)),
                "This product description doesn't contain " + resolution);
    }

    @And("I verify that  diagonal is between {int} and {int}")
    public void verifyProductDiagonalIsBetween(int startRange, int endRange) {
        List<Integer> propertyFromDescriptionList = productPage.extractPropertyFromDescription(ProductInfoHelper.extractTvDiagonal);
        softAssert.assertTrue(propertyFromDescriptionList.stream()
                        .allMatch(value -> value >= startRange && value <= endRange),
                "This product not between " + startRange + " and " + endRange);
    }

}
