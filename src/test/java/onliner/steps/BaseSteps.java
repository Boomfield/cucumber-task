package onliner.steps;

import org.testng.asserts.SoftAssert;

public class BaseSteps {
    protected final SoftAssert softAssert;

    public BaseSteps() {
        this.softAssert = new SoftAssert();
    }
}
