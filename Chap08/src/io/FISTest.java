package io;

import java.io.FileInputStream;

public class FISTest {
	
	public static void main(String[] args) throws Exception {
		
		// C:\Windows\system.ini 파일 읽어서 출력
//		FileInputStream fin = new FileInputStream("D:\\test.txt");
		FileInputStream fin = new FileInputStream("C:\\Windows\\system.ini");
		
		while (true) {
			// 데이터를 읽고
			int data = fin.read();	// 1 byte를 읽어서 int 타입으로 리턴
									// 더 이상 읽을 것이 없으면 -1을 리턴
			if (data == -1) {
				break;
			}
			// 화면에 출력
			System.out.print((char) data);	// 문자로 변환시켜 출력
		}
		
		fin.close();
		
		// fin을 통해서 더 이상 데이터를 읽을 수 없음
	}
	
}
