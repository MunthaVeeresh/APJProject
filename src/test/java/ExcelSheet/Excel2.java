package ExcelSheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2 {
	public static void main(String[] args) throws IOException {
		// Create new excel file(.xlsx) with a sheet and headings
		File ef = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Saved Pictures\\Book1.xlsx");
		XSSFWorkbook wwb = new XSSFWorkbook();
		Sheet sh = (Sheet) wwb.createSheet("Mysheet");
		((XSSFSheet) sh).createRow(0).createCell(0).setCellValue("Name");
		((XSSFSheet) sh).getRow(0).createCell(1).setCellValue("File/Folder");
		((XSSFSheet) sh).getRow(0).createCell(2).setCellValue("Size");
		((XSSFSheet) sh).getRow(0).createCell(3).setCellValue("Last modified");
		((XSSFSheet) sh).getRow(0).createCell(4).setCellValue("Hidden");
		// Copy all files names and other details into excel sheet from 2nd row(index=1)
		File target = new File("E:\\batch262");
		File[] l = target.listFiles();
		int rowindex = 1; // 1st row(index=0) has names for columns
		for (File f : l) // take each file or folder from list/collection
		{
			// 1. get name of file/folder and then store in 1st column
			((XSSFSheet) sh).createRow(rowindex).createCell(0).setCellValue(f.getName());
			((XSSFSheet) sh).autoSizeColumn(0);
			// 2. get type and size and then store them into 2nd column and 3rd column
			if (f.isFile()) {
				((XSSFSheet) sh).getRow(rowindex).createCell(1).setCellValue("file");
				((XSSFSheet) sh).autoSizeColumn(1);
				double b = f.length();
				double k = (b / 1024);
				((XSSFSheet) sh).getRow(rowindex).createCell(2).setCellValue(k + "KB");
				((XSSFSheet) sh).autoSizeColumn(2);
			} else {
				((XSSFSheet) sh).getRow(rowindex).createCell(1).setCellValue("folder");
				long b = FileUtils.sizeOfDirectory(f);
				double k = (b / 1024);
				((XSSFSheet) sh).getRow(rowindex).createCell(2).setCellValue(k + "KB");
				((XSSFSheet) sh).autoSizeColumn(2);
			}
			// 3. get last modified date and time of file/folder and then store in 4th
			// column
			SimpleDateFormat sdf = new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss");
			((XSSFSheet) sh).getRow(rowindex).createCell(3).setCellValue(sdf.format(f.lastModified()));
			((XSSFSheet) sh).autoSizeColumn(3);
			// 4. get the file/folder is hidden or not and store in 5th column
			if (f.isHidden()) {
				((XSSFSheet) sh).getRow(rowindex).createCell(4).setCellValue("Yes");
			} else {
				((XSSFSheet) sh).getRow(rowindex).createCell(4).setCellValue("No");
			}
			rowindex++; // Mandatory to goto next row in excel sheet
		}
		// Take write permission on that file
		FileOutputStream fo = new FileOutputStream(ef);
		wwb.write(fo); // save file
		wwb.close();
		fo.close();
	}

}
