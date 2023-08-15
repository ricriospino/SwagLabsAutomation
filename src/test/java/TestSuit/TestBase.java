package TestSuit;

import org.openqa.selenium.WebDriver;

import pom.CartPage;
import pom.CheckoutComplete;
import pom.CheckoutOverviewPage;
import pom.CheckoutYourInformationPage;
import pom.HomePage;
import pom.LoginPage;
import pom.MenuPage;

public class TestBase {
	
	protected WebDriver driver = Hooks.getDriver();
	
	protected LoginPage loginPage = new LoginPage(driver);
	protected HomePage homePage = new HomePage(driver);
	protected CartPage cartPage = new CartPage(driver);
	protected CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
	protected CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
	protected CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
	protected MenuPage menuPage = new MenuPage(driver);
	

}
