package ff_batch;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithWebDriverMethods {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shoppersstack.com/products_page/18");
		Thread.sleep(15000);
		driver.findElement(By.id("compare")).click();
		
        String parentId = driver.getWindowHandle();
        System.out.println(parentId);
        
        Set<String> allIds = driver.getWindowHandles();
        System.out.println(allIds);
        allIds.remove(parentId);                               
        System.out.println(allIds);
        
        for(String id:allIds) {
        	driver.switchTo().window(id);
        	Thread.sleep(2000);
		    driver.close();
        }

	}

}
