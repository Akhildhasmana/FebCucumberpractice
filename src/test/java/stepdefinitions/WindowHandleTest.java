package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowHandleTest extends BaseTest {
    WebDriver driver;
    String parentWindow;
    WebDriverWait wait;

    public WindowHandleTest() {
        this.driver = super.driver;
    }

    @When("I click on Open New Window button")
    public void iClickOnOpenNewWindowButton() {
        parentWindow = driver.getWindowHandle();
        System.out.println("originalWindow : " + parentWindow);
        driver.findElement(By.id("windowButton")).click();
    }

    @When("I switched to new Window")
    public void iSwitchedToNewWindow() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //Wait for the new window or tab
        wait.until(numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles" + windowHandles);
        //Loop through until we find a new window handle
        for (String windowHandle : windowHandles) {
            if (!parentWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println("Current Window : " +driver.getWindowHandle());
    }

    @Then("^(.*) text is visible in new window$")
    public void basicControlsTextIsVisibleInNewWindow(String title) {
        driver.manage().window().maximize();
        WebElement titleElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        wait.until(ExpectedConditions.visibilityOf(titleElement));
        Assert.assertEquals("This is a sample page",titleElement.getText());
    }
}
