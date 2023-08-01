package browserManager;

import junit.textui.TestRunner;
import utils.Logs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManagerFactory {
	
	private static final Logger LOGGER = Logs.getLogger(TestRunner.class);
	
	public static DriverManager getManager(DriverType type) {
				
		DriverManager driverManager= null;
		
		switch (type) {
		
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case EDGE:
			driverManager = new EdgeDriverManager();
			break;
		default:
				LOGGER.log(Level.WARNING, "Invalid browser selected");			
			break;
		}
		
		return driverManager;
	}

}
