package TestSuit;

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
		Thread.sleep(1000);
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    Thread.sleep(1000);
		driver.findElement(loginPage.getBotonLogin()).submit();  
		Thread.sleep(1000);
	}

	@Given("^ha seleccionado anteriormente un producto desde la página de inicio$")
	public void haSeleccionadoAnteriormenteUnProductoDesdeLaPáginaDeInicio() throws Throwable {
		
		driver.findElement(homePage.getAgregarProductoCaro()).click();
		Thread.sleep(1000);
		driver.findElement(homePage.getAgregarProductoBarato()).click();
		Thread.sleep(1000);
		driver.findElement(homePage.getMenuBurger()).click();
		WebElement botonLogout = driver.findElement(menuPage.getBotonLogout());
		Thread.sleep(1000);
		botonLogout.click();
		Thread.sleep(1000);   
	}

	@When("^el usuario inicia sesión por segunda vez$")
	public void elUsuarioIniciaSesiónPorSegundaVez() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));	
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));	
		Thread.sleep(1000);
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    Thread.sleep(1000);
		driver.findElement(loginPage.getBotonLogin()).submit();  
		Thread.sleep(1000);   
	}

	@Then("^todos sus datos de cuenta deben estar cargados correctamente$")
	public void todosSusDatosDeCuentaDebenEstarCargadosCorrectamente() throws Throwable {
		
		WebElement carritolleno = driver.findElement(homePage.getCarritoLLeno());
		Assert.assertEquals(homePage.getCarritoitemEsperado(), carritolleno.getText());	 
	}
}
