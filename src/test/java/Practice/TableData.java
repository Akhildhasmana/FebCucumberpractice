package Practice;
import managers.DriverManager;
import stepdefinitions.*;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import stepdefinitions.BaseTest;

public class TableData extends BaseTest {

	WebDriver driver;
	
	public TableData() {
		
		this.driver=super.driver;
	}

	@Test
	public void tableData() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
	List <WebElement> Row_list = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr"));
	int Row_Count=Row_list.size();
	List <WebElement> col_list = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/td"));
	String Beforexpath4;
	String get_value = null;
	         
	for(int i=1;i<=Row_Count;i++) {
	List <WebElement> col_list1 = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr[" +i+"]/td"));
	int col=col_list1.size();


	for(int j=1 ;j<=col;j++) {
	               
	Beforexpath4="//table[@id='contactList']/tbody/tr["+i+"]/td["+j+"]";
	List<WebElement> element2=driver.findElements(By.xpath(Beforexpath4));
	
	for(WebElement value:element2)
	
	get_value= value.getText();
		System.out.println("The values in the table are" +get_value);


	System.out.println("==================================================================");
	return;
	}

	}
	driver.quit();
	}


	
	
	
}
