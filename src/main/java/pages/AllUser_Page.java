package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllUser_Page extends SeleniumBaseClass{
	//################### Locators ####################
		private static final By newUser_button = By.xpath("//a[text()='New User']");
		private static final By name_column	= By.cssSelector("table  tr  td:nth-child(1)");
		private static final By email_column	= By.cssSelector("table  tr  td:nth-child(2)");
		private static final By password_column	= By.cssSelector("table  tr  td:nth-child(3)");
	//##################################################
	//################# Keywords #######################
		
		
	public boolean verifyUserPresentInTable(String name,String email,String pass) {
		boolean isPresent=false;
		List<WebElement> names= driver.findElements(name_column);
		List<WebElement> emails= driver.findElements(email_column);
		List<WebElement> password= driver.findElements(password_column);
		for (int i=0;i<names.size();i++) { 
	        if(names.get(i).getText().equals(name)) {
	        	if(emails.get(i).getText().equals(email)) {
	        		if(password.get(i).getText().equals(pass)) {
	        			isPresent=true;
	        			break;
	        		}
	        	}
	        }
	    }
		return isPresent;
	}
	
	public void clickNewUserButton() {
		driver.findElement(newUser_button).click();
	}
	
}
