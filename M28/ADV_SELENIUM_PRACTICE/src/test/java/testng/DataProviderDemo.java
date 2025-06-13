package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(dataProvider = "loginDetails")
	public void login(String userName,String password) {
		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		WebElement userIcon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions action = new Actions(driver);
		action.moveToElement(userIcon).perform();
		WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		action.moveToElement(logoutBtn).click().perform();

		driver.quit();
	}
	
	@DataProvider
	public Object[][] loginDetails() throws EncryptedDocumentException, IOException{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\QSP\\Documents\\NinzaCRM_M28.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getLastRowNum();
		System.out.println(rowCount);
		Object[][] objArr=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			objArr[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objArr[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
		}

		return objArr;	
		
	}
	
}
