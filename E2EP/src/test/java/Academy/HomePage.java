package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException 

	{
		driver.get("http://qaclickacademy.com");
	
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getpassword().sendKeys(Password);
		
		Log.info(text);	
		lp.getlogin().click();
				
			
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
			}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="awgwsdasd";
		data[0][1]="wefewfewasfdfqew";
		data[0][2]="restricted user";
		
		data[1][0]="asdasewfd";
		data[1][1]="asfdfqewew";
		data[1][2]="unrestricted user";
		return data;
	}
	}
