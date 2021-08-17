package stepDefinations;


import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

@RunWith(Cucumber.class)
public class stepDefination extends base {


@Given("^Intitaliaze the browser$")
public void intitaliaze_the_browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver =initializeDriver();
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    driver.get(arg1);
}

@Given("^Click on the login link in homepage to land on secure signin page$")
public void click_on_the_login_link_in_homepage_to_land_on_secure_signin_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LandingPage l= new LandingPage(driver);
	if(l.getPopupSize()>0)
	{
		l.getPopUp().click();
	}
	l.getLogin().click();
}

@When("^User enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(username);
	lp.getpassword().sendKeys(password);
	lp.getlogin().click();
	
			
}

@Then("^Verify that user is sccesfully logged in$")
public void verify_that_user_is_sccesfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
System.out.println("Success");
}

@And("^Close browser$")
public void close_browser() throws Throwable {
    driver.quit();
}}
