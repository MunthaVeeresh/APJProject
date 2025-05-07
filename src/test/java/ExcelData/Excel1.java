package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Excel1 {
	public static void main(String[] args) throws IOException {
		//convert original file into zip file
				File fileToZip=new File("C:\\Users\\Muntha Veeresh\\Documents\\manual & Automation_Resume\\Veeresh_Resume.pdf");
		        FileInputStream fis=new FileInputStream(fileToZip);
				File zipfile=new File("C:\\Users\\Muntha Veeresh\\Documents\\manual & Automation_Resume\\Veeresh_Resume.pdf");
				FileOutputStream fos=new FileOutputStream(zipfile);
		        ZipOutputStream zipOut=new ZipOutputStream(fos);
		        ZipEntry zipEntry=new ZipEntry(fileToZip.getName());
		        zipOut.putNextEntry(zipEntry);
		        byte[] bytes=new byte[1024];
		        int length;
		        while((length=fis.read(bytes))>=0) 
		        {
		            zipOut.write(bytes, 0, length);
		        }
		        zipOut.close();
		        fis.close();
		        fos.close();
	}

}
