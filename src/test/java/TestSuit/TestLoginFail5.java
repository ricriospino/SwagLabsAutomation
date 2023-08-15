package TestSuit;

import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLoginFail5 extends TestBase{
	
	@Given("^que el usuario está en la página de inicio de sesión$")
	public void queElUsuarioEstáEnLaPáginaDeInicioDeSesión() throws Throwable {
		
		WebElement tituloPrincipal =driver.findElement(loginPage.getTitulo());
		Assert.assertEquals(loginPage.getTituloEsperado(), tituloPrincipal.getText());
	  
	}

	@When("^el usuario ingresa el nombre de usuario incorrecto o la contrasena incorrecta$")
	public void elUsuarioIngresaElNombreDeUsuarioIncorrectoOLaContrasenaIncorrecta() throws Throwable {
	
		driver.findElement(loginPage.getInputUserName()).sendKeys(loginPage.getUsuarioIncorrecto());
		Thread.sleep(1000);
		driver.findElement(loginPage.getInputPassword()).sendKeys(loginPage.getPasswordIncorrecto());
		Thread.sleep(1000);
		
	}

	@When("^hace clic en el botón Login$")
	public void haceClicEnElBotónLogin() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();
		Thread.sleep(1000);
	}

	@Then("^el usuario debería ver el mensaje de error \"([^\"]*)\" en rojo\\.$")
	public void elUsuarioDeberíaVerElMensajeDeErrorEnRojo(String mensajeErrorEsperado) throws Throwable {
		
		WebElement mensajeErrorObtenido = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(mensajeErrorEsperado, mensajeErrorObtenido.getText());
		Thread.sleep(1000);
	}

	@When("^el usuario ingresa el nombre de usuario null y la contrasena correcta$")
	public void elUsuarioIngresaElNombreDeUsuarioNullYLaContrasenaCorrecta() throws Throwable {
		
		driver.findElement(loginPage.getInputUserName()).sendKeys("");
		driver.findElement(loginPage.getInputPassword()).sendKeys(loginPage.getPasswordIncorrecto());  
		Thread.sleep(1000);
	}

	@When("^hace clic en el botón Login por segunda vez$")
	public void haceClicEnElBotónLoginPorSegundaVez() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();	  
		Thread.sleep(1000);
	}

	@Then("^el usuario debería ver el mensaje de error Epic sadface: Username is required en rojo\\.$")
	public void elUsuarioDeberíaVerElMensajeDeErrorEpicSadfaceUsernameIsRequiredEnRojo() throws Throwable {
		
		WebElement mensajeErrorObtenido = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(loginPage.getMensajeUserNull(), mensajeErrorObtenido.getText());	
		Thread.sleep(1000);
	}

	@When("^el usuario ingresa el nombre de usuario correcto y la contrasena null$")
	public void elUsuarioIngresaElNombreDeUsuarioCorrectoYLaContrasenaNull() throws Throwable {
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(loginPage.getUsuarioIncorrecto());
		Thread.sleep(1000);
		driver.findElement(loginPage.getInputPassword()).sendKeys("");  	
		Thread.sleep(1000);
	}

	@When("^hace clic en el botón Login por tercera vez$")
	public void haceClicEnElBotónLoginPorTerceraVez() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();	   
		Thread.sleep(1000);;
	}

	@Then("^el usuario debería ver el mensaje de error Epic sadface: Password is required en rojo\\.$")
	public void elUsuarioDeberíaVerElMensajeDeErrorEpicSadfacePasswordIsRequiredEnRojo() throws Throwable {
		
		WebElement mensajeErrorObtenido = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(loginPage.getMensajePasswordNull(), mensajeErrorObtenido.getText());	
		Thread.sleep(1000);
	
	}
	@When("^que el usuario ingresa cuenta bloqueada usuario y clave$")
	public void queElUsuarioIngresaCuentaBloqueadaUsuarioYClave() throws Throwable {
		
		Properties properties = new Properties();
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario_bloqueado"));		
		Thread.sleep(1000);
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    Thread.sleep(1000);
	   
	}

	@When("^clic en el boton Login$")
	public void clicEnElBotonLogin() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();    
		Thread.sleep(1000);
	}

	@Then("^debera haber dentro de la pagina login un mensaje \"([^\"]*)\" en rojo$")
	public void deberaHaberDentroDeLaPaginaLoginUnMensajeEnRojo(String mensajeEsperado) throws Throwable {
		
		WebElement usuarioBloqueado = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(mensajeEsperado , usuarioBloqueado.getText());
		Thread.sleep(1000);
	}
	



}
