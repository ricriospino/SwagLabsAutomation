package SeleniumCode;

import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestAgregarProductoyRemover2 extends TestBase {

	@Given("^un usuario se encuentra en la pagina login$")
	public void unUsuarioSeEncuentraEnLaPaginaLogin() throws Throwable {
		
		driver.findElement(loginPage.getTitulo());		   
	}

	@When("^ingresa credenciales validas$")
	public void ingresaCredencialesValidas() throws Throwable {
		
		Properties properties = new Properties();
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
		driver.findElement(loginPage.getBotonLogin()).submit();    
	}

	
	@Given("^estoy en la página de inicio$")
	public void estoyEnLaPáginaDeInicio() throws Throwable {
		WebElement tituloHome = driver.findElement(homePage.getTitulo());
		Assert.assertEquals(homePage.getTituloEsperado(), tituloHome.getText());
	    
	}

	@When("^busco el producto de mayor valor$")
	public void buscoElProductoDeMayorValor() throws Throwable {
		//Thread.sleep(5000);
		WebElement dropDownListElement = driver.findElement(homePage.getDropDwnList());
		dropDownListElement.click();
		//Thread.sleep(5000);
		
		WebElement productoEsperado = driver.findElement(homePage.getProductoMayorValorname());
		Assert.assertEquals(homePage.getProductoMayorValorEsperado(), productoEsperado.getText());
    
	}

	@When("^hago clic en el botón de agregar al carrito$")
	public void hagoClicEnElBotónDeAgregarAlCarrito() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
	    //Thread.sleep(2000);
	}

	@Then("^el logo carrito de la parte superior debera tener un numero$")
	public void elLogoCarritoDeLaParteSuperiorDeberaTenerUnNumero() throws Throwable {
		
		WebElement carritolleno = driver.findElement(homePage.getCarritoLLeno());
		
		if(carritolleno.getText() != null) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	   
	}

	@Then("^verificar en la pagina cart si el producto se agrego correctamente$")
	public void verificarEnLaPaginaCartSiElProductoSeAgregoCorrectamente() throws Throwable {
		
		driver.findElement(homePage.getCarritoLLeno()).click();
		//Thread.sleep(2000);
		WebElement productoCarrito = driver.findElement(cartPage.getProductoMayorSeleccionado());
		Assert.assertEquals(cartPage.getProductoEsperadoCarrito(), productoCarrito.getText());

	}
	

	@When("^el usuario decide remover el producto del carrito$")
	public void elUsuarioDecideRemoverElProductoDelCarrito() throws Throwable {
		
		driver.findElement(cartPage.getRemoverProductoMayor()).click();
		//Thread.sleep(3000);
	}

	@Then("^verificar si el producto se removio exitosamente$")
	public void verificarSiElProductoSeRemovioExitosamente() throws Throwable {
		
		WebElement carritoVacio = driver.findElement(cartPage.getCarritoVacio());		
		Assert.assertEquals("", carritoVacio.getText());
		 
	}


}
