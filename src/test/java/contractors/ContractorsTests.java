package contractors;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContractorsPage;

public class ContractorsTests  extends BaseTest {

    @Test
    public void verifyEditContractor() {
        loginPage.login("goodman@gmail.com", "Connectm@123");
        ContractorsPage contractorsPage = commonPage.clickContractorsTab();
        Assert.assertTrue(contractorsPage.verifyEditingAContractor(), "Edit was not successful");
        Assert.assertTrue(loginPage.logout(), "Logout was not successful");

    }
}
