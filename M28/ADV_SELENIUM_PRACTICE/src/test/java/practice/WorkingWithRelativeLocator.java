package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class WorkingWithRelativeLocator {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement search = driver.findElement(By.id("small-searchterms"));
		WebElement login = driver.findElement(RelativeLocator.with(By.tagName("a")).above(search));
		driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(login)).click();
	}

}
