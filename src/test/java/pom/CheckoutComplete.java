package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends BasePageElement {
	
	private String tituloEsperadoFinish = "Thank you for your order!";
	private By tituloFinish = By.className("complete-header");
	
	private By  textoConfirmacion = By.className("complete-text");
	private String textoEsperadoComplet = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
	
	
	

	public By getTextoConfirmacion() {
		return textoConfirmacion;
	}



	public String getTextoEsperadoComplet() {
		return textoEsperadoComplet;
	}



	public String getTituloEsperadoFinish() {
		return tituloEsperadoFinish;
	}



	public By getTituloFinish() {
		return tituloFinish;
	}



	public CheckoutComplete(WebDriver driver) {
		super(driver);
		
	}

}
