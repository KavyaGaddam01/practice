package data_driven_testing;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Create java representation object of physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Kavya 1\\Documents\\CRM_TestScriptData_M28.xlsx");

		//Open excel in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//Get control of the sheet 
		Sheet sh = wb.getSheet("Campaign");
		
		//Get control of the row
		Row r = sh.getRow(1);
		
		//Get the control of cell
		Cell c = r.getCell(2);
		
		String campaignName = c.getStringCellValue();
		System.out.println(campaignName);
		
		String targetSize = r.getCell(3).getStringCellValue();
		System.out.println(targetSize);
		
		//Close the workbook
		wb.close();
	}

}
