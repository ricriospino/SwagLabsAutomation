package browserManager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\chromedriver.exe");	
		driver = new ChromeDriver();	
	}
}
