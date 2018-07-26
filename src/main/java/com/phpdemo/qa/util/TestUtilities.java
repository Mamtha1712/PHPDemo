package com.phpdemo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.phpdemo.qa.base.TestBase;

public class TestUtilities extends TestBase{
	public static long Page_Load_Timeout = 20;
	public static long implicit_wait = 20;
	public static String sheet_path = "C:\\mamtha\\Selenium Practice\\Test Data resources\\PHPTestData.xlsx";
	public static XSSFWorkbook wrkbk;
	public static XSSFSheet sheet;
	
	

	public static String getTestDataFrmXcel(String sheetName, int rowNum, String columnName) throws IOException, InvalidFormatException{
		int colNum= 0;
		String data=null;
		FileInputStream ip = new FileInputStream(sheet_path);
		try {
		wrkbk = new XSSFWorkbook(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sheet = wrkbk.getSheet(sheetName);
		
		//Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					if (sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(columnName)) {
						colNum = j;
						break;
					}
				}
			data =  sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("data value is " +data);
			return data;
		}
	
	public static int getRowCount(String shtname) throws IOException {
		FileInputStream ip = new FileInputStream(sheet_path);
		wrkbk = new XSSFWorkbook(ip);
		sheet = wrkbk.getSheet(shtname);
		int RowCount = sheet.getLastRowNum();
		//System.out.println(RowCount);
		return RowCount;
	}
	
	public static void selectOptionfromList(WebElement selement, String svalueToChoose) {
		Select oselect = new Select(selement);
		oselect.selectByVisibleText(svalueToChoose);
	}
	
	public static void takeScreenshotAtEndOfTest() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File ("C:\\mamtha\\Selenium Practice\\ScreenShots\\"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
}
