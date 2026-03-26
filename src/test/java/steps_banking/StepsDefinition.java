package steps_banking;


import org.junit.Assert
;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.DashBoard;
import pages.LoginPage;


public class StepsDefinition extends BaseTest {
	BasePage page;
	
	@Before
	public void setUp()
	{
		BaseTest.launchApplictaion();
	}
	
	@After
	public void teardown()
	{
		if(driver != null)
	    {
	        driver.quit();
	        driver = null;   // VERY IMPORTANT
	    }
	}
		
	
	@Given("user is on {string}")
	public void user_is_on(String pageName) {
		
		switch(pageName.toLowerCase())
		{
		case "loginpage" : 
			page=new LoginPage();
			break;
			
		case "dashboard":
			page=new DashBoard();
			break;
			
		
			default: 
				break;
			
			
		}
	    
	}
	
	@Then("validate {string} is present")
	public void validate_is_present(String logicalName) {
		
		page.validateName(logicalName);
	    
	}
	
	@Then("user enters text into textbox {string} {string}")
	public void user_enters_text_into_textbox(String logicalName, String value) {
	    page.type(logicalName,value);
	}
	
	@Then("user clicks {string}")
	public void user_clicks(String logicalName) {
	    page.click(logicalName);
	}
	@Then("validate title should be {string}")
	public void validate_title_should_be(String title) {
		page.validateTitle(title);
	}
	
	@Then("last {int} transactions should be displayed")
	public void last_transactions_should_be_displayed(Integer transactions) {
	    page.countTransactions(transactions);
	}
	
	@Then("validate {string} is present in each transaction")
	public void validate_is_present_in_each_transaction(String logicalName) {
		
		page.validateAll(logicalName);
	    
	}
	
	@Then("validate color of {string} should be {string}")
	public void validate_color_of_should_be(String typeTrasaction, String colorValue) {
	    
		page.validateColor(typeTrasaction,colorValue);
	}
	
	@Then("validate total number of accounts")
	public void validate_total_number_of_accounts() {
	    page.validateAccounts();	
	}






	
}

