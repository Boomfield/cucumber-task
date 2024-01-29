package onliner.steps;

import io.cucumber.java.en.When;
import onliner.pages.CataloguePage;

public class CatalogueStep extends BaseStep {
    private final CataloguePage cataloguePage;

    public CatalogueStep() {
        this.cataloguePage = new CataloguePage();
    }

    @When("I select {string} in main menu, select {string} in sub menu and select {string} on Catalog page")
    public void userNavigatesToTheSection(String mainMenu, String subMenu, String product) {
        cataloguePage.selectProductsInNavigateMenu(mainMenu, subMenu, product);
    }
}
