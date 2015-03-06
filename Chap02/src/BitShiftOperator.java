
public class BitShiftOperator {
	
	public static void main(String[] args) {
		
		short a = (short) 0x55ff;
		short b = 0x00ff;
		
		// 비트 연산
		System.out.printf("%x\n", a & b);	// %x : 정수를 16진수 형식으로 출력
		System.out.printf("%x\n", a | b);
		System.out.printf("%x\n", a ^ b);
		System.out.printf("%x\n", ~a);	// 00000000 00000000 01010101 11111111
										// 11111111 11111111 10101010 00000000 => FFFFAA00
		
		byte c = 20;	// 0x14
		byte d = -8;	// 0xf8
		
		// 시프트 연산
		System.out.println(c << 2);	// c의 데이터 비트를 2칸 왼쪽으로 시프트
		System.out.println(c >> 2);	// c의 데이터 비트를 2칸 오른쪽으로 시프트
		System.out.println(d >> 2);	// d의 데이터 비트를 2칸 오른쪽으로 시프트
		System.out.printf("%x\n", d >>> 2);
		
	}
	
}
