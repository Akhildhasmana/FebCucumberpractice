package Runner;




import stepdefinitions.BaseTest;

import java.io.IOException;

import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//test

@CucumberOptions(

        
        features = {"F:\\FEB2\\src\\test\\resources\\features"}
        ,glue = {"stepdefinitions"}
     
        ,dryRun=false
        ,monochrome=false
        ,publish=true
        ,tags="@ui or @bookonline or @promptalert or  @shop_parts"
        )


public class TestRunner extends AbstractTestNGCucumberTests {
      


}
