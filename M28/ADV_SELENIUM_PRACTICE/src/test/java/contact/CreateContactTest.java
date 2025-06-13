package contact;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import configbaseclass.BaseClass;
import fileutility.ExcelUtility;
import javautility.JavaUtility;
import objectrepository.CampaignPage;
import objectrepository.ContactsPage;
import objectrepository.CreateContactPage;
import objectrepository.HomePage;
import objectrepository.SelectCampaignPage;
import webdriverutility.WebDriverUtility;

public class CreateContactTest extends BaseClass {

	@Test(groups = {"Smoke","Regression","Integration"})
	public void CreateContactWithMandatoryFieldsTest()throws IOException {

		ExcelUtility eLib = new ExcelUtility();
		String campName = eLib.readDataFromExcelFile("Contact", 1, 2);
		String targetSize = eLib.readDataFromExcelFile("Contact", 1, 3);
		String organization = eLib.readDataFromExcelFile("Contact", 1, 4);
		String title = eLib.readDataFromExcelFile("Contact", 1, 5);
		String contact = eLib.readDataFromExcelFile("Contact", 1, 6);
		String mobile = eLib.readDataFromExcelFile("Contact", 1, 7);
		String windowTitle = eLib.readDataFromExcelFile("Contact", 1, 8);

		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();
		String campaignName = campName + randomInt;

		WebDriverUtility wLib = new WebDriverUtility();

		HomePage hp = new HomePage(driver);
		CampaignPage campaignPage = new CampaignPage(driver);
		ContactsPage contactsPage = new ContactsPage(driver);
		CreateContactPage createContactPage = new CreateContactPage(driver);
		SelectCampaignPage selectCampaignPage = new SelectCampaignPage(driver);


		// Create Campaign
		campaignPage.createCampaign(campaignName, targetSize);
		campaignPage.getCreateCampaignSubmitBtn().click();

		// Creating contact
		hp.getContactsBtn().click();
		wLib.waitForVisibilityOfWebElement(driver, hp.getToastMsg());
		hp.getCloseToastMsg().click();

		contactsPage.getCreateContactBtn().click();
		createContactPage.getOrganizationNameTF().sendKeys(organization);
		createContactPage.getTitleTF().sendKeys(title);
		createContactPage.getContactNameTF().sendKeys(contact);
		createContactPage.getMobileTF().sendKeys(mobile);
		createContactPage.getPlusBtn().click();
		
		String parentId = driver.getWindowHandle();
		wLib.switchToWindowOnTitle(driver, windowTitle);
		WebElement campaignDD = selectCampaignPage.getCampaignDD();
		http://wLib.select(campaignDD, 1);
		selectCampaignPage.getSearchBar().sendKeys(campaignName);
		selectCampaignPage.getSelectBtn().click();
		driver.switchTo().window(parentId);
		
		createContactPage.getCreateContactSubmitBtn().click();

		// Validation
		wLib.waitForVisibilityOfWebElement(driver, hp.getToastMsg());
		String msg = hp.getToastMsg().getText();
		Assert.assertTrue(msg.contains(contact));
		hp.getCloseToastMsg().click();
		

	}

}
 



