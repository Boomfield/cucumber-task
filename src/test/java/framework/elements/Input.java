package framework.elements;

import org.openqa.selenium.By;

public class Input extends BaseElement {
    public Input(By locator, String name) {
        super(locator, name);
    }

    public Input(String string, String name) {
        super(string, name);
    }
}
