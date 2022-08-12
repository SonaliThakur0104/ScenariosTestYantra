package hotstar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	static public Workbook wb;

	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fis);
	}

	public static void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String message) {
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(message);

	}

	public static void setMultipleDataIntoExcel(String sheetName,int rowNum,int cellNum,String message) {
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(message);

	}

	public static void saveDataIntoExcel(String filePath) throws IOException {
		FileOutputStream fos=new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
	}





}
