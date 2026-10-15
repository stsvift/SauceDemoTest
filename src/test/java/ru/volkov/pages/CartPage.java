
package ru.volkov.pages;

import org.openqa.selenium.*;

public class CartPage extends BasePage {

    private final By productName = By.className(
            "inventory_item_name"
    );

    private final By productPrice = By.className(
            "inventory_item_price"
    );

    private final By checkoutButton = By.id(
            "checkout"
    );

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return text(productName);
    }

    public String getProductPrice() {
        return text(productPrice);
    }

    public void checkout() {
        click(checkoutButton);
    }
}
