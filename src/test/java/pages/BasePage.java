package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;



public class BasePage extends BaseTest {
	
	HashMap<String,By> objectRepo=new HashMap<String,By>();
	long expectedTotal;
	int totalPriceUI;
	
	public void addObject(String logicalName,By by)
	{
		objectRepo.put(logicalName, by);
	}
	
	
	
	public void type(String logicalName, String value) {
		getElement(logicalName).sendKeys(value);
	}
	
	public void validateTitle(String title) {
		
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, title);
	}
	
	
	public void click(String logicalName) {
		getElement(logicalName).click();
	}
	
	public void validateName(String logicalName) {
		
		
		boolean actualName=getElement(logicalName).isDisplayed();
		Assert.assertTrue(actualName);
	}
	
	public void countTransactions(int transactions) {
		List<WebElement> transactions1 = driver.findElements(By.xpath("//div[@id='dash-tx-list']//div[@class='tx-item']"));
		System.out.println("Count of Transactions="+transactions1.size());
		
		Assert.assertEquals(transactions1.size(), transactions);
	}
	
	public void validateAll(String logicalName) {
		

		List<WebElement> elements=getElements(logicalName);
		for(WebElement ele : elements)
		{
         String text=ele.getText();
         System.out.println(logicalName+" "+text);
         Assert.assertFalse(text.isEmpty());
		}
		
	}
	
    public List<WebElement> getElements(String logicalName) {
		
		By by=objectRepo.get(logicalName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 List<WebElement> elements = wait.until(
			        ExpectedConditions.visibilityOfAllElementsLocatedBy(by)
			    );
		return elements;
		
	}
    
    public WebElement getElement(String logicalName) {
		
		By by=objectRepo.get(logicalName);
		WebElement element=driver.findElement(by);
		return element;
		
	}
	
    public void validateColor(String typeTrasaction, String colorValue) {
    	WebElement credits= getElement(typeTrasaction);
    	WebElement debits= getElement(typeTrasaction);
    	
    	String creditColor = credits.getCssValue("color");
    	String debitColor = debits.getCssValue("color");
    	
    	if(colorValue.equalsIgnoreCase("green")) {
            Assert.assertTrue("Expected green but got: " + creditColor,
            		creditColor.contains("34, 197, 94")); // your green
        }
        else if(colorValue.equalsIgnoreCase("red")) {
            Assert.assertTrue("Expected red but got: " + debitColor,
            		debitColor.contains("239, 68, 68")); // your red
        }
    }
    
       public void validateAccounts() {
    	List<WebElement> accounts=driver.findElements(By.xpath("//div[@id='dash-accounts-summary']/div"));
    	System.out.println(accounts.size());
    	
    	for(WebElement acc : accounts) {

    	    String name = acc.findElement(By.xpath("./div[1]")).getText();
    	    String balance = acc.findElement(By.xpath("./div[2]")).getText();

    	    System.out.println("Name: " + name);
    	    System.out.println("Balance: " + balance);
    	    Assert.assertFalse(name.isEmpty());
    	    Assert.assertFalse(balance.isEmpty());
    	}
    }

}