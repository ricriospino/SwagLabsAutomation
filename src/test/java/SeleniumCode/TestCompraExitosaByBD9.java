package SeleniumCode;

import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import db.DataBaseConetion;

public class TestCompraExitosaByBD9 extends TestBase  {
	
	 Properties properties = new Properties();
	
	@Given("^el usuario BD está logueado$")
	public void elUsuarioBDEstáLogueado() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    driver.findElement(loginPage.getBotonLogin()).submit(); 
	    
	}

	@Given("^el usuario BD ha agregado al menos un item al carrito$")
	public void elUsuarioBDHaAgregadoAlMenosUnItemAlCarrito() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
		driver.findElement(homePage.getCarrito()).click();
	   
	}

	@Given("^el usuario BD se encuentra en la página de checkout Your Information$")
	public void elUsuarioBDSeEncuentraEnLaPáginaDeCheckoutYourInformation() throws Throwable {
	   
		driver.findElement(cartPage.getBotonCheckout()).click();
	}

	@When("^el usuario BD completa todos los campos solicitados de información del cliente$")
	public void elUsuarioBDCompletaTodosLosCamposSolicitadosDeInformaciónDelCliente() throws Throwable {
	  
		
	}

	@When("^realiza una consulta a la base de datos a traves de una query para obtener el usuario con id \"([^\"]*)\" para enviar datos del usuario$")
	public void realizaUnaConsultaALaBaseDeDatosATravesDeUnaQueryParaObtenerElUsuarioConIdParaEnviarDatosDelUsuario(String id) throws Throwable {
	
		try {
			
			ResultSet usuarioBD = DataBaseConetion.obtenerUsuarioById(Integer.parseInt(id));
			while (usuarioBD.next()) {
				driver.findElement(checkoutYourInformationPage.getInputFirstName()).sendKeys(usuarioBD.getString("name"));
				driver.findElement(checkoutYourInformationPage.getInputLastName()).sendKeys(usuarioBD.getString("location"));
				driver.findElement(checkoutYourInformationPage.getInputZipName()).sendKeys(usuarioBD.getString("age"));				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@When("^hace click en el botón Continue$")
	public void haceClickEnElBotónContinue() throws Throwable {
		
		driver.findElement(checkoutYourInformationPage.getBotonContinue()).click();
	  
	}

	@Then("^el usuario BD debería ser redirigido a la página de Checkout Overview$")
	public void elUsuarioBDDeberíaSerRedirigidoALaPáginaDeCheckoutOverview() throws Throwable {
		
		
	   
	}

	@Given("^el usuario BD está en la página de Checkout Overview$")
	public void elUsuarioBDEstáEnLaPáginaDeCheckoutOverview() throws Throwable {
		
		WebElement paginaOverview = driver.findElement(checkoutOverviewPage.getTituloCheckoutOverview());
	    Assert.assertEquals(checkoutOverviewPage.getTituloEsperadoOverview(), paginaOverview.getText());
	 
	}

	@When("^el usuario BD verifica los productos comprados y el total de la compra incluyendo Tax$")
	public void elUsuarioBDVerificaLosProductosCompradosYElTotalDeLaCompraIncluyendoTax() throws Throwable {
		
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
	  
	}

	@When("^hace click en el botón Finish$")
	public void haceClickEnElBotónFinish() throws Throwable {
		
		driver.findElement(checkoutOverviewPage.getBotonFinish()).click();
	
	}

	@Then("^la compra se realiza de manera correcta$")
	public void laCompraSeRealizaDeManeraCorrecta() throws Throwable {
		
		WebElement compraExitosa = driver.findElement(checkoutComplete.getTituloFinish());
		Assert.assertEquals(checkoutComplete.getTituloEsperadoFinish(), compraExitosa.getText());
	    
	}

	@Then("^el usuario BD debería ver un mensaje de confirmación de la compra$")
	public void elUsuarioBDDeberíaVerUnMensajeDeConfirmaciónDeLaCompra() throws Throwable {
		
		WebElement mensajeConfirmacion = driver.findElement(checkoutComplete.getTextoConfirmacion());
		Assert.assertEquals(checkoutComplete.getTextoEsperadoComplet(), mensajeConfirmacion.getText());
	   
	}

}
