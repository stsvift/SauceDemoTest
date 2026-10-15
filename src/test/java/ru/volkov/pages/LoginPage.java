
package ru.volkov.pages;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    private final By error = By.cssSelector(
            "[data-test='error']"
    );

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginButton);
    }

    public String getError() {
        return text(error);
    }
}
