package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Data;

@Data
public class CheckoutYourInformationPage extends BasePageElement{

	private By inputFirstName = By.id("first-name");
	private By inputLastName = By.id("last-name");
	private By inputZipName = By.id("postal-code");
	private By botonContinue = By.id("continue");
	private By tituloCheckoutInfo = By.className("header_secondary_container");
	
	private String botonesperadoContinue = "Continue";
	private String tituloEsperadoInfo ="Checkout: Your Information";

	public CheckoutYourInformationPage(WebDriver driver) {
		super(driver);
		
	}

}
