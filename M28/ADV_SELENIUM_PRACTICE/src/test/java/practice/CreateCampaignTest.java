package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import configbaseclass.BaseClass;
import fileutility.ExcelUtility;
import javautility.JavaUtility;
import objectrepository.CampaignPage;
import objectrepository.HomePage;
import webdriverutility.WebDriverUtility;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void createCampaignWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException {

		ExcelUtility eLib = new ExcelUtility();
		String campName = eLib.readDataFromExcelFile("Campaign", 1, 2);
		String targetSize = eLib.readDataFromExcelFile("Campaign", 1, 3);

		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();  //String campaignName=campName +jLib.getRandomNumber();
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
		if (msg.contains(campaignName))
			System.out.println("Campaign Created");
		else
			System.out.println("Campaign Not Created");
		hp.getCloseToastMsg().click();

	}

	@Test
	public void createCampaignWithStatusTest() {

	}

	@Test
	public void createCampaignWithExpectedCloseDateTest() {

	}
}
