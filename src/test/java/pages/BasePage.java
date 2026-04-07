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
	
	public void typeInt(String logicalName, int value) {
	    getElement(logicalName).sendKeys(String.valueOf(value));
	}
	
	
	public void validateTitle(String title) {
		
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, title);
	}
	
	
	public void click(String logicalName) throws InterruptedException {
		getElement(logicalName).click();
		Thread.sleep(3000);
	}
	
	public void validateName(String logicalName) {
		
		
		boolean actualName=getElement(logicalName).isDisplayed();
		System.out.println(getElement(logicalName).getText());
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
    
    public void validateColorTransactions(String logicalName) {

    	List<WebElement> rows=getElements(logicalName);
    	for(WebElement row:rows) {
    		
    		WebElement amountElement = row.findElement(By.xpath(".//td[contains(text(),'₹')]"));
    		String amountText = amountElement.getText();
    		String color=amountElement.getCssValue("color");
    		System.out.println(amountText + " -> " + color);
    		
    		if(color.equalsIgnoreCase("green")) {
                Assert.assertTrue("Expected green but got: " + color,
                		color.contains("34, 197, 94, 1")); // your green
                System.out.println("Green Color : "+color);
            }
            else if(color.equalsIgnoreCase("red")) {
                Assert.assertTrue("Expected red but got: " + color,
                		color.contains("239, 68, 68, 1")); // your red
            }
    		
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
       
       public void validateSearchTransactions() {
    	   

    	   List<WebElement> transactions = driver.findElements(By.xpath("//tbody/tr"));
    	   
    	   System.out.println(transactions.size());
    	   
    	   for(WebElement transaction : transactions) {
    		   String description = transaction.findElement(By.xpath("//tbody/tr/td[2]/div[1]")).getText();
    		   System.out.println(description);
    		   Assert.assertEquals("ATM Withdrawal", description);
    	   }
    	   
       }
       
       public void validateAccountsUnderAccounts() {
    	   List<WebElement> accounts = driver.findElements(
    			    By.xpath("//div[@id='accounts-grid']//div[@class='account-card']")
    			);
    	   System.out.println(accounts.size());
    	   
    	   for(WebElement acc:accounts) {
    		   
    		   System.out.println("----ACCOUNT----");

    		    String type = acc.findElement(By.xpath(".//div[@class='account-type']")).getText();
    		    String number = acc.findElement(By.xpath(".//div[@class='account-number']")).getText();
    		    String balance = acc.findElement(By.xpath(".//div[@class='account-balance']")).getText();
    		    String name = acc.findElement(By.xpath(".//div[@class='account-name']")).getText();
    		    String status = acc.findElement(By.xpath(".//span[contains(@class,'badge')]")).getText();

    		    System.out.println("Type: " + type);
    		    System.out.println("Number: " + number);
    		    System.out.println("Balance: " + balance);
    		    System.out.println("Name: " + name);
    		    System.out.println("Status: " + status);

    		    // ✅ Assertions
    		    Assert.assertFalse(type.isEmpty());
    		    Assert.assertFalse(number.isEmpty());
    		    Assert.assertFalse(balance.isEmpty());
    		    Assert.assertFalse(name.isEmpty());
    		    Assert.assertTrue(status.equalsIgnoreCase("active"));
    	   }
       }
       
       public void select(String value,String logicalName) throws InterruptedException {
    	   
    	   WebElement accounttype=getElement(logicalName);
    	   //System.out.println(accounttype.getText());
    	   Select s1=new Select(accounttype);
    	   s1.selectByVisibleText(value);
    	   Thread.sleep(2000);
       }
       
       public void validateType(String transactionType) {
    	   
    	   List<WebElement> amounts= driver.findElements(By.xpath("//tbody/tr/td[@class='tx-amount credit']"));
    	   
    	   System.out.println(amounts);
    	   
    	   for(WebElement amount:amounts) {
    		   String value=amount.getText().trim();
    		   
    		   if (transactionType.equalsIgnoreCase("Credit")) {
    			   System.out.println(value);
    			   if(!value.startsWith("+")) {
    				   throw new AssertionError("Found non-credit transaction: " + value);
    				   
    			   }
    		   }
    		   
    		   else if (transactionType.equalsIgnoreCase("Debit")) {
    			   System.out.println(value);
    			   if(!value.startsWith("-")) {
    				   throw new AssertionError("Found non-debit transaction: "+ value);
    			   }
    		   }
    	   }
    	   
       }
       
       public void validateError(String transferError,String expectedMessage) {
    	   
    	   String ActualValue=getElement(transferError).getText();
    	   System.out.println(ActualValue);
    	   Assert.assertEquals(expectedMessage, ActualValue);

       }
       
       

}