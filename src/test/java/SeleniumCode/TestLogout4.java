package SeleniumCode;

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
	
	properties.load(new FileReader("D:\\CursoJava\\workspace_seleniumUdemy\\LabMontAutomatizado\\src\\test\\java\\resurces\\config.properties"));
	
	driver.findElement(loginPage.getInputUserName()).sendKeys(properties.getProperty("usuario"));			
    driver.findElement(loginPage.getInputPassword()).sendKeys(properties.getProperty("contrasena"));
	driver.findElement(loginPage.getBotonLogin()).submit();  
	
    
}

@Given("^el usuario se encuentra dentro de su cuenta$")
public void elUsuarioSeEncuentraDentroDeSuCuenta() throws Throwable {
	
	driver.findElement(homePage.getMenuBurger()).click();
	
}

@When("^el usuario hace clic en el botón Logout$")
public void elUsuarioHaceClicEnElBotónLogout() throws Throwable {
	
	
	WebElement botonLogout = driver.findElement(menuPage.getBotonLogout());
	Thread.sleep(2000);
	botonLogout.click();
	
   
}

@Then("^el usuario debería ser redirigido a la página de inicio de sesión$")
public void elUsuarioDeberíaSerRedirigidoALaPáginaDeInicioDeSesión() throws Throwable {
    
	driver.findElement(loginPage.getBotonLogin()).isDisplayed();
}


}
