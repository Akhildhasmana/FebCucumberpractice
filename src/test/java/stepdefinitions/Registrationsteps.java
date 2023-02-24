package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Registrationsteps extends BaseTest {

	WebDriver driver;
   
	public Registrationsteps() {
		this.driver=super.driver;
	}

	@When("User Enters Following user details with coloums")
	public void user_enters_following_user_details_with_coloums(DataTable dataTable) {

		List<Map<String , String>> userMap =dataTable.asMaps(String.class,String.class);
		driver.findElement(By.xpath("//input[@id='nf-field-17']")).sendKeys(userMap.get(0).get("Firstname"));
		driver.findElement(By.xpath("//input[@id='nf-field-18']")).sendKeys(userMap.get(0).get("Lastname"));
		driver.findElement(By.xpath("//input[@id='nf-field-19']")).sendKeys(userMap.get(0).get("Email"));
		driver.findElement(By.xpath("//input[@id='nf-field-20']")).sendKeys(userMap.get(0).get("Phone"));

	}

	@When("Select the Course you would like to book")
	public void select_the_course_you_would_like_to_book() {

		WebElement Dropdown =driver.findElement(By.xpath("//select[@id='nf-field-22']"));
		Select dropdownlist=new Select(Dropdown);
		dropdownlist.selectByValue("mobile-automation");
	}

	@When("Select the Month of the Batch you would like to join")
	public void select_the_month_of_the_batch_you_would_like_to_join() {
		WebElement Dropdown =driver.findElement(By.xpath("//select[@id='nf-field-24']"));
		Select dropdownlist=new Select(Dropdown);
		dropdownlist.selectByValue("april");
	}

	@When("How do you know about us ?")
	public void how_do_you_know_about_us() {
		WebElement option1 = driver.findElement(By.id("nf-label-class-field-23-3"));							

		// This will Toggle the Check box 		
		option1.click();			
	}

	@Then("User clicks on the Register button")
	public void user_clicks_on_the_register_button() {
		driver.findElement(By.id("nf-field-15")).click();
	}	
	

	}


