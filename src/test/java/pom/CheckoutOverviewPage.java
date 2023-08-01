package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePageElement {
	
	private By tituloCheckoutOverview = By.className("header_secondary_container");
	private String tituloEsperadoOverview = "Checkout: Overview";
	
	private By existeProductos = By.className("cart_item");
	private By botonFinish = By.id("finish");
	private By itemTotal = By.className("summary_subtotal_label");
	private By tax = By.className("summary_tax_label");
	private By TotalFinal =By.xpath("//div[@class='summary_info_label summary_total_label']");

	public By getItemTotal() {
		return itemTotal;
	}

	public By getTax() {
		return tax;
	}

	public By getTotalFinal() {
		return TotalFinal;
	}

	public By getBotonFinish() {
		return botonFinish;
	}

	public By getExisteProductos() {
		return existeProductos;
	}

	public By getTituloCheckoutOverview() {
		return tituloCheckoutOverview;
	}

	public String getTituloEsperadoOverview() {
		return tituloEsperadoOverview;
	}

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
		
	}

}
