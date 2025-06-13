package listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import configbaseclass.BaseClass;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report Configuration", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report Backup", true);
	}

	@Override
	public void onTestStart(ITestResult result) {

		Reporter.log("===========" + result.getMethod().getMethodName() + " Execution STARTED=======", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("=========="+result.getMethod().getMethodName()+" SUCCESS===========",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("=========="+testName+" FAILURE===========",true);
		Date d=new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+testName+"_"+newDate+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("=========="+result.getMethod().getMethodName()+" SKIPPED===========",true);
	}

}
