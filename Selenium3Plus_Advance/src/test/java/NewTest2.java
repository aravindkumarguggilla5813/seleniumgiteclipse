import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//aravind.g.kumar//Desktop//chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  String url="http://newtours.demoaut.com/";
	  driver.navigate().to(url);
	  driver.manage().window().maximize();
	  driver.findElement(By.name("userName")).sendKeys("mercury");
	  driver.findElement(By.name("password")).sendKeys("mercury");
	  driver.findElement(By.name("login")).click();
	  String title=driver.getTitle();
	  Assert.assertTrue(title.startsWith("Find a"));
  }
}
