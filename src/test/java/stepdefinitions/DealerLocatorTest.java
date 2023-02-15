package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DealerLocatorTest extends BaseTest {
    WebDriver driver;

    public DealerLocatorTest() {
        this.driver = super.driver;
    }

    @Then("^(Dealer locator page is displayed|I land to Dealer locator page)$")
    public void dealerLocatorPageDisplayed(String phrase) {
      WebElement tvsDealerLocatorBreadCrumb = driver.findElement(By.xpath("//li[normalize-space()='TVS Dealer Locator']"));
        Assert.assertTrue(tvsDealerLocatorBreadCrumb.isDisplayed());
    }

    @When("I click on browser back button")
    public void iClickOnBrowserBackButton() {
        driver.navigate().back();
    }
}
