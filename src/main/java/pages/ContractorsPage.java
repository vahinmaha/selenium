package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.UtilitiesHelper;

import java.util.Random;

public class ContractorsPage {

    private WebDriver driver;
    private By addContractorButton = By.id("Ellipse_68");
    private By paginationDropdown = By.xpath("//app-pagination-limit-dropdown/div/select");
    private By contractorsCountText = By.xpath("//app-pagination/div/span");
    private By contractorsColumn = By.xpath("//th[1]/div");
    private By boardsColumn = By.xpath("//th[2]/div");
    private By reassignBoardsColumn = By.xpath("//th[3]");
    private By contractorRows = By.tagName("tr");
    //private By contractorsText = By.xpath("//td[1]/span");
    private By contractorsText = By.xpath("//tr[6]/td[1]/span");
    private By boardsText = By.xpath("//td[2]");
    private By reassignBoardsButton = By.xpath("//td[3]");
    private By reassignModalTitle = By.className("modal-title");
    private By contractorNameLabel = By.xpath("");
    private By contractorNameText = By.xpath("");
    private By selectContractorLabel = By.xpath("");
    private By contractorDropdown = By.xpath("");
    private By rowsDropdown = By.xpath("");
    private By columnCheckbox = By.xpath("");
    private By serialNumberColumn = By.xpath("");
    private By typeColumn = By.xpath("");
    private By assignedOnColumn = By.xpath("");
    private By reassignBoardsReassignColumn = By.xpath("");
    private By rowCheckbox = By.xpath("");
    private By serialNumberText = By.xpath("");
    private By typeText = By.xpath("");
    private By assignedOnText = By.xpath("");
    private By reassignButton = By.xpath("");
    private By bulkReassignButton = By.xpath("");
    private By reassignPopUpConfirmationMessage = By.xpath("");
    private By reassignPopupYesButton = By.xpath("");
    private By reassignPopupNoButton = By.xpath("");
    private By reassignBoardsCloseButton = By.id("close");

    private By addContractorHeading = By.xpath("");
    private By noteText = By.xpath("");
    private By personalDetailsHeading = By.tagName("h5");
    private By nameLabel = By.xpath("//div[1]/div[1]/div[1]/div[1]/label");
    private By nameInput = By.xpath("//input[@formcontrolname='contractorName']");
    private By websiteLabel = By.xpath("//div[1]/div[2]/label");
    private By websiteInput = By.xpath("//div[1]/div[2]/div/input");
    private By companyLogoLabel = By.xpath("//div[1]/div[3]/label");
    private By companyLogoUploadButton = By.xpath("//div[1]/div[3]/div/input");
    private By primaryEmailLabel = By.xpath("//div[@formgroupname='email'][1]/div/div/label");
    private By primaryEmailInput = By.xpath("//div[1]/div/div/div/input[@formcontrolname='email']");
    private By secondaryEmailLabel = By.xpath("//div[@formgroupname='email'][2]/div/div/label");
    private By secondaryEmailInput = By.xpath("//div[2]/div/div/div/input[@formcontrolname='email']");
    private By contactPersonLabel = By.xpath("//div[1]/div[4]/label");
    private By contactPersonInput = By.xpath("//div[1]/div[4]/div/input");
    private By primaryLogoLabel = By.xpath("//div[2]/div[2]/label");
    private By primaryLogoInput = By.xpath("//input[@formcontrolname='primarylogo']");
    private By phoneLabel = By.xpath("//div[@formgroupname='phone']/div/div/label");
    private By phoneInput = By.xpath("//div[@formgroupname='phone']/div/div/div/div/input");
    private By phoneTypeDropdown = By.xpath("//div[@formgroupname='phone']/div/div/div/select");
    private By phoneAddMoreButton = By.xpath("//div[@formgroupname='phone']/div/div/div[3]/div/button/i[@class='fa fa-plus']");
    private By phoneSecondLabel = By.xpath("//div[@formgroupname='phone'][2]/div/div/label");
    private By phoneSecondInput = By.xpath("//div[@formgroupname='phone'][2]/div/div/div/div/input");
    private By phoneTypeSecondDropdown = By.xpath("//div[@formgroupname='phone'][2]/div/div/div[2]/select");
    private By phoneRemoveButton = By.xpath("//div[@formgroupname='phone']/div/div/div[3]/div/button/i[@class='fa fa-trash']");
    private By registeredOfficeAddressLabel = By.xpath("//div[@formgroupname='addresses'][1]/div/div/label");
    private By registeredOfficeStreetInput = By.xpath("//div[@formgroupname='addresses'][1]/div/div/div[1]/input");
    private By registeredOfficeCityInput = By.xpath("//div[@formgroupname='addresses'][1]/div/div/div[2]/input");
    private By registeredOfficeStateInput = By.xpath("//div[@formgroupname='addresses'][1]/div/div/div[3]/input");
    private By registeredOfficeZipCodeInput = By.xpath("//div[@formgroupname='addresses'][1]/div/div/div[4]/input");
    private By branchOfficeAddressLabel = By.xpath("//div[@formgroupname='addresses'][2]/div/div/label");
    private By branchStreetInput = By.xpath("//div[@formgroupname='addresses'][2]/div/div/div[1]/input");
    private By branchCityInput = By.xpath("//div[@formgroupname='addresses'][2]/div/div/div[2]/input");
    private By branchStateInput = By.xpath("//div[@formgroupname='addresses'][2]/div/div/div[3]/input");
    private By branchZipCodeInput = By.xpath("//div[@formgroupname='addresses'][2]/div/div/div[4]/input");
    private By addAdditionalBranchAddressButton = By.xpath("//div[@class='col']/div/button/i[@class='fa fa-plus']");
    private By secondBranchOfficeAddressLabel = By.xpath("//div[@formgroupname='addresses'][3]/div/div/label");
    private By secondBranchStreetInput = By.xpath("//div[@formgroupname='addresses'][3]/div/div/div[1]/input");
    private By secondBranchCityInput = By.xpath("//div[@formgroupname='addresses'][3]/div/div/div[2]/input");
    private By secondBranchStateInput = By.xpath("//div[@formgroupname='addresses'][3]/div/div/div[3]/input");
    private By secondBranchZipCodeInput = By.xpath("//div[@formgroupname='addresses'][3]/div/div/div[4]/input");
    private By deleteAdditionalBranchAddressButton = By.xpath("//div[@class='col']/div/button/i[@class='fa fa-trash']");
    private By otherDetailsHeading = By.xpath("");
    private By inBusinessSinceLabel = By.xpath("");
    private By businessStartYearDropdown = By.xpath("");
    private By numberOfTechniciansLabel = By.xpath("");
    private By numberOfTechniciansInput = By.xpath("");
    private By uploadDocumentsLabel = By.xpath("");
    private By uploadCompanyRegistrationLicense = By.xpath("");
    private By uploadMouContract = By.xpath("");
    private By resetButton = By.xpath("//app-button[1]/button/span");
    private By continueButton = By.xpath("//app-button[2]/button/span");
    private By contractorProfileEditButton = By.xpath("//div[@class='modal-footer']/app-button[1]/button/span");
    private By contractorProfileSaveButton = By.xpath("//div[@class='modal-footer']/app-button[2]/button/span");
    private By contractorProfileHeading = By.xpath("");
    private By profileContractorNameLabel = By.xpath("");
    private By profileContractorNameValue = By.xpath("");
    private By profileWebsiteLabel = By.xpath("");
    private By profileWebsiteValue = By.xpath("");
    private By profileCompanyLogoLabel = By.xpath("");
    private By profileCompanyLogoValue = By.xpath("");
    private By profileContactPersonLabel = By.xpath("");
    private By profileContactPersonValue = By.xpath("");
    private By profileEmailLabel = By.xpath("");
    private By profileEmailValue = By.xpath("");
    private By profilePhoneNumberLabel = By.xpath("");
    private By profilePhoneNumberValue = By.xpath("");
    private By profileRegisteredAddressLabel = By.xpath("");
    private By profileRegisteredAddressValue = By.xpath("");
    private By profileBranchAddressLabel = By.xpath("");
    private By profileBranchAddressValue = By.xpath("");
    private By profileBusinessSinceLabel = By.xpath("");
    private By profileBusinessSinceValue = By.xpath("");
    private By profileNoOfTechniciansLabel = By.xpath("");
    private By profileNoOfTechniciansValue = By.xpath("");
    private By profileUploadedDocumentsLabel = By.xpath("");
    private By profileUploadedDocumentsValue = By.xpath("");



    public ContractorsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyEditingAContractor() {
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, contractorsText);
        String currentName = UtilitiesHelper.getTextFromElement(driver, contractorsText);
        UtilitiesHelper.clickElement(driver, contractorsText);
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, contractorProfileEditButton);
        UtilitiesHelper.sleep(5000);
        UtilitiesHelper.clickElement(driver, contractorProfileEditButton);
        UtilitiesHelper.waitForElementToDisappear(driver, 60, 5, contractorProfileEditButton);
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, nameInput);
        String newName = "Contractor" + new Random().nextInt(1000);
        driver.findElement(nameInput).clear();
        UtilitiesHelper.inputText(driver, nameInput, newName);
        UtilitiesHelper.clickElement(driver, continueButton);
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, contractorProfileEditButton);
        UtilitiesHelper.clickElement(driver, contractorProfileSaveButton);
        UtilitiesHelper.waitForElementToDisappear(driver, 60, 5, contractorProfileSaveButton);
        UtilitiesHelper.waitTillElementIsPresent(driver, 60, 5, contractorsText);
        if(UtilitiesHelper.getTextFromElement(driver, contractorsText).contains(newName) && !(UtilitiesHelper.getTextFromElement(driver, contractorsText).contains(currentName))) {
            return true;
        }
        else {
            return false;
        }
    }
}
