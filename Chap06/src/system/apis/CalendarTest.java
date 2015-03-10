package system.apis;

import java.util.Calendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();	// 객체 얻기
		
		// 시간 조회
		// get(int field) 메소드 이용
		// 각종 필드는 Calendar 클래스에 상수로 정의되어있음
		
		int year = now.get(Calendar.YEAR);	// 년도 조회
		int month = now.get(Calendar.MONTH);	// 월 조회 (0: 1월, 1: 2월, ...)
		int day = now.get(Calendar.DAY_OF_MONTH);	// 일
		
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);	// 1: 일, 2: 월, 3: 화, ..., 7: 토
		System.out.println(dayOfWeek);
		
//		int hour = now.get(Calendar.HOUR);	// 12시간제 시간
		int hour = now.get(Calendar.HOUR_OF_DAY);	// 24시간제 시간
		int minute = now.get(Calendar.MINUTE);	// 분
		int second = now.get(Calendar.SECOND);	// 초
		
		
		System.out.println("현재: " + year + "-" + month + "-" + day
				+ " " + hour + ":" + minute + ":" + second);
		
		System.out.println(
				String.format("현재: %04d-%02d-%02d %02d:%02d:%02d",
						year, month, day, hour, minute, second));
		
//		now.add(Calendar.YEAR, 1);	// now +1년
//		now.add(Calendar.DAY_OF_MONTH, 20);	// now +20일
		now.add(Calendar.DAY_OF_MONTH, 300);	// now +300일
		
		System.out.println(now);
		
	}
	
}
