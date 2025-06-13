package campaign;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import configbaseclass.BaseClass;
import fileutility.ExcelUtility;
import javautility.JavaUtility;
import objectrepository.CampaignPage;
import objectrepository.HomePage;
import webdriverutility.WebDriverUtility;

@Listeners(listenerutility.ListenerImplementationClass.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups = "Smoke")
	public void createCampaignWithMandatoryFieldsTest() throws InterruptedException, IOException {

		ExcelUtility eLib = new ExcelUtility();
		String campName = eLib.readDataFromExcelFile("Campaign", 1, 2);
		String targetSize = eLib.readDataFromExcelFile("Campaign", 1, 3);

		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();
		String campaignName = campName + randomInt;

		WebDriverUtility wLib = new WebDriverUtility();
        HomePage hp = new HomePage(driver);
		CampaignPage campaignPage = new CampaignPage(driver);

		// Create Campaign
		campaignPage.createCampaign(campaignName, targetSize);
		campaignPage.getCreateCampaignSubmitBtn().click();

		// Validation
		wLib.waitForVisibilityOfWebElement(driver, hp.getToastMsg());
		String msg = hp.getToastMsg().getText();
		Assert.assertEquals( msg,"Campaign "+campaignName+" Successfully ");
		hp.getCloseToastMsg().click();

	}
	
	@Test(groups = "Regression")
	public void createCampaignWithStatusTest() throws EncryptedDocumentException, IOException {
		
		ExcelUtility eLib = new ExcelUtility();
		String campName = eLib.readDataFromExcelFile("Campaign", 4, 2);
		String targetSize = eLib.readDataFromExcelFile("Campaign", 4, 3);
		String status = eLib.readDataFromExcelFile("Campaign", 4, 4);

		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();
		String campaignName = campName + randomInt;
		WebDriverUtility wLib = new WebDriverUtility();

		CampaignPage campaignPage = new CampaignPage(driver);
        HomePage hp = new HomePage(driver);


		// Create Campaign
		campaignPage.createCampaign(campaignName, targetSize);
		campaignPage.getCampaignStatusTF().sendKeys(status);
		campaignPage.getCreateCampaignSubmitBtn().click();

		// Validation
		wLib.waitForVisibilityOfWebElement(driver, hp.getToastMsg());
		String msg = hp.getToastMsg().getText();
		Assert.assertTrue(msg.contains(campaignName));
		hp.getCloseToastMsg().click();
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void createCampaignWithExpectedCloseDateTest() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib = new ExcelUtility();
		String campName = eLib.readDataFromExcelFile("Campaign", 7, 2);
		String targetSize = eLib.readDataFromExcelFile("Campaign", 7, 3);

		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();
		String campaignName = campName + randomInt;

		WebDriverUtility wLib = new WebDriverUtility();
        HomePage hp = new HomePage(driver);


		CampaignPage campaignPage = new CampaignPage(driver);

		// Create Campaign
		campaignPage.createCampaign(campaignName, targetSize);
		wLib.enterInput(driver, campaignPage.getExpectedCloseDateTF(), jLib.getRequiredDate(30));
		campaignPage.getCreateCampaignSubmitBtn().click();
		
		// Validation
		wLib.waitForVisibilityOfWebElement(driver,hp.getToastMsg());
		String msg =  hp.getToastMsg().getText();
		Assert.assertTrue(msg.contains(campaignName));
		hp.getCloseToastMsg().click();
	}

}
