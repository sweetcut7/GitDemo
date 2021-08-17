package Academy;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		Log.info("Driver is initialized");
		driver.get("http://qaclickacademy.com");
		Log.info("Navigated to homepage");
	}
	
	@Test
	public void basePageNavigation() throws IOException 

	{
		driver =initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage l= new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");	
		Log.info("Sucessfully validated text message");	
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
			}
}