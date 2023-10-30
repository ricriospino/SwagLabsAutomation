package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Data;

@Data
public class MenuPage extends BasePageElement {
		
	private By botonLogout = By.id("logout_sidebar_link");
	private By botonResetApp = By.id("reset_sidebar_link");
	
	public MenuPage(WebDriver driver) {
		super(driver);	
	}

}
