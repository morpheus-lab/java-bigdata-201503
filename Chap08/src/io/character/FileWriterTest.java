package io.character;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileWriterTest {
	
	public static void main(String[] args) throws Exception {
		
		// Ű���� �Է�
		InputStreamReader keyIn = new InputStreamReader(System.in);
		
		// ���� ���
		FileWriter fileOut = new FileWriter("D:\\out.txt");
		
		int c = 0;	// �� ���ڸ� �ӽ� ������ ����
		
		while ((c = keyIn.read()) != -1) {	// Ű����κ��� ������ �о c�� ����
			fileOut.write(c);	// c�� ���Ͽ� ���
		}
		
		keyIn.close();
		fileOut.close();
		
	}
	
}
