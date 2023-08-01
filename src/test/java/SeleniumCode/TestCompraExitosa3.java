package SeleniumCode;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCompraExitosa3 extends TestBase  {
	
	 Properties properties = new Properties();
	
	
	
	@Given("^el usuario está logueado$")
	public void elUsuarioEstáLogueado() throws Throwable {
		
		properties.load(new FileReader("D:\\CursoJava\\workspace_seleniumUdemy\\LabMontAutomatizado\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    //Thread.sleep(2000);
		driver.findElement(loginPage.getBotonLogin()).submit();    
	 
	}

	@Given("^el usuario ha agregado al menos un item al carrito$")
	public void elUsuarioHaAgregadoAlMenosUnItemAlCarrito() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
	    //Thread.sleep(5000);
	    driver.findElement(homePage.getCarritoLLeno()).click();
	    //Thread.sleep(5000);
	}

	@Given("^el usuario se encuentra en la página de checkout Your Information$")
	public void elUsuarioSeEncuentraEnLaPáginaDeCheckoutYourInformation() throws Throwable {
		
		 driver.findElement(cartPage.getBotonCheckout()).click();
		 //Thread.sleep(5000);
		 
		 WebElement tituloPaginaCheckOutInfo = driver.findElement(checkoutYourInformationPage.getTituloCheckoutInfo());
		 assertEquals(checkoutYourInformationPage.getTituloEsperadoInfo(), tituloPaginaCheckOutInfo.getText());
	}

	@When("^el usuario completa todos los campos solicitados de información del cliente$")
	public void elUsuarioCompletaTodosLosCamposSolicitadosDeInformaciónDelCliente() throws Throwable {
	    
		driver.findElement(checkoutYourInformationPage.getInputFirstName()).sendKeys(properties.getProperty("first_name"));			
	    driver.findElement(checkoutYourInformationPage.getInputLastName()).sendKeys(properties.getProperty("last_name"));
	    driver.findElement(checkoutYourInformationPage.getInputZipName()).sendKeys(properties.getProperty("zip"));
	    //Thread.sleep(5000);
		
	}

	@When("^hace clic en el botón \"([^\"]*)\"$")
	public void haceClicEnElBotón(String botonCheckoutContinue) throws Throwable {
		
		WebElement botonContinue = driver.findElement(checkoutYourInformationPage.getBotonContinue());
		Assert.assertNotNull(botonContinue);
		
		botonContinue.click();
		//Thread.sleep(5000);
	    
	}

	@Then("^el usuario debería ser redirigido a la página de Checkout Overview$")
	public void elUsuarioDeberíaSerRedirigidoALaPáginaDeCheckoutOverview() throws Throwable {
		
		
	}

	@Given("^el usuario está en la página de Checkout Overview$")
	public void elUsuarioEstáEnLaPáginaDeCheckoutOverview() throws Throwable {
		
		WebElement paginaOverview = driver.findElement(checkoutOverviewPage.getTituloCheckoutOverview());
	    Assert.assertEquals(checkoutOverviewPage.getTituloEsperadoOverview(), paginaOverview.getText());
	    
	  
	}

	@When("^el usuario verifica los productos comprados y el total de la compra incluyendo Tax$")
	public void elUsuarioVerificaLosProductosCompradosYElTotalDeLaCompraIncluyendoTax() throws Throwable {
		
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
	
	@When("^hace clic en el boton \"([^\"]*)\"$")
	public void haceClicEnElBoton(String botonFinishData)throws Throwable {
		
		driver.findElement(checkoutOverviewPage.getBotonFinish()).click();
		//Thread.sleep(5000);
		
	}

	@Then("^la compra se realiza satisfactoriamente$")
	public void laCompraSeRealizaSatisfactoriamente() throws Throwable {
		
		WebElement compraExitosa = driver.findElement(checkoutComplete.getTituloFinish());
		Assert.assertEquals(checkoutComplete.getTituloEsperadoFinish(), compraExitosa.getText());
		//Thread.sleep(5000);
	}

	@Then("^el usuario debería ver un mensaje de confirmación de la compra$")
	public void elUsuarioDeberíaVerUnMensajeDeConfirmaciónDeLaCompra() throws Throwable {
		
		WebElement mensajeConfirmacion = driver.findElement(checkoutComplete.getTextoConfirmacion());
		Assert.assertEquals(checkoutComplete.getTextoEsperadoComplet(), mensajeConfirmacion.getText());
		//Thread.sleep(5000);
	}

}
