package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ConfigAnnoations {
  @Test
  public void test() {
	  System.out.println("test");
  }
  @Test
  public void test1() {
	  System.out.println("test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("login");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logout");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("launch the browser");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("close the browser");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("configuration for parallel execution");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("configuration for parallel execution");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Establish the data base connection");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Close the database connection");

  }

}
