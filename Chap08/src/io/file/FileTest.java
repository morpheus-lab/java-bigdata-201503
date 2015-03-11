package io.file;

import java.io.File;

public class FileTest {
	
	public static void main(String[] args) {
		/*
		File f = new File("D:\\tmp");	// ����/���丮�� ���� ������ ���� ��ü
		
		System.out.println("����?: " + f.exists());	// ���� �ý��ۿ� �����ϴ���?
		System.out.println("����?: " + f.isFile());	// ��������?
		System.out.println("����?: " + f.isDirectory());	// ���丮����?
		System.out.println("ũ�� : " + f.length());	// ���� ũ�� (����Ʈ ����)
		System.out.println("�б�?: " + f.canRead());	// �б� ���� �ִ���?
		System.out.println("����?: " + f.canWrite());	// ���� ���� �ִ���?
		System.out.println("����?: " + f.canExecute());	// ���� ���� �ִ���?
		
		System.out.println("���丮 �� ���� ���: ");
		String[] fileNames = f.list();
		for (String fileName : fileNames) {
			System.out.println("\t" + fileName);
		}
		
		File[] files = f.listFiles();
		*/
		
		File dir = new File("D:\\tmp2\\a\\b\\c");	// ���������ʴ� ���丮
		if (!dir.exists()) {
			System.out.println("���丮�� �������� �ʾ� ���� �����մϴ�.");
			if (dir.mkdirs())
				System.out.println("���丮 ���� �Ϸ�");
			else
				System.out.println("���丮 ���� ����");
		}
		
		long lastModified = dir.lastModified();
		
		System.out.println(dir.getPath());
		System.out.println(dir.getName());
		System.out.println(dir.lastModified());	// ������ ���� �ð�
												// => EPOCH�ð� (1970-01-01 00:00:00.000�κ��� �� ms ��������?)
		System.out.printf("%1$tm-%1$td %1$tH:%1$tM", lastModified);
		
	}
	
}




















