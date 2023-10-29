package browserManager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\geckodriver.exe");	
		driver = new FirefoxDriver();	
	}
}
