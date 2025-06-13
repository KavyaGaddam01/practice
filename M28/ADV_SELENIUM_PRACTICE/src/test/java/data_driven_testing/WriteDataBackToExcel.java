package data_driven_testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Create java representation object of physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Documents\\NinzaCRM_M28.xlsx");

		// Open excel in read mode
		Workbook wb = WorkbookFactory.create(fis);

		// Get control of the sheet
		Sheet sh = wb.getSheet("Campaign");

		// Get control of the row
		Row r = sh.getRow(1);

		// Create cell
		Cell c = r.createCell(4);

		// Set the cell type and value
		c.setCellType(CellType.STRING);
		c.setCellValue("fail");

		// Open excel in Write mode
		FileOutputStream fos = new FileOutputStream("C:\\Users\\QSP\\Documents\\NinzaCRM_M28.xlsx");

		// Save the data in excel
		wb.write(fos);

		// Close the workbook
		wb.close();

	}

}
