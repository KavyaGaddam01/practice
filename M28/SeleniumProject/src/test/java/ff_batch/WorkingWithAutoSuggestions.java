package ff_batch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAutoSuggestions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("Samsung");
		List<WebElement> suggestions = driver
				.findElements(By.xpath("(//ul[@jsname='bw4e9b' and @role='listbox'])[1]/li"));

		for (WebElement suggestion : suggestions) {
			System.out.println(suggestion.getText());
				if (suggestion.getText().equals("samsung s25")) {
					suggestion.click();
				    break;
			}
		}

	}

}
