package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Data;
@Data
public class CheckoutOverviewPage extends BasePageElement {
	
	private By tituloCheckoutOverview = By.className("header_secondary_container");
	private String tituloEsperadoOverview = "Checkout: Overview";
	
	private By existeProductos = By.className("cart_item");
	private By botonFinish = By.id("finish");
	private By itemTotal = By.className("summary_subtotal_label");
	private By tax = By.className("summary_tax_label");
	private By TotalFinal =By.xpath("//div[@class='summary_info_label summary_total_label']");



	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
		
	}

}
