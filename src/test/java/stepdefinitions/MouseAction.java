package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Duration;

public class MouseAction extends BaseTest{

	WebDriver driver;
    

	public MouseAction() {
		this.driver=super.driver;
	}



	@When("User left clicks on the button")
	public void user_left_clicks_on_the_button() {
		WebElement ele=driver.findElement(By.xpath("//div[@class='large-2 columns']//child::a[1]")); // dynamic element xpath
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}

	@Then("System should display page title")
	public void getPage_Title() {


		System.out.println("\n The page title is --->   "+driver.getTitle());
	}

	@Then("User Drag and drop and element")
	public void userDragAndDropAndElement() throws InterruptedException {
	   driver.manage().window().maximize();
	 
		WebElement src=driver.findElement(By.xpath("//div[@id='column-a']"));
	  WebElement target=driver.findElement(By.xpath("//div[@id='column-b']"));
	   Actions act=new Actions(driver);
	   act.dragAndDrop(src,target).build().perform();
	   act.clickAndHold(src).pause(2).moveToElement(target).pause(2).release().build().perform();
	  
	   Thread.sleep(2000);
	}
	
	
	
	@And("User Drag and drop using javaScripexecutor")
	public void userDragAndDropUsingJavaScripexecutor() throws InterruptedException {
		Thread.sleep(2000);
		WebElement src=driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='column-b']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", src, target);
		Thread.sleep(2000);
	
	}
	@After
	public void teardown(Scenario sc)
	{
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "F:\\FEB2\\target\\CapturedScreenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	
	}

}

