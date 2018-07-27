import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsforHDFCDematAccount {
  @Test
  public void f() throws InterruptedException {
	  
	 System.setProperty("webdriver.chrome.driver", "C://Users//aravind.g.kumar//Desktop//chromedriver.exe");
     WebDriver driver =new ChromeDriver();
     driver.get("https://www.hdfcbank.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     //driver.findElement(By.xpath("//a[@href=personal/products/demat/demat-account")).click();
     Actions act1=new Actions(driver);
     act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();
     act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/demat']"))).perform();
     Thread.sleep(2000);
     act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/demat/demat-account']"))).click().build().perform();
     Assert.assertTrue(driver.getTitle().startsWith("Demat"));
  }
}
