package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class XpathTest extends BaseTest{

	WebDriver driver;
	
	public XpathTest() {
		this.driver=super.driver;
	}
	
	

	@Given("User Went to {string} homepage")
	public void user_went_to_homepage(String URL) {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	  
	}

	@When("User Enter Email address")
	public void user_enter_email_address() {
	    WebElement EmailAdd=driver.findElement(By.xpath("//label[text()='Email']//following-sibling::input[1]"));
	    EmailAdd.sendKeys("Akhtest@yopmail.com");
	}

	@When("User Enter Firstname and last name")
	public void user_enter_firstname_and_last_name() {
		WebElement firstName=driver.findElement(By.xpath("//label[text()='First Name ']/following-sibling::input[1]"));
		firstName.sendKeys("Akhil");
		WebElement lastName=driver.findElement(By.xpath("//label[text()='Email']/preceding-sibling::input[1]"));
		lastName.sendKeys("Dhasmana");
	   
	}

	@When("User Enter password")
	public void user_enter_password() {
		WebElement enterPwd=driver.findElement(By.xpath("(//div[@class='container']//child::div//label[text()='Password']//following::input[@type='password'][1])"));
		enterPwd.sendKeys("Akhil@123");
		
	}

	@Then("User validates entered password")
	public void user_validates_entered_password() {
	    WebElement repeatPassword=driver.findElement(By.xpath("//label[text()='First Name ']/following-sibling::input[4]"));
	    repeatPassword.sendKeys("Akhil@123");
	}
	
	@And("User Selects a contact from the table")
	public void user_selects_a_contact_from_the_table() {
	    WebElement selectContact=driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input"));
	    selectContact.click();
	}
	
	
	@Then("User Clicks on the Register button")
	public void user_clicks_on_the_register_button() {
		WebElement registorBtn=driver.findElement(By.xpath("//div[@class='buttons']//button[text()='Register']"));
		registorBtn.click();
	   
	}
	@Then("Get the table data")
	public void get_the_table_data() {
	    
		List <WebElement> Row_list = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr"));
		int Row_Count=Row_list.size();
		List <WebElement> col_list = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/td"));
		String Beforexpath4;
		String get_value;
		         
		for(int i=1;i<=Row_Count;i++) {
		List <WebElement> col_list1 = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr[" +i+"]/td"));
		int col=col_list1.size();


		for(int j=1 ;j<=col;j++) {
		               
		Beforexpath4="//table[@id='contactList']/tbody/tr["+i+"]/td["+j+"]";
		WebElement element2=driver.findElement(By.xpath(Beforexpath4));
		get_value=element2.getText();
		System.out.println(get_value);


		System.out.println("==================================================================");
		return;


		}
		}
	
	
	}
} 
