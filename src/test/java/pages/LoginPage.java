package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	public LoginPage() {
		addObject("userEmail",By.id("login-email"));
		addObject("userPassword",By.id("login-password"));
		addObject("LoginButton",By.xpath("//button[text()='Sign In']"));
	}

}
