package ff_batch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkingWithSelectClass {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		WebElement date = driver.findElement(By.name("birthday_day"));
		Select obj=new Select(date);
		obj.selectByIndex(0);
		WebElement month = driver.findElement(By.id("month"));
		Select obj1=new Select(month);
		obj1.selectByValue("7");
		WebElement year = driver.findElement(By.id("year"));
		Select obj2=new Select(year);
		obj2.selectByVisibleText("2020");
		System.out.println(obj2.isMultiple());
		List<WebElement> options = obj2.getOptions();
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
	}

}
