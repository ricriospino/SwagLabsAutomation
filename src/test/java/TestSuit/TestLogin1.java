package TestSuit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLogin1 extends TestBase {

	@Given("^El usuario se encuentra en la Pagina login$")
	public void elUsuarioSeEncuentraEnLaPaginaLogin() throws Throwable {
		
		WebElement tituloPrincipal =driver.findElement(loginPage.getTitulo());
		Assert.assertEquals(loginPage.getTituloEsperado(), tituloPrincipal.getText());
		Thread.sleep(1000);
	}

	@When("^ingresa su nombre de \"([^\"]*)\" y \"([^\"]*)\" válidos$")
	public void ingresaSuNombreDeYVálidos(String usuario, String contrasena) throws Throwable {
		
		WebElement inputUsuario = driver.findElement(loginPage.getInputUserName());
		inputUsuario.sendKeys(usuario);
		Thread.sleep(1000);
		
		WebElement inputContasena = driver.findElement(loginPage.getInputPassword());
		inputContasena.sendKeys(contrasena);
		Thread.sleep(1000);
	}

	@When("^hace clic en el botón login$")
	public void haceClicEnElBotónLogin() throws Throwable {
		
		WebElement botonAcceder = driver.findElement(loginPage.getBotonLogin());
		botonAcceder.submit();
		Thread.sleep(1000);
	}

	@Then("^debería ser redirigido a la página de Home Swag Labs$")
	public void deberíaSerRedirigidoALaPáginaDeHomeSwagLabs() throws Throwable {
		
		WebElement tituloHome = driver.findElement(homePage.getTitulo());
		Assert.assertEquals(homePage.getTituloEsperado(), tituloHome.getText());	    
	}
}
