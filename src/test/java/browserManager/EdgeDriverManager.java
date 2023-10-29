package browserManager;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	protected void createDriver() {	
		System.setProperty("webdriver.edge.driver","C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\msedgedriver.exe");	
		driver = new EdgeDriver();
		
	}
}
