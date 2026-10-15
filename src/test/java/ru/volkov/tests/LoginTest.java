
package ru.volkov.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.volkov.BaseTest;
import ru.volkov.pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    void successfulLoginTest() {
        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        wait.until(ExpectedConditions.urlContains(
                "/inventory.html"
        ));

        InventoryPage inventory = new InventoryPage(driver);

        assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "Не выполнен переход на страницу товаров"
        );

        assertEquals(
                "Products", inventory.getTitle(),
                "Неверный заголовок страницы"
        );
    }

    @Test
    void lockedUserTest() {
        LoginPage login = new LoginPage(driver);

        login.login("locked_out_user", "secret_sauce");

        assertTrue(
                login.getError().contains("locked out"),
                "Не появилось сообщение о блокировке"
        );
    }
}
