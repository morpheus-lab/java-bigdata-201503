package com.bitacademy.nosql.tokyotyrant;

import tokyotyrant.MRDB;
import tokyotyrant.networking.NodeAddress;
import tokyotyrant.transcoder.DoubleTranscoder;
import tokyotyrant.transcoder.IntegerTranscoder;

/* 비동기 API */
public class MRDBExample {

	public static void main(String[] args) throws Exception {
		
		Object key, value;
		
		MRDB db = new MRDB();

		// 연결
		db.open(NodeAddress.addresses("tcp://192.168.1.37:1978"));

		// 데이터 저장
		db.await(db.put("hello", "world"));
		db.await(db.put("tokyo", "tyrant"));
		db.await(db.put("nosql", "what?"));

		System.out.println("--------------");

		// 데이터 조회
		System.out.println("hello: " + db.await(db.get("hello")));
		System.out.println("tokyo: " + db.await(db.get("tokyo")));
		System.out.println("nosql: " + db.await(db.get("nosql")));

		System.out.println("--------------");

		// 데이터 순회 - 비동기 API는 미지원
//		db.iterinit();
//		while ((key = db.iternext()) != null) {
//			value = db.get(key);
//			System.out.println(key + ": " + value);
//		}

		System.out.println("--------------");

		// int 데이터 저장
		key = "int";
		db.await(db.put(key, 3, new IntegerTranscoder()));
		db.await(db.addint(key, 4));	// int 값 더하기
		value = db.await(db.get(key, new IntegerTranscoder()));
		System.out.println(key + ": " + value);

		System.out.println("--------------");

		// double 데이터 저장
		key = "d";
		db.await(db.put(key, 3.0d, new DoubleTranscoder()));
		db.await(db.adddouble(key, 4.5d));
		value = db.await(db.get(key, new DoubleTranscoder()));
		System.out.println(key + ": " + value);

		System.out.println("--------------");

		// 모든 데이터 삭제
//		db.vanish();

		// 연결 종료
		db.close();
	}

}
