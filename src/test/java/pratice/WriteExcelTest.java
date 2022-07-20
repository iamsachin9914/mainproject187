package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelTest
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/commondata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		//inserting the value to already created cell
		wb.getSheet("Sheet1").getRow(3).getCell(2).setCellValue("kannan");
		
		//creating new cell and adding the new value
		wb.getSheet("Sheet1").getRow(3).createCell(6).setCellValue("abc");
		FileOutputStream fos=new FileOutputStream("./TestData/commondata.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}

}
