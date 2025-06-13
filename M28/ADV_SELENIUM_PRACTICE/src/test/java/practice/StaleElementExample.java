package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExample {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys("asdfghjkl");
		
		WebElement pw = driver.findElement(By.name("password"));
		driver.navigate().refresh();
		pw.sendKeys("ASDFGHJK");
		
		
		
	}

}
