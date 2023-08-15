package TestSuit;

import java.io.FileReader;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestResetApp6 extends TestBase {
	
	Properties properties = new Properties();

	@Given("^el usuario esta logueado$")
	public void elUsuarioEstaLogueado() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));	
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));	
		Thread.sleep(1000);
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    Thread.sleep(1000);
		driver.findElement(loginPage.getBotonLogin()).submit();  
		Thread.sleep(1000);
	}
	
	@Given("^el usuario ha seleccionado al menos un producto en el carrito$")
	public void elUsuarioHaSeleccionadoAlMenosUnProductoEnElCarrito() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
		Thread.sleep(1000);
		driver.findElement(homePage.getAgregarProductoBarato()).click();
		Thread.sleep(1000);	   
	}

	@When("^el usuario realiza un reset de la App de compra$")
	public void elUsuarioRealizaUnResetDeLaAppDeCompra() throws Throwable {
		
		driver.findElement(homePage.getMenuBurger()).click();
		Thread.sleep(1000);
		driver.findElement(menuPage.getBotonResetApp()).click();
		Thread.sleep(1000);	
	}

	@Then("^el carrito de compra debería estar vacío$")
	public void elCarritoDeCompraDeberíaEstarVacío() throws Throwable {
		
		WebElement carrito = driver.findElement(homePage.getCarrito());	
		if(carrito.getText().equals("")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

}
