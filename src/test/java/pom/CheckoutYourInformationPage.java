package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePageElement{

	private By inputFirstName = By.id("first-name");
	private By inputLastName = By.id("last-name");
	private By inputZipName = By.id("postal-code");
	private By botonContinue = By.id("continue");
	private By tituloCheckoutInfo = By.className("header_secondary_container");
	
	private String botonesperadoContinue = "Continue";
	private String tituloEsperadoInfo ="Checkout: Your Information";

	public By getInputFirstName() {
		return inputFirstName;
	}

	public By getInputLastName() {
		return inputLastName;
	}

	public By getInputZipName() {
		return inputZipName;
	}

	public By getBotonContinue() {
		return botonContinue;
	}

	public By getTituloCheckoutInfo() {
		return tituloCheckoutInfo;
	}

	public String getBotonesperadoContinue() {
		return botonesperadoContinue;
	}

	public String getTituloEsperadoInfo() {
		return tituloEsperadoInfo;
	}

	public CheckoutYourInformationPage(WebDriver driver) {
		super(driver);
		
	}

}
