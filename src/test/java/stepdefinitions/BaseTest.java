package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
     protected WebDriver driver;

    public BaseTest() {
        this.driver = DriverManager.getDriver("Chrome");
    }

}
