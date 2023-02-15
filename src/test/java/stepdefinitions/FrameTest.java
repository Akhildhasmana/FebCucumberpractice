package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameTest extends BaseTest {
    WebDriver driver;

    public FrameTest() {
        this.driver = super.driver;
    }

    @Then("^I enter (.*) in the frame1 input box$")
    public void iEnterTestTextInTheFrame1InputBox(String text) {
        driver.switchTo().frame("frame1");
        driver.findElement(By.tagName("input")).sendKeys(text);
    }

    @Then("I print main window title")
    public void iPrintMainWindowTitle() {
        driver.switchTo().defaultContent();
        String title = driver.findElement(By.xpath("//span[normalize-space()='Not a Friendly Topic']")).getText();
        System.out.println("Title text : "+title);
    }
}
