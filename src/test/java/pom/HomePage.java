package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePageElement  {
	
	private String tituloEsperado ="Swag Labs";
	private By titulo = By.cssSelector("div.app_logo");
	private String ProductoMayorValorEsperado = "Sauce Labs Fleece Jacket";
	
	private By productoMayorValorname = By.id("item_5_title_link");
	private By dropDwnList = By.cssSelector("select.product_sort_container option:last-child");
	private By agregarProductoCaro = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By carritoLLeno = By.className("shopping_cart_badge");
	
	private By menuBurger = By.className("bm-burger-button");
	
	
	public By getMenuBurger() {
		return menuBurger;
	}

	public String getProductoMayorValorEsperado() {
		return ProductoMayorValorEsperado;
	}

	public By getDropDwnList() {
		return dropDwnList;
	}

	public By getProductoMayorValorname() {
		return productoMayorValorname;
	}


	public By getAgregarProductoCaro() {
		return agregarProductoCaro;
	}

	public String getTituloEsperado() {
		return tituloEsperado;
	}

	public By getTitulo() {
		return titulo;
	}
	
	public By getCarritoLLeno() {
		return carritoLLeno;
	}

	public HomePage(WebDriver driver) {
		super(driver);
	
	}

}
