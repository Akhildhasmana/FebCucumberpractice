package Practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import stepdefinitions.BaseTest;

public class SVGelement extends BaseTest {
	 WebDriver driver;

	    public SVGelement() {
	        this.driver = super.driver;
	    }


	@Test
	public void mapelement() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
		WebDriverWait wt= new WebDriverWait(driver, Duration.ofMillis(200));
		
		//WebElement tap=driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @id='florida']"));
		WebElement tap2=driver.findElement(By.xpath("//*[name()='path' and @id='10']"));
		wt.until(ExpectedConditions.visibilityOf(tap2));
		Actions act=new Actions(driver);
		act.moveToElement(tap2).click().perform();
		
		
		
	}

}
