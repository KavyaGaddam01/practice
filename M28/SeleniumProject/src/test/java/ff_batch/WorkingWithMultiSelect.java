package ff_batch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkingWithMultiSelect {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.selenium.dev/selenium/web/formPage.html");
		WebElement multiDD = driver.findElement(By.id("multi"));
		Select obj=new Select(multiDD);
		Thread.sleep(2000);
		obj.deselectByIndex(0);
		Thread.sleep(2000);
		obj.deselectByValue("sausages");
		Thread.sleep(2000);
		obj.selectByIndex(0);
		Thread.sleep(2000);
		obj.selectByValue("sausages");
		System.out.println(obj.getFirstSelectedOption().getText());
		System.out.println("==============================================");
		List<WebElement> allSelectOptions = obj.getAllSelectedOptions();
		
		for(WebElement option:allSelectOptions) {
			System.out.println(option.getText());
		}
		System.out.println(obj.isMultiple());
	}

}
