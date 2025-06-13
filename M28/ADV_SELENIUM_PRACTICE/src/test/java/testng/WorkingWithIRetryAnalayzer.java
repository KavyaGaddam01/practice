package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithIRetryAnalayzer {

	@Test(retryAnalyzer  = listenerutility.RetryAnalyzerImplementation.class)
	public void test() {
		System.out.println("test");
		Assert.assertEquals("hdfc", "hfdc");
	}
}
