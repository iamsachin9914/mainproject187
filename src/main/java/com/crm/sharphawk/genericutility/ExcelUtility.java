package com.crm.sharphawk.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * generic class is developed using Apache POI libraries , which used to handle Microsoft Excel sheet
 * @author iamsachin
 *
 */
public class ExcelUtility 
{

	/**
	 * it is used to read the data from  Microsoft Excel sheet based on these below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return data
	 * @throws throwable
	 */

	public String getDataFromExcel(String sheetName , int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis  =new  FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public double getNumericValueFromExcel(String sheetName , int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis  =new  FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		wb.close();
		return data;
	}

	/**it is used to write the data to  Microsoft Excel sheet based on these below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws throwable
	 */
	public void setDataToExcel(String sheetName , int rowNum, int celNum,String data) throws Throwable
	{
		FileInputStream fis  =new  FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./TestData/commondata.xlsx");
		wb.write(fos);
		wb.close();
	}

	/**
	 * used to get the last used row number on specified Sheet
	 * @paramsheetName
	 * @return
	 * @throwsThrowable
	 */
	public int getRowCount(String sheetName) throws Throwable 
	{
		FileInputStream fis  =new FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	public String getDataFromExcelFormatter(String sheetName , int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis  =new  FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		wb.close();
		return data;
	}
	
//	public void setDataToExcelFormatter(String sheetName , int rowNum, int celNum,String data) throws Throwable
//	{
//		FileInputStream fis  =new  FileInputStream("./TestData/commondata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		DataFormatter format = new DataFormatter();
//		String cell=format.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).createCell(celNum));
//		cell.setCellValue(cell);
//		FileOutputStream fos=new FileOutputStream("./TestData/commondata.xlsx");
//		wb.write(fos);
//		wb.close();
//	}

}
 

