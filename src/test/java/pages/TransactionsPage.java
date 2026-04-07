package pages;

import org.openqa.selenium.By;

public class TransactionsPage extends BasePage{
	
	public TransactionsPage() {
		
		addObject("Date",By.xpath("//tr[@data-testid='tx-row-TX011']/td[1]"));
		addObject("Description",By.xpath("//tr[@data-testid='tx-row-TX011']/td[2]/div[text()='ATM Withdrawal']"));
		addObject("Account",By.xpath("//tr[@data-testid='tx-row-TX011']/td[3]"));
		addObject("Amount",By.xpath("//tr[@data-testid='tx-row-TX011']/td[4]"));
		addObject("Status",By.xpath("//tr[@data-testid='tx-row-TX011']/td[5]/span"));
		addObject("creditColor",By.xpath("//tbody/tr/td[4]"));
		addObject("debitColor",By.xpath("//tbody/tr/td[4]"));
		addObject("colorValidation",By.xpath("//table/tbody/tr"));
		addObject("searchTransactions",By.xpath("//input[@data-testid='tx-search']"));
		addObject("transactionType1",By.xpath("//select[@data-testid='tx-filter-type']"));
	}

}
