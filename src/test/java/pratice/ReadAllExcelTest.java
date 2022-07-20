/*Write a program to find specific data from 1st column , if data is available then read & display  next cell data */
package pratice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadAllExcelTest
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet2");
		int count = s.getLastRowNum();
		String data1="apple";
		for(int i=1;i<=count;i++)
		{
			Row row = s.getRow(i);
			String f1 = row.getCell(0).getStringCellValue();
			if(f1.equals(data1))
			{
				String f2 = row.getCell(1).getStringCellValue();
				System.out.println(f2);
			}
		}
		
	}

}
