package io.character;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileWriterTest {
	
	public static void main(String[] args) throws Exception {
		
		// 키보드 입력
		InputStreamReader keyIn = new InputStreamReader(System.in);
		
		// 파일 출력
		FileWriter fileOut = new FileWriter("D:\\out.txt");
		
		int c = 0;	// 한 문자를 임시 저장할 변수
		
		while ((c = keyIn.read()) != -1) {	// 키보드로부터 데이터 읽어서 c에 저장
			fileOut.write(c);	// c를 파일에 기록
		}
		
		keyIn.close();
		fileOut.close();
		
	}
	
}
