package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromptAlertDemoTest extends BaseTest{
WebDriver driver;

    public PromptAlertDemoTest() {
        this.driver = super.driver;
    }

    @Given("^I am at (.*) web app$")
    public void iAmAtHttpsNxtgenaiacademyComAlertandpopupWebApp(String url) {
        driver.get(url);
    }
    @When("I click on Prompt Alert Box")
    public void iClickOnPromptAlertBox() {
        WebElement alertButton = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.name("prompt")));
        System.out.println("IS Clickable? "+alertButton.isEnabled());
        alertButton.click();
    }
    @Then("Prompt alert pops up")
    public void iPromptAlertPopsUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        Alert alert = driver.switchTo().alert();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("I am prompt", alert.getText());
    }
}
