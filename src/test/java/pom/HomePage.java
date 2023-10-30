package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Data;

@Data
public class HomePage extends BasePageElement  {
	
	private String tituloEsperado ="Swag Labs";
	private By titulo = By.cssSelector("div.app_logo");
	private String ProductoMayorValorEsperado = "Sauce Labs Fleece Jacket";
	private String carritoitemEsperado ="2";
	
	private By productoMayorValorname = By.id("item_5_title_link");
	private By dropDwnList = By.cssSelector("select.product_sort_container option:last-child");
	private By agregarProductoCaro = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By agregarProductoBarato = By.id("add-to-cart-sauce-labs-bike-light");
	private By carritoLLeno = By.className("shopping_cart_badge");
	private By carrito = By.className("shopping_cart_link");
	private By menuBurger = By.className("bm-burger-button");

	
	public HomePage(WebDriver driver) {
		super(driver);
	
	}

}
