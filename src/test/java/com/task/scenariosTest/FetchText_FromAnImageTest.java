package com.task.scenariosTest;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class FetchText_FromAnImageTest {

	@Test
	public void fetchText() 
	{
		Tesseract tesseract = new Tesseract();
		//ITesseract image=new Tesseract();
		try {
			
			
			//the path of our tess-data folder
			tesseract.setDatapath("E:\\Softwares\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
			
			//inside the extracted file
			String text=tesseract.doOCR(new File("C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\covid.jpg"));
			String text2=tesseract.doOCR(new File("C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\sonaliNew1.png"));
			String text3=tesseract.doOCR(new File("C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\UntitledSonali.png"));

			
			System.out.println(text);
			System.out.println(text2);
			System.out.println(text3);

			
		} catch (TesseractException e) {
			System.out.println("Exception "+e.getMessage());
		}
	}
}
