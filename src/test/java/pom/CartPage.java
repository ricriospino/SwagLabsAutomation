package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Data;
@Data
public class CartPage  extends BasePageElement {

	private By productoMayorSeleccionado  = By.id("item_5_title_link");
	private String productoEsperadoCarrito = "Sauce Labs Fleece Jacket";
	private By removerProductoMayor = By.id("remove-sauce-labs-fleece-jacket");	
	private By carritoVacio = By.className("removed_cart_item");
	private By botonCheckout = By.id("checkout");
	

	public CartPage(WebDriver driver) {
		super(driver);
		
	}

}
