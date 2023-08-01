package browserManager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	
	protected abstract void createDriver();
	
	
	// si driver no es null cierra
	public void quitDriver() {
		
		if(driver!= null) {
			
			driver.quit();
			driver = null;
		}
	}
	
	// si driver es null crea driver
	public WebDriver getDriver() {
		if(driver == null) {
			createDriver();
		}
		
		return driver;
	}

}
