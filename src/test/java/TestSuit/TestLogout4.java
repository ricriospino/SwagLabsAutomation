package TestSuit;

import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLogout4 extends TestBase {

	Properties properties = new Properties();
	
	@Given("^el usuario debe estar logueado$")
	public void elUsuarioDebeEstarLogueado() throws Throwable {
		
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));	
		Thread.sleep(1000);
	    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	    Thread.sleep(1000);
		driver.findElement(loginPage.getBotonLogin()).submit();      
	}
	
	@Given("^el usuario se encuentra dentro de su cuenta$")
	public void elUsuarioSeEncuentraDentroDeSuCuenta() throws Throwable {
		
		driver.findElement(homePage.getMenuBurger()).click();
		Thread.sleep(1000);	
	}
	
	@When("^el usuario hace clic en el botón Logout$")
	public void elUsuarioHaceClicEnElBotónLogout() throws Throwable {
		
		WebElement botonLogout = driver.findElement(menuPage.getBotonLogout());
		Thread.sleep(1000);
		botonLogout.click();   
	}
	
	@Then("^el usuario debería ser redirigido a la página de inicio de sesión$")
	public void elUsuarioDeberíaSerRedirigidoALaPáginaDeInicioDeSesión() throws Throwable {
	    
		driver.findElement(loginPage.getBotonLogin()).isDisplayed();
	}
}
