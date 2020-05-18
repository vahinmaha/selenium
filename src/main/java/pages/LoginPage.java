package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.UtilitiesHelper;

public class LoginPage {

    private WebDriver driver;
    private By userNameInput = By.xpath("//input[@placeholder='Username']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.tagName("button");
    private By logoutArrow = By.xpath("//*[@class='arrow-icon']");
    private By logoutButton = By.xpath("//p[text()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public InventoryPage login(String userName, String password) {
        UtilitiesHelper.waitTillElementIsPresent(driver, 300, 5, userNameInput);
        UtilitiesHelper.inputText(driver, userNameInput, userName);
        UtilitiesHelper.inputText(driver, passwordInput, password);
        UtilitiesHelper.clickElement(driver, loginButton);
        return new InventoryPage(driver);
    }

    public boolean logout() {
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, logoutArrow);
        UtilitiesHelper.clickElement(driver, logoutArrow);
        UtilitiesHelper.clickElement(driver, logoutButton);
        UtilitiesHelper.waitForPageLoad(driver);
        UtilitiesHelper.waitTillElementIsPresent(driver, 120, 5, userNameInput);
        return driver.findElement(userNameInput).isDisplayed();
    }
}
