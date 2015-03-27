import java.util.Scanner;
import java.util.StringTokenizer;


public class Omok {
	
	static final char BLACK = '●';	// 'ㅁ'+<한자>
	static final char WHITE = '○';
	
	static final int CODE_BLACK = 1;
	static final int CODE_WHITE = 2;
	
	static void printBadukpan(int[][] badukpan) {
		for (int y = 0; y < badukpan[0].length; y++) {
			for (int x = 0; x < badukpan.length; x++) {
				System.out.print(" " + badukpan[x][y]);
				/*
				switch (badukpan[x][y]) {
				case CODE_BLACK:
					System.out.print(BLACK);
					break;
				case CODE_WHITE:
					System.out.print(WHITE);
					break;
				default:
					if (x == 0 && y == 0)
						System.out.print('┌');
					else if (x == 0 && y == badukpan[y].length - 1)
						System.out.print('└');
					else if (x == badukpan.length - 1 && y == 0)
						System.out.print('┐');
					else if (x == badukpan.length - 1 && y == badukpan[0].length - 1)
						System.out.print('┘');
					else if (x == 0)
						System.out.print('├');
					else if (x == badukpan.length - 1)
						System.out.print('┤');
					else if (y == 0)
						System.out.print('┬');
					else if (y == badukpan[0].length - 1)
						System.out.print('┴');
					else
						System.out.print('┼');	// 'ㅂ'+<한자>
					break;
				}
				*/
			}
			System.out.println();
		}
	}
	
	static int checkWinner(int[][] badukpan) {	// 흑돌: CODE_BLACK, 백돌: CODE_WHITE, 이긴사람없음: 0
		
		for (int y = 0; y < badukpan[0].length; y++) {
			for (int x = 0; x < badukpan.length; x++) {
				int dol = badukpan[x][y];
				// 가로 방향 승리
				if (x > 1 && x < badukpan.length - 2
						&& badukpan[x-2][y] == dol
						&& badukpan[x-1][y] == dol
						&& badukpan[x+1][y] == dol
						&& badukpan[x+2][y] == dol) {
					return dol;
				}
				// 세로 방향 승리
				if (y > 1 && y < badukpan[0].length - 2
						&& badukpan[x][y-2] == dol
						&& badukpan[x][y-1] == dol
						&& badukpan[x][y+1] == dol
						&& badukpan[x][y+2] == dol) {
					return dol;
				}
				// 좌하-우상 대각선
				if (x > 1 && x < badukpan.length - 2
						&& y > 1 && y < badukpan[0].length - 2
						&& badukpan[x-2][y+2] == dol
						&& badukpan[x-1][y+1] == dol
						&& badukpan[x+1][y-1] == dol
						&& badukpan[x+2][y-2] == dol) {
					return dol;
				}
				// 좌상-우하 대각선
				if (x > 1 && x < badukpan.length - 2
						&& y > 1 && y < badukpan[0].length - 2
						&& badukpan[x-2][y-2] == dol
						&& badukpan[x-1][y-1] == dol
						&& badukpan[x+1][y+1] == dol
						&& badukpan[x+2][y+2] == dol) {
					return dol;
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		/*
		int[][] arr = {
				{1,0,2,0,2},
				{0,1,1,2,0},
				{2,1,2,2,2},
				{0,2,2,1,0},
				{2,0,2,0,1}
		};
		System.out.println(checkWinner(arr));
		*/
		
		//*
		Scanner sc = new Scanner(System.in);
		
		int size = 0;
		
		while (size < 5 || size > 15) {
			System.out.print("바둑판 크기를 입력하세요(5-15): ");
			size = sc.nextInt();
			sc.nextLine();	// 키보드 버퍼에 남아있는 엔터키 제거
		}
		
		int[][] badukpan = new int[size][size];
		
		boolean isBlackTurn = true;	// 흑돌 차례?
		while (true) {
			// 바둑판 출력
			printBadukpan(badukpan);
			
			System.out.print("[" + (isBlackTurn ? "흑" : "백") + "] ('x,y' 형식으로 입력): ");
			String point = sc.nextLine();	// "2,3"
			
			int x = Integer.parseInt(point.split(",")[0]);
			int y = Integer.parseInt(point.split(",")[1]);
			
			// 바둑판 범위를 벗어났다면?
			if ((x < 0 || x > badukpan.length - 1) || (y < 0 || y > badukpan[0].length - 1)) {
				System.out.println("바둑판 범위 벗어남!!! 다시!!!");
				continue;
			}
			// x,y에 이미 돌이 놓여있다면?
			if (badukpan[x][y] != 0) {
				System.out.println("이미 놓여진 자리!!! 다시!!!");
				continue;
			}
			
			// 돌 놓기
			badukpan[x][y] = isBlackTurn ? CODE_BLACK : CODE_WHITE;
			
			// 승리 검사
			int winner = checkWinner(badukpan);
			System.out.println("winner = " + winner);
			
			if (winner == CODE_BLACK || winner == CODE_WHITE) {
				// 승리 축하 메시지 출력
				System.out.println("축하합니다. " + (winner == CODE_BLACK ? "흑" : "백") + "돌의 승리입니다.");
				// 게임 종료
				break;
			}
			
			// 턴 바꾸기
			isBlackTurn = !isBlackTurn;
		}
		//*/
	}
	
}






























