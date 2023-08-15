package browserManager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		System.setProperty("webdriver.gecko.driver","D:\\CursoJava\\workspace_seleniumUdemy\\LabMontAutomatizado\\src\\test\\java\\resurces\\geckodriver.exe");	
		driver = new FirefoxDriver();	
	}
}
