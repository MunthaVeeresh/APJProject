package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel5 {
	public static void main(String[] args) throws IOException {
		// Connect to existing file in HDD
		File f = new File("C:\\Users\\Muntha Veeresh\\Documents\\manual & Automation_Resume\\Book1.xlsx");
		// Take READ permission on that file
		FileInputStream fi = new FileInputStream(f);
		// Consider that file as Excel file(workbook) and shift it to RAM
		Workbook wb = WorkbookFactory.create(fi);
		// 1. create a new sheet and set values
		Sheet sh = wb.createSheet("Mysheet");
		sh.createRow(0).createCell(0).setCellValue("Abdul Kalam");
		sh.getRow(0).createCell(1).setCellValue("India");
		sh.createRow(1).createCell(0).setCellValue("Thomas Kutty");
		sh.getRow(1).createCell(1).setCellValue("India");
		sh.createRow(2).createCell(0).setCellValue("virat kohli");
		sh.getRow(2).createCell(1).setCellValue("India");
		sh.autoSizeColumn(0);
		sh.autoSizeColumn(1);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo); // save changes
		// 2. get that data
		int nur = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < nur; i++) {
			DataFormatter df = new DataFormatter();
			String x = df.formatCellValue(sh.getRow(i).getCell(0));
			String y = df.formatCellValue(sh.getRow(i).getCell(1));
			System.out.println(x + " " + y);
		}
		// close permissions
		fo.close();
		fi.close();
		wb.close();
	}

}
