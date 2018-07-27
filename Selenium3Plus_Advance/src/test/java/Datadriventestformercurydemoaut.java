import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Datadriventestformercurydemoaut {
  WebDriver driver;
	@Test
  public void testlogin() throws IOException {
  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\aravind.g.kumar\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");

	   driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		readWriteExcel1();

	}

	public String login(String username,String password)
	{
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();

		if(driver.getTitle().startsWith("Find"))
		{
			Assert.assertTrue(true);
			driver.findElement(By.linkText("SIGN-OFF")).click();
			return "VALID USER";
		}
		else
		{
			Assert.assertTrue(driver.getTitle().startsWith("Sign-on"));
			return "INVALID USER";
		}
	}
		
	public void readWriteExcel1() throws IOException
	
	{
		File file=new File("testdata.xlsx");

			InputStream is=new FileInputStream(file);

			XSSFWorkbook xssf=new XSSFWorkbook(is);

			XSSFSheet sheet1=xssf.getSheet("Sheet1");
			//System.out.println("First Row Number"+sheet1.getFirstRowNum());
			//System.out.println("Last Row Number"+sheet1.getLastRowNum());
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				String username=sheet1.getRow(i).getCell(0).getStringCellValue();
				String password=sheet1.getRow(i).getCell(1).getStringCellValue();
				String result=login(username, password);
				sheet1.getRow(i).createCell(2).setCellValue(result);
			}
			OutputStream os=new FileOutputStream(file);
			xssf.write(os);
			xssf.close();
		}		
	}
