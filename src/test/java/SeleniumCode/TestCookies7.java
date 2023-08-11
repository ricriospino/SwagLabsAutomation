package SeleniumCode;

import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCookies7 extends TestBase{
	
	Properties properties = new Properties();
	
	@Given("^que el usuario está logeado$")
	public void queElUsuarioEstáLogeado() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
		driver.findElement(loginPage.getBotonLogin()).submit();  
		Thread.sleep(2000);
	}

	@Given("^ha seleccionado anteriormente un producto desde la página de inicio$")
	public void haSeleccionadoAnteriormenteUnProductoDesdeLaPáginaDeInicio() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
		driver.findElement(homePage.getAgregarProductoBarato()).click();
		Thread.sleep(2000);
		driver.findElement(homePage.getMenuBurger()).click();
		WebElement botonLogout = driver.findElement(menuPage.getBotonLogout());
		Thread.sleep(2000);
		botonLogout.click();
	   
	}

	@When("^el usuario inicia sesión por segunda vez$")
	public void elUsuarioIniciaSesiónPorSegundaVez() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));	
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
		driver.findElement(loginPage.getBotonLogin()).submit();  
		Thread.sleep(2000);
	   
	}

	@Then("^todos sus datos de cuenta deben estar cargados correctamente$")
	public void todosSusDatosDeCuentaDebenEstarCargadosCorrectamente() throws Throwable {
		
		WebElement carritolleno = driver.findElement(homePage.getCarritoLLeno());
		Assert.assertEquals(homePage.getCarritoitemEsperado(), carritolleno.getText());
	 
	}


}
