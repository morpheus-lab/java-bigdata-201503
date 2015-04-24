package com.bitacademy.nosql.tokyotyrant;

import tokyotyrant.MRDB;
import tokyotyrant.networking.NodeAddress;
import tokyotyrant.transcoder.DoubleTranscoder;
import tokyotyrant.transcoder.IntegerTranscoder;

/* �񵿱� API */
public class MRDBExample {

	public static void main(String[] args) throws Exception {
		
		Object key, value;
		
		MRDB db = new MRDB();

		// ����
		db.open(NodeAddress.addresses("tcp://192.168.1.37:1978"));

		// ������ ����
		db.await(db.put("hello", "world"));
		db.await(db.put("tokyo", "tyrant"));
		db.await(db.put("nosql", "what?"));

		System.out.println("--------------");

		// ������ ��ȸ
		System.out.println("hello: " + db.await(db.get("hello")));
		System.out.println("tokyo: " + db.await(db.get("tokyo")));
		System.out.println("nosql: " + db.await(db.get("nosql")));

		System.out.println("--------------");

		// ������ ��ȸ - �񵿱� API�� ������
//		db.iterinit();
//		while ((key = db.iternext()) != null) {
//			value = db.get(key);
//			System.out.println(key + ": " + value);
//		}

		System.out.println("--------------");

		// int ������ ����
		key = "int";
		db.await(db.put(key, 3, new IntegerTranscoder()));
		db.await(db.addint(key, 4));	// int �� ���ϱ�
		value = db.await(db.get(key, new IntegerTranscoder()));
		System.out.println(key + ": " + value);

		System.out.println("--------------");

		// double ������ ����
		key = "d";
		db.await(db.put(key, 3.0d, new DoubleTranscoder()));
		db.await(db.adddouble(key, 4.5d));
		value = db.await(db.get(key, new DoubleTranscoder()));
		System.out.println(key + ": " + value);

		System.out.println("--------------");

		// ��� ������ ����
//		db.vanish();

		// ���� ����
		db.close();
	}

}
