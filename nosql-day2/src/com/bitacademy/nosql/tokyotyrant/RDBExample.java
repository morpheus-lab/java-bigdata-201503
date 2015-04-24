package com.bitacademy.nosql.tokyotyrant;

import java.net.InetSocketAddress;

import tokyotyrant.RDB;
import tokyotyrant.transcoder.DoubleTranscoder;
import tokyotyrant.transcoder.IntegerTranscoder;

/* RDB provides simple synchronous API */
public class RDBExample {

	public static void main(String[] args) {
		Object key, value;
		
		RDB db = new RDB();
		
		// 서버에 연결
		db.open(new InetSocketAddress("192.168.1.37", 1978));
		
		// 데이터 저장
		db.put("hello", "world");
		db.put("tokyo", "tyrant");
		db.put("nosql", "what?");
		
		System.out.println("--------------");
		
		// 데이터 조회
		System.out.println("hello: " + db.get("hello"));
		System.out.println("tokyo: " + db.get("tokyo"));
		System.out.println("nosql: " + db.get("nosql"));
		
		System.out.println("--------------");
		
		// 데이터 순회
		db.iterinit();
		while ((key = db.iternext()) != null) {
			value = db.get(key);
			System.out.println(key + ": " + value);
		}
		
		System.out.println("--------------");
		
		// int 데이터 저장
		key = "int";
		db.put(key, 3, new IntegerTranscoder());
		db.addint(key, 4);	// int 값 더하기
		value = db.get(key, new IntegerTranscoder());
		System.out.println(key + ": " + value);
		
		System.out.println("--------------");
		
		// double 데이터 저장
		key = "d";
		db.put(key, 3.0d, new DoubleTranscoder());
		db.adddouble(key, 4.5d);
		value = db.get(key, new DoubleTranscoder());
		System.out.println(key + ": " + value);
		
		System.out.println("--------------");
		
		// 모든 데이터 삭제
//		db.vanish();
		
		// 연결 종료
		db.close();
	}

}
