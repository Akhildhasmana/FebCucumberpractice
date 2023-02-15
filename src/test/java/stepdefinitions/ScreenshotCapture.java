package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class ScreenshotCapture extends BaseTest{
	
	WebDriver driver;
	
	public ScreenshotCapture() {
		this.driver=super.driver;
	}
	
	
	
	@Then("Take a screenshot of TVS Logo")
	public void takeAScreenshotOfTVSLogo() throws IOException {
		
	//	Full page Screenshot 
		TakesScreenshot scrShot=(TakesScreenshot) driver;
		WebElement tvsLogo=driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@alt='TVS Motor Official Logo']"));
		//WebElement tvs=driver.findElement(By.xpath("//li[normalize-space()='TVS Dealer Locator']"));
		File SrcFile=tvsLogo.getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\FEB2\\target\\CapturedScreenshot\\TvsLogo.png");
		FileUtils.copyFile(SrcFile, dest);
		
		
		
				
	}

}
