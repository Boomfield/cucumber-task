package framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }

    public Button(String string, String name) {
        super(string, name);
    }
}
