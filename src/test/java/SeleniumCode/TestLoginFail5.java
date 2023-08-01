package SeleniumCode;

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
		driver.findElement(loginPage.getInputPassword()).sendKeys(loginPage.getPasswordIncorrecto());
		
	}

	@When("^hace clic en el botón Login$")
	public void haceClicEnElBotónLogin() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();
		Thread.sleep(2000);
	}

	@Then("^el usuario debería ver el mensaje de error \"([^\"]*)\" en rojo\\.$")
	public void elUsuarioDeberíaVerElMensajeDeErrorEnRojo(String mensajeErrorEsperado) throws Throwable {
		
		WebElement mensajeErrorObtenido = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(mensajeErrorEsperado, mensajeErrorObtenido.getText());
		Thread.sleep(2000);
	}

	@When("^el usuario ingresa el nombre de usuario null y la contrasena correcta$")
	public void elUsuarioIngresaElNombreDeUsuarioNullYLaContrasenaCorrecta() throws Throwable {
		
		driver.findElement(loginPage.getInputUserName()).sendKeys("");
		driver.findElement(loginPage.getInputPassword()).sendKeys(loginPage.getPasswordIncorrecto());  
		Thread.sleep(2000);
	}

	@When("^hace clic en el botón Login por segunda vez$")
	public void haceClicEnElBotónLoginPorSegundaVez() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();	  
		Thread.sleep(2000);
	}

	@Then("^el usuario debería ver el mensaje de error Epic sadface: Username is required en rojo\\.$")
	public void elUsuarioDeberíaVerElMensajeDeErrorEpicSadfaceUsernameIsRequiredEnRojo() throws Throwable {
		
		WebElement mensajeErrorObtenido = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(loginPage.getMensajeUserNull(), mensajeErrorObtenido.getText());	
		Thread.sleep(2000);
	}

	@When("^el usuario ingresa el nombre de usuario correcto y la contrasena null$")
	public void elUsuarioIngresaElNombreDeUsuarioCorrectoYLaContrasenaNull() throws Throwable {
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(loginPage.getUsuarioIncorrecto());
		driver.findElement(loginPage.getInputPassword()).sendKeys("");  	
		Thread.sleep(2000);
	}

	@When("^hace clic en el botón Login por tercera vez$")
	public void haceClicEnElBotónLoginPorTerceraVez() throws Throwable {
		
		driver.findElement(loginPage.getBotonLogin()).submit();	   
		Thread.sleep(2000);
	}

	@Then("^el usuario debería ver el mensaje de error Epic sadface: Password is required en rojo\\.$")
	public void elUsuarioDeberíaVerElMensajeDeErrorEpicSadfacePasswordIsRequiredEnRojo() throws Throwable {
		
		WebElement mensajeErrorObtenido = driver.findElement(loginPage.getMessageError());
		Assert.assertEquals(loginPage.getMensajePasswordNull(), mensajeErrorObtenido.getText());	
		Thread.sleep(2000);
	
	}
	



}
