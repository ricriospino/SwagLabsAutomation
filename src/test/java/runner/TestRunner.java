package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import static cucumber.api.SnippetType.CAMELCASE;
import cucumber.api.junit.Cucumber;
import utils.Logs;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Cucumber.class)

@CucumberOptions(
		features= "src/test/java/features",
		glue= {"TestSuit"},// es la carpeta  donde esta hooks
		plugin = {"json:test/report/cucumber_report.json"},
		snippets = CAMELCASE,
		tags = {"@browser"}
		
	// ~	
		)
public class TestRunner {
	
	private static final Logger LOGGER = Logs.getLogger(TestRunner.class);
	
	// generar reporte al finalizar
	@AfterClass
	public static void finish() {
		try {
			LOGGER.log(Level.INFO, "Generar reporte");
			String[]cmd = {"cmd.exe", "/c", "npm run report"};
			Runtime.getRuntime().exec(cmd);
			LOGGER.log(Level.INFO, "Reporte generado satisfactoriamente");
		
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "No se pudo generar el reporte");
			e.printStackTrace();
			
		}
	}
}
