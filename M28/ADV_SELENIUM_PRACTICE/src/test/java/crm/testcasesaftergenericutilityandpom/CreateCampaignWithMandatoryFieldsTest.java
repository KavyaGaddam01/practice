package crm.testcasesaftergenericutilityandpom;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import configbaseclass.BaseClass;
import fileutility.ExcelUtility;
import fileutility.PropertyFileUtility;
import javautility.JavaUtility;
import objectrepository.CampaignPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import webdriverutility.WebDriverUtility;

public class CreateCampaignWithMandatoryFieldsTest extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {

		PropertyFileUtility pLib = new PropertyFileUtility();
		String browser = pLib.readDataFromPropertiesFile("Browser");
		String url = pLib.readDataFromPropertiesFile("Url");
		String username = pLib.readDataFromPropertiesFile("Username");
		String password = pLib.readDataFromPropertiesFile("Password");

		ExcelUtility eLib = new ExcelUtility();
		String campName = eLib.readDataFromExcelFile("Campaign", 1, 2);
		String targetSize = eLib.readDataFromExcelFile("Campaign", 1, 3);

		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();
		String campaignName = campName + randomInt;

		WebDriverUtility wLib = new WebDriverUtility();

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("CHROME"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		CampaignPage campaignPage = new CampaignPage(driver);

		// login
		lp.Login(url, username, password);

		// Create Campaign
		campaignPage.createCampaign(campaignName, targetSize);
		campaignPage.getCreateCampaignSubmitBtn().click();

		// Validation
		wLib.waitForVisibilityOfWebElement(driver, hp.getToastMsg());
		String msg = hp.getToastMsg().getText();
		if (msg.contains(campaignName))
			System.out.println("Campaign Created");
		else
			System.out.println("Campaign Not Created");
		hp.getCloseToastMsg().click();
		// Logout
		hp.logout();

	}

}
