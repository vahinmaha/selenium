package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.UtilitiesHelper;

public class CommonPage {

    private WebDriver driver;
    private By headerLogo = By.className("meli-logo");
    private By headerUserNameText = By.xpath("//app-header/div/div[2]/div[2]/span/p/span");
    private By inventoryTab = By.xpath("//li[contains(text(), 'Inventory')]");
    private By contractorsTab = By.xpath("//li[contains(text(), 'Contractors')]");
    private By lastLoggedInTime = By.xpath("//app-tabs/div/p");
    private By footerLogo = By.className("connectm-logo mr5");
    private By footerMessage = By.xpath("//app-footer/div/span");

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean verifyHeaderElements() {
        UtilitiesHelper.waitTillElementIsPresent(driver, 120, 5, headerLogo);
        boolean isElementPresent = false;

        if (driver.findElement(headerLogo).isDisplayed()) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        if (driver.findElement(headerUserNameText).getText().contains("Admin_User_Name")) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        return isElementPresent;
    }

    public boolean verifyTabsAndLastLoggedIn() {
        boolean isElementPresent = false;

        if (driver.findElement(inventoryTab).isDisplayed()) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        if (driver.findElement(contractorsTab).isDisplayed()) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        if (driver.findElement(lastLoggedInTime).getText().contains("Last Logged In:")) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        return isElementPresent;
    }

    public boolean verifyFooterElements() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        boolean isElementPresent = false;

        if (driver.findElement(footerLogo).isDisplayed()) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        if (driver.findElement(footerMessage).getText().contains("All Rights Reserved")) {
            isElementPresent = true;
        }
        else {
            return false;
        }

        return isElementPresent;
    }

    public InventoryPage clickInventoryTab() {
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, inventoryTab);
        UtilitiesHelper.clickElement(driver, inventoryTab);
        UtilitiesHelper.sleep(3000);
        return new InventoryPage(driver);
    }

    public ContractorsPage clickContractorsTab() {
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, contractorsTab);
        UtilitiesHelper.clickElement(driver, contractorsTab);
        UtilitiesHelper.sleep(3000);
        return new ContractorsPage(driver);
    }
}
