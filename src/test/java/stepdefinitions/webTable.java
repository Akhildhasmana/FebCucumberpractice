package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class webTable extends BaseTest{

	WebDriver driver;
	
	public webTable() {
		this.driver=super.driver;
		
	}
	
	@Given("Get the value from the given table")
	public void get_the_value_from_the_given_table() {
	    WebElement table_Row=driver.findElement(By.xpath("//table/tbody/tr[2]//td[2]"));
	    String data =table_Row.getText();
	    System.out.println("  The Data in the selected row is "+data);
		
		
	}
	



}
