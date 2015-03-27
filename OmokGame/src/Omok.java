import java.util.Scanner;
import java.util.StringTokenizer;


public class Omok {
	
	static final char BLACK = '��';	// '��'+<����>
	static final char WHITE = '��';
	
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
						System.out.print('��');
					else if (x == 0 && y == badukpan[y].length - 1)
						System.out.print('��');
					else if (x == badukpan.length - 1 && y == 0)
						System.out.print('��');
					else if (x == badukpan.length - 1 && y == badukpan[0].length - 1)
						System.out.print('��');
					else if (x == 0)
						System.out.print('��');
					else if (x == badukpan.length - 1)
						System.out.print('��');
					else if (y == 0)
						System.out.print('��');
					else if (y == badukpan[0].length - 1)
						System.out.print('��');
					else
						System.out.print('��');	// '��'+<����>
					break;
				}
				*/
			}
			System.out.println();
		}
	}
	
	static int checkWinner(int[][] badukpan) {	// �浹: CODE_BLACK, �鵹: CODE_WHITE, �̱�������: 0
		
		for (int y = 0; y < badukpan[0].length; y++) {
			for (int x = 0; x < badukpan.length; x++) {
				int dol = badukpan[x][y];
				// ���� ���� �¸�
				if (x > 1 && x < badukpan.length - 2
						&& badukpan[x-2][y] == dol
						&& badukpan[x-1][y] == dol
						&& badukpan[x+1][y] == dol
						&& badukpan[x+2][y] == dol) {
					return dol;
				}
				// ���� ���� �¸�
				if (y > 1 && y < badukpan[0].length - 2
						&& badukpan[x][y-2] == dol
						&& badukpan[x][y-1] == dol
						&& badukpan[x][y+1] == dol
						&& badukpan[x][y+2] == dol) {
					return dol;
				}
				// ����-��� �밢��
				if (x > 1 && x < badukpan.length - 2
						&& y > 1 && y < badukpan[0].length - 2
						&& badukpan[x-2][y+2] == dol
						&& badukpan[x-1][y+1] == dol
						&& badukpan[x+1][y-1] == dol
						&& badukpan[x+2][y-2] == dol) {
					return dol;
				}
				// �»�-���� �밢��
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
			System.out.print("�ٵ��� ũ�⸦ �Է��ϼ���(5-15): ");
			size = sc.nextInt();
			sc.nextLine();	// Ű���� ���ۿ� �����ִ� ����Ű ����
		}
		
		int[][] badukpan = new int[size][size];
		
		boolean isBlackTurn = true;	// �浹 ����?
		while (true) {
			// �ٵ��� ���
			printBadukpan(badukpan);
			
			System.out.print("[" + (isBlackTurn ? "��" : "��") + "] ('x,y' �������� �Է�): ");
			String point = sc.nextLine();	// "2,3"
			
			int x = Integer.parseInt(point.split(",")[0]);
			int y = Integer.parseInt(point.split(",")[1]);
			
			// �ٵ��� ������ ����ٸ�?
			if ((x < 0 || x > badukpan.length - 1) || (y < 0 || y > badukpan[0].length - 1)) {
				System.out.println("�ٵ��� ���� ���!!! �ٽ�!!!");
				continue;
			}
			// x,y�� �̹� ���� �����ִٸ�?
			if (badukpan[x][y] != 0) {
				System.out.println("�̹� ������ �ڸ�!!! �ٽ�!!!");
				continue;
			}
			
			// �� ����
			badukpan[x][y] = isBlackTurn ? CODE_BLACK : CODE_WHITE;
			
			// �¸� �˻�
			int winner = checkWinner(badukpan);
			System.out.println("winner = " + winner);
			
			if (winner == CODE_BLACK || winner == CODE_WHITE) {
				// �¸� ���� �޽��� ���
				System.out.println("�����մϴ�. " + (winner == CODE_BLACK ? "��" : "��") + "���� �¸��Դϴ�.");
				// ���� ����
				break;
			}
			
			// �� �ٲٱ�
			isBlackTurn = !isBlackTurn;
		}
		//*/
	}
	
}






























