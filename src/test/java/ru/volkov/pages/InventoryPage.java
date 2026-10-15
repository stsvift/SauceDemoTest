
package ru.volkov.pages;

import org.openqa.selenium.*;

public class InventoryPage extends BasePage {

    private final By title = By.className("title");

    private final By addBackpack = By.id(
            "add-to-cart-sauce-labs-backpack"
    );

    private final By cartBadge = By.className(
            "shopping_cart_badge"
    );

    private final By cartLink = By.className(
            "shopping_cart_link"
    );

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return text(title);
    }

    public void addBackpack() {
        click(addBackpack);
    }

    public String getCartCount() {
        return text(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }
}
