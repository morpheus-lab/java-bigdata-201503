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
		
		// ������ ����
		db.open(new InetSocketAddress("192.168.1.37", 1978));
		
		// ������ ����
		db.put("hello", "world");
		db.put("tokyo", "tyrant");
		db.put("nosql", "what?");
		
		System.out.println("--------------");
		
		// ������ ��ȸ
		System.out.println("hello: " + db.get("hello"));
		System.out.println("tokyo: " + db.get("tokyo"));
		System.out.println("nosql: " + db.get("nosql"));
		
		System.out.println("--------------");
		
		// ������ ��ȸ
		db.iterinit();
		while ((key = db.iternext()) != null) {
			value = db.get(key);
			System.out.println(key + ": " + value);
		}
		
		System.out.println("--------------");
		
		// int ������ ����
		key = "int";
		db.put(key, 3, new IntegerTranscoder());
		db.addint(key, 4);	// int �� ���ϱ�
		value = db.get(key, new IntegerTranscoder());
		System.out.println(key + ": " + value);
		
		System.out.println("--------------");
		
		// double ������ ����
		key = "d";
		db.put(key, 3.0d, new DoubleTranscoder());
		db.adddouble(key, 4.5d);
		value = db.get(key, new DoubleTranscoder());
		System.out.println(key + ": " + value);
		
		System.out.println("--------------");
		
		// ��� ������ ����
//		db.vanish();
		
		// ���� ����
		db.close();
	}

}
