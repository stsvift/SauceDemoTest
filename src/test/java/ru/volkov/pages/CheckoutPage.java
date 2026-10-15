
package ru.volkov.pages;

import org.openqa.selenium.*;

public class CheckoutPage extends BasePage {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");

    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    private final By error = By.cssSelector(
            "[data-test='error']"
    );

    private final By total = By.className(
            "summary_total_label"
    );

    private final By itemName = By.className(
            "inventory_item_name"
    );

    private final By success = By.className(
            "complete-header"
    );

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInformation(
            String first, String last, String zip) {

        type(firstName, first);
        type(lastName, last);
        type(postalCode, zip);
        click(continueButton);
    }

    public String getError() {
        return text(error);
    }

    public String getTotal() {
        return text(total);
    }

    public String getItemName() {
        return text(itemName);
    }

    public void finish() {
        click(finishButton);
    }

    public String getSuccessMessage() {
        return text(success);
    }
}
