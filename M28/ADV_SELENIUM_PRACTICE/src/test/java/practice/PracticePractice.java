package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("kolaveri");
		driver.findElement(By.xpath("//button[@class='ytSearchboxComponentSearchButton']")).click();

		Thread.sleep(1000);
		WebElement b = driver.findElement(By.xpath(
				"//a[@title='3 - Why This Kolaveri Di Official Video | Dhanush | Anirudh Ravichander | Shruti Haasan']"));
		driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(b)).click();
		b.click();
		
		try {
			WebElement skip = driver.findElement(By.xpath("//div[text()='Skip']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOf(skip));
			skip.click();
		} catch (Exception e) {
			
		}
		

	}

}
