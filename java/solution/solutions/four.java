package solutions;


public class four {
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		four.calcFin(n, m);
	}

	// N*N �̹Ƿ� ����1���� �̵� ũ�� ���� 1�� �ʿ�
	public static int[] calcFin(int size, int num) {
		int answer[] = { 0, 0 };

		// ���ڸ� ä�� �簢�� 2�� �迭 ����, �⺻ 0 �ʱ�ȭ
		int[][] square = new int[size][size];
		// ���� ��ǥ x, y
		int x = 0;
		int y = 0;
		// m��ŭ �̵��� ����
		int directionX = 1;
		int directionY = 1;
		// x�� �̵������� y�� �̵������� ����
		boolean XY = true;

		// ������ ����
		// square[0][0] = 1;
		// �ְ����� �ݺ�
		for (int i = 1; i < size * size; i++) {
			int remain = 0;

			square[x][y] = i;
			//System.out.println(square[x][y] + ":" + x + "," + y);
			// �̵��� �� = M �� ���������� �ݺ�
			while (remain < num - 1) {
				if (square[x][y] == 0) {
					remain++;
				}
				if (XY == true) {
					x += directionX;
					if (x + directionX >= size || x + directionX <= 0) {
						directionX *= -1;
						XY = false;
					}
				} else {
					y += directionY;
					if (y + directionY >= size || y + directionY <= 0) {
						directionY *= -1;
						XY = true;
					}
				}
			}
		}

		// ���� ��ǥ�� �� ������ N*N �� ��
		answer[0] = x;
		answer[1] = y;

		System.out.println(answer[0] + ", " + answer[1]);
		return answer;
	}
}
