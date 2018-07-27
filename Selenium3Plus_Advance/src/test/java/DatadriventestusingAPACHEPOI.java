import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DatadriventestusingAPACHEPOI {
  @Test
  public void f() throws IOException {
	  
	  File src =new File("testdata.xlsx");
		
		FileInputStream fis =new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
		System.out.println("first row number"+sh.getFirstRowNum());
		System.out.println("last row number "+sh.getLastRowNum());
		//int rowCount1 = sh.getLastRowNum() - sh.getFirstRowNum();
		
		for(int i=1;i<sh.getLastRowNum();i++) {
		System.out.println(sh.getRow(i).getCell(0).getStringCellValue()+"\t\t\t"
		+sh.getRow(i).getCell(1).getStringCellValue()+"\t\t\t"
		+sh.getPhysicalNumberOfRows());
		
		
				
		}
  }}