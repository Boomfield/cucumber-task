package onliner.steps;

import org.testng.asserts.SoftAssert;

public class BaseStep {
    protected final SoftAssert softAssert;

    public BaseStep() {
        this.softAssert = new SoftAssert();
    }
}
