package com.Automation.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelClass {

	
	public static Object[][] getData(String sheetName)
	{
	XSSFWorkbook wbWorkbook=null;
	
	try 
	{
		wbWorkbook = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\hp\\Desktop\\TestData.xlsx")));
	} catch (FileNotFoundException e) 
	{
		
		Reporter.log("LOG:FAIL - File not present "+ e.getMessage(),true);
		
	} catch (IOException e) 
	{
		Reporter.log("LOG:FAIL - Could not load the file "+ e.getMessage(),true);
	}
	
	int rowCount=wbWorkbook.getSheet(sheetName).getPhysicalNumberOfRows();
	
	int cellCount=wbWorkbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	
	Object [][]arr=new Object[rowCount][cellCount];
	
	
	for(int i=0;i<rowCount;i++)
	{
		
		
		for(int j=0;j<cellCount;j++)
		{			
					String valueString="";
					
					CellType type=wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getCellType();
					
					if (type==CellType.STRING) 
					{
						valueString=wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
					}
					else if (type==CellType.NUMERIC) 
					{	
							double doubleValue=wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getNumericCellValue();	
							
							valueString=String.valueOf(doubleValue);	
							
					}else if(type==CellType.BOOLEAN)
					{
						Boolean booleanValue= wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getBooleanCellValue();
						
							valueString=String.valueOf(booleanValue);
						
					}
					else if(type==CellType.BLANK)
					{
						valueString="";
					}
								
				arr[i][j]=valueString;	
					
					
		}
		
	}
	
	return arr;
	
	
	
	
}
}
