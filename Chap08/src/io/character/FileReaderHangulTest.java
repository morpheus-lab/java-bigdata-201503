package io.character;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReaderHangulTest {
	
	public static void main(String[] args) throws Exception {
		
//		FileInputStream fin = new FileInputStream("D:\\hangul-utf8.txt");
//		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		
		FileInputStream fin = new FileInputStream("D:\\hangul.txt");
//		InputStreamReader reader = new InputStreamReader(fin, "MS949");
		InputStreamReader reader = new InputStreamReader(fin, "EUC-KR");
		
		int c = 0;
		while ((c = reader.read()) != -1) {
			System.out.print((char) c);
		}
		
		reader.close();
	}
	
}
