package ExcelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// connect to existing file in project folder
		File f = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Saved Pictures\\Book1.xlsx");
		// Take read permission on that file
		FileInputStream fi = new FileInputStream(f);
		// Access as an Excel file, when it is .xls or .xlsx
		Workbook wb = WorkbookFactory.create(fi);
		// Go to sheet1 and take rows count and columns count
		Sheet sh = wb.getSheet("Sheet1");
		int nour = sh.getPhysicalNumberOfRows();
		int nouc = sh.getRow(0).getLastCellNum();
		// Row sum
		for (int i = 0; i < nour; i++) // row wise
		{
			DataFormatter df = new DataFormatter();
			int rowsum = 0;
			for (int j = 0; j < nouc; j++) // column wise in every row
			{
				String temp = df.formatCellValue(sh.getRow(i).getCell(j));
				int x = Integer.parseInt(temp);
				rowsum = rowsum + x;
			}
			sh.getRow(i).createCell(nouc).setCellValue(rowsum);
		}
		// column sum
		for (int i = 0; i < nouc; i++) // column wise
		{
			DataFormatter df = new DataFormatter();
			int colsum = 0;
			for (int j = 0; j < nour; j++) // row wise in each column
			{
				String temp = df.formatCellValue(sh.getRow(j).getCell(i));
				int x = Integer.parseInt(temp);
				colsum = colsum + x;
			}
			if (i == 0) // create row for 1st time only
			{
				sh.createRow(nour).createCell(i).setCellValue(colsum);
			} else {
				sh.getRow(nour).createCell(i).setCellValue(colsum);
			}
		}
		// Take write permission on that file
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
