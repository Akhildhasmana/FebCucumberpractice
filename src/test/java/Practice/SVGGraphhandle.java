package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SVGGraphhandle {

	WebDriver driver;

	@Test
	public void performAction() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		
		String verticalXpath="//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String textXPath="//*[local-name()='svg']//*[name()='g'and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		List<WebElement>barslist=driver.findElements(By.xpath(verticalXpath)); 
		System.out.println("Total bars :"+barslist.size());
		
		Actions act=new Actions(driver); 
		for(WebElement e:barslist) {
			act.moveToElement(e).perform();
		
			
		String text=driver.findElement(By.xpath(textXPath)).getText();
	
				System.out.println(text);
		
		
	
	}
   driver.close();
	
	}
	


}
