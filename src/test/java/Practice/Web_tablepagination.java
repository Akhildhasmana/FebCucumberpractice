package Practice;
//make changes for commit and push test
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Web_tablepagination {
WebDriver driver;
@Test
public void test_table() {
WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");


List <WebElement> Row_list = driver.findElements(By.xpath("//table[@class='display dataTable']/tbody/tr"));
int Row_Count=Row_list.size();
List <WebElement> col_list = driver.findElements(By.xpath("//table[@class='display dataTable']/tbody/tr/td"));
String Beforexpath4;
String get_value=null;
         
for(int i=1;i<=Row_Count;i++) {
List <WebElement> col_list1 = driver.findElements(By.xpath("//table[@class='display dataTable']/tbody/tr[" +i+"]/td"));
int col=col_list1.size();


for(int j=1 ;j<=col;j++) {
               
Beforexpath4="//table[@id='example']/tbody/tr["+i+"]/td["+j+"]";
List<WebElement> element2=driver.findElements(By.xpath(Beforexpath4));
for(WebElement ele:element2)
get_value=ele.getText();
System.out.println(get_value);


System.out.println("==================================================================");
return;


}
}


}
}