package io.file;

import java.io.File;

public class FileTest {
	
	public static void main(String[] args) {
		/*
		File f = new File("D:\\tmp");	// 파일/디렉토리에 대한 정보를 갖는 객체
		
		System.out.println("존재?: " + f.exists());	// 파일 시스템에 존재하는지?
		System.out.println("파일?: " + f.isFile());	// 파일인지?
		System.out.println("폴더?: " + f.isDirectory());	// 디렉토리인지?
		System.out.println("크기 : " + f.length());	// 파일 크기 (바이트 단위)
		System.out.println("읽기?: " + f.canRead());	// 읽기 권한 있는지?
		System.out.println("쓰기?: " + f.canWrite());	// 쓰기 권한 있는지?
		System.out.println("실행?: " + f.canExecute());	// 실행 권한 있는지?
		
		System.out.println("디렉토리 내 파일 목록: ");
		String[] fileNames = f.list();
		for (String fileName : fileNames) {
			System.out.println("\t" + fileName);
		}
		
		File[] files = f.listFiles();
		*/
		
		File dir = new File("D:\\tmp2\\a\\b\\c");	// 존재하지않는 디렉토리
		if (!dir.exists()) {
			System.out.println("디렉토리가 존재하지 않아 새로 생성합니다.");
			if (dir.mkdirs())
				System.out.println("디렉토리 생성 완료");
			else
				System.out.println("디렉토리 생성 실패");
		}
		
		long lastModified = dir.lastModified();
		
		System.out.println(dir.getPath());
		System.out.println(dir.getName());
		System.out.println(dir.lastModified());	// 마지막 수정 시각
												// => EPOCH시간 (1970-01-01 00:00:00.000로부터 몇 ms 지났는지?)
		System.out.printf("%1$tm-%1$td %1$tH:%1$tM", lastModified);
		
	}
	
}




















