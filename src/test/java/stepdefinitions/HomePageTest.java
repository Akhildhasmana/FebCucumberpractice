package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HomePageTest extends BaseTest {
    WebDriver driver;
    Logger log = LogManager.getLogger(HomePageTest.class);
    
    
    

    public HomePageTest() {
        this.driver = super.driver;
        

    }

    @Given("^(I am at home page|I land to home page)$")
    public void iAmAtLoginPage(String phrase) throws IOException, IOException {
//        driver.get("https://www.tvsmotor.com/");
    	
        
    	HttpURLConnection cont=(HttpURLConnection)new URL("https://www.tvsmotor.com/").openConnection();
       	cont.setRequestMethod("HEAD");
       	cont.connect();
       	int res = cont.getResponseCode();
       	driver.navigate().to("https://www.tvsmotor.com/");
       	System.out.println("Response code is "+res);
    }

    @When("^I click on book a vehicle icon from top bar$")
    public void i_click_on_book_a_vehicle_icon_from_top_bar() {
        WebElement bookVehicle = driver.findElement(By.id("NavBookaVehicle"));
        bookVehicle.click();
        
    }

    @When("^I click on dealer locator icon from top bar$")
    public void iClickOnDealerLocatorIconFromTopBar() {
        driver.findElement(By.xpath("//a[@class='testDriveDesk dealerLoc hidden-xs']")).click();
        log.debug("This is debug message ");
    }
     
    @ Then("^Book online page is displayed$")
    public void book_online_page_is_displayed() {
        WebElement bookOnlinePageTitle = driver.findElement(By.xpath("//h1[normalize-space()='Book Online']"));
        Assert.assertEquals("Book Online", bookOnlinePageTitle.getText());
        log.fatal("fatal msg");
        driver.quit();
    } 
    
    
    @Then("^I see an alert window$")
    public void iSeeAnAlertWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
      try {
    	  driver.switchTo().alert();
    	  String AlertTitle=driver.switchTo().alert().getText();
    	  System.out.println("The Alert message is "+AlertTitle);
    	  
      }
      catch(NoAlertPresentException exeception) {
    	  exeception.printStackTrace();
    	 
    	  
      }
    }

    @When("^I click on browser forward button$")
    public void iClickOnBrowserForwardButton() {
        driver.navigate().forward();
    }
}
