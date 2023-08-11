package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePageElement {
	
	
	private By botonLogout = By.id("logout_sidebar_link");
	private By botonResetApp = By.id("reset_sidebar_link");
	
	

	public By getBotonResetApp() {
		return botonResetApp;
	}

	public By getBotonLogout() {
		return botonLogout;
	}

	public MenuPage(WebDriver driver) {
		super(driver);	
	}

}
