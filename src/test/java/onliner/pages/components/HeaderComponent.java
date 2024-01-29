package onliner.pages.components;

import framework.elements.Button;

public class HeaderComponent {
    private Button btnHeaderMenu = new Button("//span[@class='b-main-navigation__text' and text()='%s']", "choose header menu");

    public void clickByHeaderMenu(String headerMenu) {
        btnHeaderMenu.getElementByText(headerMenu).clickElementAndWait();
    }
}
