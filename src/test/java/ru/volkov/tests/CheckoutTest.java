
package ru.volkov.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.volkov.BaseTest;
import ru.volkov.pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest extends BaseTest {

    private CheckoutPage prepareCheckout() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        wait.until(ExpectedConditions.urlContains(
                "/inventory.html"
        ));

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpack();
        inventory.openCart();

        CartPage cart = new CartPage(driver);
        cart.checkout();

        return new CheckoutPage(driver);
    }

    @Test
    void successfulCheckoutTest() {
        CheckoutPage checkout = prepareCheckout();

        checkout.fillInformation(
                "Stepan", "Volkov", "101000"
        );

        assertEquals(
                "Sauce Labs Backpack",
                checkout.getItemName(),
                "Неверный товар в заказе"
        );

        assertEquals(
                "Total: $32.39",
                checkout.getTotal(),
                "Неверная итоговая сумма"
        );

        checkout.finish();

        assertEquals(
                "Thank you for your order!",
                checkout.getSuccessMessage(),
                "Заказ не завершён"
        );
    }

    @Test
    void emptyFirstNameTest() {
        CheckoutPage checkout = prepareCheckout();

        checkout.fillInformation(
                "", "Volkov", "101000"
        );

        assertTrue(
                checkout.getError().contains(
                        "First Name is required"
                ),
                "Не появилась ошибка обязательного поля"
        );
    }
}
