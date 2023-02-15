package stepdefinitions;


import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopAccessoriesTest extends BaseTest {
	WebDriver driver;

	public ShopAccessoriesTest() {
		this.driver = super.driver;
	}

	@SuppressWarnings("deprecation")
	@When("I select on tvs apache option from drop down")
	public void iSelectOnTvsApacheOptionFromDropDown() throws InterruptedException {
//		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select-accessories']//child::p[text()='Select your Vehicle']")));
//		WebElement dropDown=driver.findElement(By.xpath("//div[@class='select-accessories']//child::p[text()='Select your Vehicle']"));
//		String head=dropDown.getText();
//		System.out.println("Drop-down Header is  --> " +head);
//        Assert.assertEquals("Select your Vehicle", head);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
		driver.findElement(By.xpath("//a[@id='test']")).click();
		WebElement vehicleDropDown = driver.findElement(By.id("vehicleDrp"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(vehicleDropDown));
		Select selectYourVehicleDropDown = new Select(vehicleDropDown);
		selectYourVehicleDropDown.selectByVisibleText("tvs apache");
	}


	@When("I selects Accessories option from Shop tab")
	public void iSelectsAccessoriesOptionFromShopTab() {
		WebElement shopTab=driver.findElement(By.xpath("//a[text()='Shop']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(shopTab).perform();
		WebElement accessoriesOption=driver.findElement(By.xpath("//ul[@class='dropdown-menu']//child::a[text()='Accessories']"));
		Actions act=new Actions(driver);
		act.moveToElement(accessoriesOption).perform();
		accessoriesOption.click();
	}

	@When("I hover on Shop tab")
	public void iHoverOnShopTab() {
		WebElement shopTab=driver.findElement(By.xpath("//a[text()='Shop']"));
		Actions act=new Actions(driver);
		act.moveToElement(shopTab).perform();
	}

	@When("I click on Accessories")
	public void iClickOnAccessories() throws InterruptedException {
		WebElement accessoriesOption=driver.findElement(By.xpath("//ul[@class='dropdown-menu']//child::a[text()='Accessories']"));
		Actions act=new Actions(driver);
		act.moveToElement(accessoriesOption).perform();
		accessoriesOption.click();
		

	}


}


