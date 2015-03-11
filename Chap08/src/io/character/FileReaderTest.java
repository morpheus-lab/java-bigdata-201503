package io.character;

import java.io.FileInputStream;
import java.io.FileReader;

public class FileReaderTest {
	
	public static void main(String[] args) throws Exception {
		
//		FileReader in = new FileReader("C:\\Windows\\system.ini");
		FileReader in = new FileReader("D:\\test.txt");
//		FileInputStream in = new FileInputStream("D:\\test.txt");
		
		int c = 0;
		
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
		
		in.close();
		
	}
	
}
