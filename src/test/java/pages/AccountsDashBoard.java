package pages;

import org.openqa.selenium.By;

public class AccountsDashBoard extends BasePage{
	
	public AccountsDashBoard() {
		
		addObject("accountType",By.xpath("//select[@id='new-actype']"));
		addObject("initialDeposit",By.xpath("//input[@id='new-ac-deposit']"));
		addObject("openAccount",By.xpath("//button[contains(text(),'Open Account')]"));
		
	}

}
