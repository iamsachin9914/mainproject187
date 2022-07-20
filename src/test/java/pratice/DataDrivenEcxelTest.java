package pratice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenEcxelTest 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream("./TestData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	//System.out.println(data);
		int rowcount=wb.getSheet("Sheet1").getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			String name = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			double sno = wb.getSheet("Sheet1").getRow(i).getCell(0).getNumericCellValue();
			System.out.println(sno+"\t"+name);
		}
	}

}
