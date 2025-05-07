package ExcelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class Excelfile1 {
	public static void main(String[] args) throws DocumentException, IOException {
		// Open an existing PDF file
		File f = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Downloaded_Images\\job-savelsberg-ZK13SyogpQw-unsplash.jpg");
		// Read mode
		FileInputStream fi = new FileInputStream(f);
		PdfReader pr = new PdfReader(fi);
		// Write mode
		FileOutputStream fo = new FileOutputStream(f);
		PdfStamper ps = new PdfStamper(pr, fo);
		// Get
		PdfContentByte content = ps.getUnderContent(1); // pageNumber=1
		// Add text to existing content
		Font ft = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Phrase c = new Phrase("please wakeup, otherwise", ft);
		ColumnText ct = new ColumnText(content);
		ct.setSimpleColumn(100, 800, 800, 100);
		ct.setText(c);
		ct.go();
		// Add image to existing content
		Image im = Image.getInstance("C:\\Users\\Public\\Pictures\\Sample Pictures\\desert.jpg");
		im.scaleAbsolute(300, 100);
		im.setAbsolutePosition(100f, 600f);
		content.addImage(im);
		ps.close();
	}

}
