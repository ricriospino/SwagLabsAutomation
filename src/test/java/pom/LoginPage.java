package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageElement {
	
	private String tituloEsperado ="Swag Labs";
	
	private By titulo = By.cssSelector("div.login_logo");
	private By inputUserName = By.id("user-name");	
	private By inputPassword  = By.id("password");	
	private By botonLogin = By.id("login-button");	
	private By messageError = By.cssSelector("h3[data-test='error']");	
	
	private String mensajeError = "Epic sadface: Username and password do not match any user in this service";
	private String mensajeUserNull ="Epic sadface: Username is required";	
	private String mensajePasswordNull ="Epic sadface: Password is required";
	
	private String usuarioIncorrecto ="standard_use";
	private String passwordIncorrecto ="12324dd";
	
	

	public String getUsuarioIncorrecto() {
		return usuarioIncorrecto;
	}

	public String getPasswordIncorrecto() {
		return passwordIncorrecto;
	}

	public By getMessageError() {
		return messageError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public String getMensajeUserNull() {
		return mensajeUserNull;
	}

	public String getMensajePasswordNull() {
		return mensajePasswordNull;
	}

	public String getTituloEsperado() {
		return tituloEsperado;
	}

	public By getTitulo() {
		return titulo;
	}

	public By getInputUserName() {
		return inputUserName;
	}

	public By getInputPassword() {
		return inputPassword;
	}

	public By getBotonLogin() {
		return botonLogin;
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

}
