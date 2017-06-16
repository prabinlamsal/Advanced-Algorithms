package advanced;

//download the itext jar from http://www.java2s.com/Code/JarDownload/itextpdf/itextpdf-5.4.1.jar.zip

import java.io.*;
import java.util.Random;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;

//BarCode 128

public class BarCodeGen {
	
	static Document document;
	static PdfWriter pdfWriter;
	
	public void genBC128() throws DocumentException {
		document.open();
		document.add(new Paragraph("Product"));

		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
//		Random random = new Random();
//		long num = 1000000000 + random.nextLong();
		long num = (long)(Math.random()*10000000000L);
		System.out.println(num);
		code128.setCode(String.valueOf(num));    

		document.add(code128.createImageWithBarcode(pdfWriter.getDirectContent(), null, null));
		document.close();
		System.out.println("Document Generated...!!!!!!");
	}
	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		document = new Document(new Rectangle(PageSize.A4));    
		pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(String.valueOf((int)(Math.random()*10000))+".pdf"));
		//file will be created in the current directory.
		BarCodeGen bcg = new BarCodeGen();
		bcg.genBC128();

	}
}
