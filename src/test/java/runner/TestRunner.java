package Runner;



import org.junit.runner.RunWith;
import java.io.IOException;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = {"F:\\FEB2\\src\\test\\resources\\features\\"}
        ,glue = {"stepdefinitions"}
        ,plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
        ,dryRun=false
        ,monochrome=true
        ,publish=true
        ,tags="@Registration"
        )


public class TestRunner  extends AbstractTestNGCucumberTests{
      


}
