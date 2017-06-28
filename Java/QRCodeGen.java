package advanced;

//Using Zebra Crossing "ZXing"
//Download the jar from http://www.java2s.com/Code/JarDownload/zxing/zxing.jar.zip



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGen {
	/**
	 * @param args
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void main(String[] args) throws WriterException, IOException {
		String qrCodeText = "http://www.journaldev.com";
		String filePath = "";
		int size = 125;
		String fileType = "png";
		
		File qrFile = new File(filePath+String.valueOf((long)(Math.random()*10000)+".png"));
		//file will be created in the current directory.
		
		QRCodeGen qr = new QRCodeGen();
		
		qr.createQRImage(qrFile, qrCodeText, size, fileType);
		System.out.println("DONE");
	}

	
	private void createQRImage(File qrFile, String qrCodeText, int size,	String fileType) throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		ByteMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);
//		byteMatrix.g

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j) == 0) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

}

/*
// To copy the generated qr code to a pdf file.
package advanced;

//Using Zebra Crossing "ZXing"
//Download the jar from http://www.java2s.com/Code/JarDownload/zxing/zxing.jar.zip



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import java.io.File;

import org.apache.commons.io.FileUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGen {
	
	public static void main(String[] args) throws WriterException, IOException {
		String qrCodeText =  "Ashwin Aishvarya Vardhan";
		String filePath = "";
		int size = 125;
		String fileType = "png";
		String fileName = String.valueOf((long)(Math.random()*10000));
		File qrFile = new File(filePath+fileName+".png");
		//file will be created in the current directory.
		
		QRCodeGen qr = new QRCodeGen();
		
		qr.createQRImage(qrFile, qrCodeText, size, fileType);
		FileUtils.copyFile(qrFile, new File(filePath+fileName+".pdf"));
		System.out.println("DONE");
	}

	
	private void createQRImage(File qrFile, String qrCodeText, int size, String fileType) throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		ByteMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);
//		byteMatrix.g

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j) == 0) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

}
*/
