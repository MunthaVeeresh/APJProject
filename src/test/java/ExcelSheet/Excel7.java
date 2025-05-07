package ExcelSheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

public class Excel7 {
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		File f = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Capture.PNG");
		FileOutputStream fo = new FileOutputStream(f);
		// Add text into a new pdf file
		Document doc = new Document();
		PdfWriter.getInstance(doc, fo);
		doc.open();
		Font ft = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk c = new Chunk("Hello friends, are you feeling sleepy?", ft);
		doc.add(c);
		doc.close();
	}

}
