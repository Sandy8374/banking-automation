package pages;

import org.openqa.selenium.By;

public class FundTransferPage extends BasePage{
	
	public FundTransferPage() {
		addObject("fromAccount",By.xpath("//select[@data-testid='transfer-from']"));
		addObject("transferType",By.xpath("//select[@data-testid='transfer-type']"));
		addObject("toAccount",By.xpath("//select[@data-testid='transfer-to-account']"));
		addObject("amountTransfer",By.xpath("//input[@data-testid='transfer-amount']"));
		addObject("transferNow",By.xpath("//button[@data-testid='transfer-btn']"));
		addObject("SuccessfullyTransferred",By.xpath("//div[@id='transfer-success']"));
		addObject("transferError",By.xpath("//div[@id='transfer-error']"));
		addObject("recipientAccountNo",By.xpath("//input[@data-testid='transfer-ext-acc']"));
		addObject("recipientName",By.xpath("//input[@data-testid='transfer-ext-name']"));
		addObject("ifscCode",By.xpath("//input[@data-testid='transfer-ifsc']"));
	}

}
