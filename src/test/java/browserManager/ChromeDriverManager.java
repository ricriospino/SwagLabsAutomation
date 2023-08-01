package browserManager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		
		System.setProperty("webdriver.chrome.driver","D:\\CursoJava\\workspace_seleniumUdemy\\LabMontAutomatizado\\src\\test\\java\\resurces\\chromedriver.exe");	
		driver = new ChromeDriver();
		
	}

}
