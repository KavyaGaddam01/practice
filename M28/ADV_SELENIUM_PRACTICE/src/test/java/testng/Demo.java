package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {

	WebDriver driver;
	@Test(priority = -5)
	public void students() {
		 driver=new ChromeDriver();
		 
		Reporter.log("students",true);
	}

	@Test(dependsOnMethods  = "students")
	public void advancedSelenium() throws InterruptedException {
	     driver.get("https://www.instagram.com/");
	     Thread.sleep(2000);
		Reporter.log("advancedSelenium",true);
	}
	
	@Test(dependsOnMethods  = {"advancedSelenium","students"})
	public void test() {
		driver.findElement(By.name("username")).sendKeys("asdfghjkl");
		Reporter.log("test",true);

	}
	@Test(priority = -10)
	public void system() {
		Reporter.log("lkjhgfdsa",true);

	}

}
