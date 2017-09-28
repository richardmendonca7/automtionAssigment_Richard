package pages;

import org.openqa.selenium.WebDriver;

public abstract class SeleniumBaseClass {
	static String driverpath=System.getProperty("user.dir");;
	static WebDriver driver=null;
}
