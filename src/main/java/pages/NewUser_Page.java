package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewUser_Page extends SeleniumBaseClass{

	//################### Locators ####################
	private static final By name_txtbox =  By.id("name");
	private static final By email_txtbox = By.id("email");
	private static final By password_txtbox = By.id("password");
	private static final By confirmation_Password_txtbox =By.id("confirmationPassword");
	private static final By submit_button = By.xpath("//button[text()='Submit']");
	private static final By alluser_link = By.xpath("//a[text()='All User']");
	private static final By confirmationPasswordError_alert = By.id("user.confirmationPassword.error");
	private static final By nameError_alert = By.id("user.name.error");
	private static final By emailError_alert = By.id("user.email.error");
	private static final By passwordError_alert = By.id("user.password.error");

	//##################################################
	//################# Keywords #######################

	public void OpenBrowerWithUrl(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", driverpath+"\\browser\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize(); // maximize window
		driver.navigate().to("http://85.93.17.135:9000/user/new");
	}

	public void closeBrowser() {
		driver.close();
	}

	public void setName(String val) {
		driver.findElement(name_txtbox).sendKeys(val);
	}

	public void setEmail(String val) {
		driver.findElement(email_txtbox).sendKeys(val);
	}

	public void setPassword(String val) {
		driver.findElement(password_txtbox).sendKeys(val);
	}

	public void setConfirmationPassword(String val) {
		driver.findElement(confirmation_Password_txtbox).sendKeys(val);
	}

	public void clickSubmitButton() {
		driver.findElement(submit_button).click();
	}

	public void clickAllUserButton() {
		driver.findElement(alluser_link).click();
	}

	public boolean verifyConfirmationPasswordError() {
		boolean isdisplayed=false;
		if(driver.findElement(confirmationPasswordError_alert).isDisplayed()) {
			if(driver.findElement(confirmationPasswordError_alert).getText().equals("passwords are not the same")){
				isdisplayed=true;
			}
		}
		return isdisplayed;
	}

	public boolean verifyPasswordError() {
		boolean isdisplayed=false;
		if(driver.findElement(passwordError_alert).isDisplayed()) {
			if(driver.findElement(passwordError_alert).getText().equals("Required")){
				isdisplayed=true;
			}
		}
		return isdisplayed;
	}

	public boolean verifyNameError() {
		boolean isdisplayed=false;
		if(driver.findElement(nameError_alert).isDisplayed()) {
			if(driver.findElement(nameError_alert).getText().equals("Required")){
				isdisplayed=true;
			}
		}
		return isdisplayed;
	}

	public boolean verifyEmailError() {
		boolean isdisplayed=false;
		if(driver.findElement(emailError_alert).isDisplayed()) {
			if(driver.findElement(emailError_alert).getText().equals("Required")){
				isdisplayed=true;
			}
		}
		return isdisplayed;
	}

	public boolean verifyDuplicateNameError() {
		boolean isdisplayed=false;
		if(driver.findElement(nameError_alert).isDisplayed()) {
			if(driver.findElement(nameError_alert).getText().equals("Must be unique")){
				isdisplayed=true;
			}
		}
		return isdisplayed;
	}

}
