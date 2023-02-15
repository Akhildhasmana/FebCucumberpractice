package stepdefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;
public class Hooks {
    WebDriver driver;
   
    @Before
    public void init() throws IOException {
       DriverManager.initDriver("Chrome");

   
    }

    @After
    
	public void tearDown() {
    
    	driver = DriverManager.getDriver("Chrome");
	

	driver.quit();

}
}
//        System.out.println("Inside after");
        
       
   
