package pages;

import org.openqa.selenium.By;

public class DashBoard extends BasePage{

	public DashBoard() {
		addObject("userName",By.xpath("//div[@id='dash-greeting' and contains(text(),'John')]"));
		addObject("currentBalance",By.xpath("//div[@data-testid='total-balance']"));
		addObject("nameUnderTransaction",By.xpath("//div[@class='tx-desc']"));
		addObject("dateUnderTransaction",By.xpath("//div[@class='tx-date']"));
		addObject("amountUnderTransactionCredit",By.xpath("//div[@class='tx-amount credit']"));
		addObject("amountUnderTransactionDebited",By.xpath("//div[@class='tx-amount debit']"));
		addObject("statusUnderTransaction",By.xpath("//div[@class='tx-status completed']"));
		addObject("creditColor",By.xpath("//*[@id=\"stats-grid\"]/div[2]/div[2]"));
		addObject("debitColor",By.xpath("//*[@id=\"stats-grid\"]/div[3]/div[2]"));
	}
}
