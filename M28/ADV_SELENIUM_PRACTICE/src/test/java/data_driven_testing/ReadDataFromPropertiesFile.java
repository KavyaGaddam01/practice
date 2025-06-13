package data_driven_testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Create java representation object of physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Kavya 1\\Desktop\\LoginData.properties");
		//Create an object of Properties
		Properties prop=new Properties();
		//Load all the keys
		prop.load(fis);
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		String username = prop.getProperty("Username");
		String password = prop.getProperty("Password");
		
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("CHROME"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
		else if(browser.equalsIgnoreCase("Firefox"))
			driver=new FirefoxDriver();
		else if(browser.equalsIgnoreCase("Safari"))
			driver=new SafariDriver();
		
		
		// Login to NINZA CRM
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
}
