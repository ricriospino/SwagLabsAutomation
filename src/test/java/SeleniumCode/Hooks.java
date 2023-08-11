package SeleniumCode;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import runner.TestRunner;
import utils.Logs;


public class Hooks {
	
	private static final Logger LOGGER = Logs.getLogger(TestRunner.class);
	
	private static WebDriver driver;
	private DriverManager driverManager;
	
	// variable statica
	private static int numberofCase = 0;
	
	@Before("@browser")
	public void Abrir() throws  IOException {
		
		Properties properties = new Properties();
		properties.load(new FileReader("C:\\Users\\PC\\git\\SwagLabsAutomation\\src\\test\\java\\resurces\\config.properties"));
		
		numberofCase++;
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME); 
		driver = driverManager.getDriver();
		
		LOGGER.log(Level.INFO, "Se esta ejecutando el escenario nro: " + numberofCase);
		driver.get(properties.getProperty("url_base")); // es lo mismo que poner https://www.imalittletester.com/
		driver.manage().window().maximize();
	}
	
	
	@After("@browser")
	public void Cerrar(Scenario scenario) {
		// tomando ss si falla
	if (scenario.isFailed()) {
		LOGGER.log(Level.WARNING, " Fallo , toma un Screenshot ");
		byte[] screenshot = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");	
		}
		LOGGER.log(Level.INFO, "El escenario nro : " + numberofCase + " se ejecuto correctamente y se cerro.");
		driverManager.quitDriver();		
	}

	public static WebDriver getDriver() {	
		return driver;
	}
}
