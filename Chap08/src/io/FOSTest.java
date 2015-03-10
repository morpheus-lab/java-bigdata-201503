package io;

import java.io.FileOutputStream;

public class FOSTest {
	
	public static void main(String[] args) throws Exception {
		
		FileOutputStream fout = new FileOutputStream("D:\\test1.txt");
		
		/*
		int[] num = {1, 4, -1, 88, 50};
		byte[] b = {7, 51, 3, 4, 1, 24};
		
		// void write(int b) - 인자 b의 정수 값을 그대로 파일에 1 byte로 기록
		
		for (int i = 0; i < num.length; i++) {
			fout.write(num[i]);
		}
		
		// void write(byte[] b) - 인자 b 배열을 정수 값 그대로 파일에 모두 기록
		fout.write(b);
		*/
		
		// 'a' ~ 'z'까지 파일에 기록
		for (char c = 'a'; c <= 'z'; c++) {
			fout.write(c);	// void write(int b) - char 타입도 정수형 데이터
		}
		
		fout.close();
		
		System.out.println("파일에 데이터 기록 완료");
		
	}
	
}

























