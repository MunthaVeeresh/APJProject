package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel8 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// 1. Connect to an existing excel file
		File f1 = new File("\\\\Users\\\\Muntha Veeresh\\\\Documents\\\\manual & Automation_Resume\\\\Book1.xlsx");
		FileInputStream fi = new FileInputStream(f1); // READ mode
		Workbook ewb = WorkbookFactory.create(fi);
		Sheet esh = ewb.getSheet("Sheet1");
		int nur = esh.getPhysicalNumberOfRows();
		// 2. Create a new Excel file for results
		XSSFWorkbook nwb = new XSSFWorkbook();
		Sheet nsh = nwb.createSheet("Result");
		nsh.createRow(0).createCell(0).setCellValue("Add");
		nsh.getRow(0).createCell(1).setCellValue("Subtract");
		nsh.getRow(0).createCell(2).setCellValue("Multiply");
		nsh.getRow(0).createCell(3).setCellValue("Divide");
		// 3. DDT from from 2nd row(index=1) to last row(index=nur-1) in file1
		for (int i = 1; i < nur; i++) // 1st row(index=0) has names of columns
		{
			DataFormatter df = new DataFormatter();
			String x = df.formatCellValue(esh.getRow(i).getCell(0));
			int a = Integer.parseInt(x);
			String y = df.formatCellValue(esh.getRow(i).getCell(1));
			int b = Integer.parseInt(y);
			nsh.createRow(i).createCell(0).setCellValue(a + b);
			nsh.getRow(i).createCell(1).setCellValue(a - b);
			nsh.getRow(i).createCell(2).setCellValue(a * b);
			nsh.getRow(i).createCell(3).setCellValue((float) a / b);
		}
		// 4. save that new file with results
		File f2 = new File("src\\test\\resources\\datafiles\\numresult.xlsx");
		FileOutputStream fo = new FileOutputStream(f2); // WRITE mode
		nwb.write(fo);
		fo.close();
		fi.close();
		ewb.close();
		nwb.close();
	}

}
