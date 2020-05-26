package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.CommonPage;
import pages.LoginPage;
import testReport.TestReportGenerator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected CommonPage commonPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://goodman-qa.ihvac.io/");
        loginPage = new LoginPage(driver);
        commonPage = new CommonPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void generateTestReport(ITestContext context) {
        TestReportGenerator.printSuiteResultsInCsv(context.getSuite());
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
