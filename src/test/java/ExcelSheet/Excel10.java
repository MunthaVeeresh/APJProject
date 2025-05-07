package ExcelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Excel10 {
	public static void main(String[] args) throws IOException {
		// Open an existing PDF file in READ mode
		File f = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Downloaded_Images\\job-savelsberg-ZK13SyogpQw-unsplash.jpg");
		FileInputStream fi = new FileInputStream(f);
		PdfReader pr = new PdfReader(fi);
		// Get text of 11th page
		String x = PdfTextExtractor.getTextFromPage(pr, 11);
		System.out.println(x);
		pr.close();
	}

}
