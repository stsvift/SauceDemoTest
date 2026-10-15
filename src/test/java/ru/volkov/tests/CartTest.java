
package ru.volkov.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.volkov.BaseTest;
import ru.volkov.pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest extends BaseTest {

    @Test
    void addToCartTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        wait.until(ExpectedConditions.urlContains(
                "/inventory.html"
        ));

        InventoryPage inventory = new InventoryPage(driver);

        inventory.addBackpack();

        assertEquals(
                "1", inventory.getCartCount(),
                "Счётчик корзины должен быть равен 1"
        );

        inventory.openCart();

        CartPage cart = new CartPage(driver);

        assertEquals(
                "Sauce Labs Backpack",
                cart.getProductName(),
                "В корзине неправильный товар"
        );

        assertEquals(
                "$29.99",
                cart.getProductPrice(),
                "Цена товара не совпадает"
        );
    }
}
