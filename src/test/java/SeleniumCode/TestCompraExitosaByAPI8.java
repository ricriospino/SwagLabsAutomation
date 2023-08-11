package SeleniumCode;

import java.io.FileReader;
import java.util.Properties;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import api.DataApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCompraExitosaByAPI8 extends TestBase{
	
	 Properties properties = new Properties();
	 DataApi dataApi = new DataApi();
	
	
	@Given("^el usuario API está logueado$")
	public void elUsuarioAPIEstáLogueado() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    driver.findElement(loginPage.getBotonLogin()).submit(); 
	}

	@Given("^el usuario API ha agregado al menos un item al carrito$")
	public void elUsuarioAPIHaAgregadoAlMenosUnItemAlCarrito() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
		driver.findElement(homePage.getCarrito()).click();
	}

	@Given("^el usuario API se encuentra en la página de checkout Your Information$")
	public void elUsuarioAPISeEncuentraEnLaPáginaDeCheckoutYourInformation() throws Throwable {
		
		 driver.findElement(cartPage.getBotonCheckout()).click();
		 WebElement tituloPaginaCheckOutInfo = driver.findElement(checkoutYourInformationPage.getTituloCheckoutInfo());
		 Assert.assertEquals(checkoutYourInformationPage.getTituloEsperadoInfo(), tituloPaginaCheckOutInfo.getText());
	    
	}

	@When("^el usuario API completa todos los campos solicitados de información del cliente$")
	public void elUsuarioAPICompletaTodosLosCamposSolicitadosDeInformaciónDelCliente() throws Throwable {
	   
	}

	@When("^realiza un request a través del endpoint con id \"([^\"]*)\" para obtener datos del usuario API$")
	public void realizaUnRequestATravésDelEndpointConIdParaObtenerDatosDelUsuarioAPI(String id) throws Throwable {
		
		JSONObject userData = dataApi.obtenerDatosUsuariosById(id);
		Thread.sleep(2000);
		driver.findElement(checkoutYourInformationPage.getInputFirstName()).sendKeys(userData.getString("username"));
		driver.findElement(checkoutYourInformationPage.getInputLastName()).sendKeys(userData.getString("email"));
		driver.findElement(checkoutYourInformationPage.getInputZipName()).sendKeys(userData.getString("phone"));
		Thread.sleep(2000);		
	}

	@When("^hace clic en el botón Continue$")
	public void haceClicEnElBotónContinue() throws Throwable {
		driver.findElement(checkoutYourInformationPage.getBotonContinue()).click();
	
	}

	@Then("^el usuario API debería ser redirigido a la página de Checkout Overview$")
	public void elUsuarioAPIDeberíaSerRedirigidoALaPáginaDeCheckoutOverview() throws Throwable {
	   
	}

	@Given("^el usuario API está en la página de Checkout Overview$")
	public void elUsuarioAPIEstáEnLaPáginaDeCheckoutOverview() throws Throwable {
		
		WebElement paginaOverview = driver.findElement(checkoutOverviewPage.getTituloCheckoutOverview());
	    Assert.assertEquals(checkoutOverviewPage.getTituloEsperadoOverview(), paginaOverview.getText());
	    Thread.sleep(2000);	
	}

	@When("^el usuario API verifica los productos comprados y el total de la compra incluyendo Tax$")
	public void elUsuarioAPIVerificaLosProductosCompradosYElTotalDeLaCompraIncluyendoTax() throws Throwable {
	   
		WebElement productoExiste = driver.findElement(checkoutOverviewPage.getExisteProductos());
		Assert.assertNotNull(productoExiste);
	    
		// -----------------------------
		WebElement itemTotal = driver.findElement(checkoutOverviewPage.getItemTotal());
		WebElement tax = driver.findElement(checkoutOverviewPage.getTax());
		WebElement total = driver.findElement(checkoutOverviewPage.getTotalFinal());
		
		double itemTotalParse = Double.parseDouble(itemTotal.getText().substring(13));
		double taxParse = Double.parseDouble(tax.getText().substring(6));
		double totalParse = Double.parseDouble(total.getText().substring(8));
		
		double sumaTotal = itemTotalParse + taxParse;
		
		if(sumaTotal == totalParse) {
			Assert.assertTrue("La suma es la correcta",true);
		}else {
			Assert.assertTrue("La suma no es la correcta",false);
		}
		Thread.sleep(2000);	
	}

	@When("^hace clic en el botón Finish$")
	public void haceClicEnElBotónFinish() throws Throwable {
		driver.findElement(checkoutOverviewPage.getBotonFinish()).click();
		Thread.sleep(2000);	
	}

	@Then("^la compra se realiza Exitosamente$")
	public void laCompraSeRealizaExitosamente() throws Throwable {
		WebElement compraExitosa = driver.findElement(checkoutComplete.getTituloFinish());
		Assert.assertEquals(checkoutComplete.getTituloEsperadoFinish(), compraExitosa.getText());
		Thread.sleep(2000);	
	}

	@Then("^el usuario API debería ver un mensaje de confirmación de la compra$")
	public void elUsuarioAPIDeberíaVerUnMensajeDeConfirmaciónDeLaCompra() throws Throwable {
		WebElement mensajeConfirmacion = driver.findElement(checkoutComplete.getTextoConfirmacion());
		Assert.assertEquals(checkoutComplete.getTextoEsperadoComplet(), mensajeConfirmacion.getText());
		Thread.sleep(2000);
	}


}
