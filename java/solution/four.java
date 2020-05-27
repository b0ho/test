

public class four {
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		four.calcFin(n, m);
	}

	// N*N 이므로 정수1개와 이동 크기 정수 1개 필요
	public static int[] calcFin(int size, int num) {
		int answer[] = { 0, 0 };

		// 숫자를 채울 사각형 2중 배열 생성, 기본 0 초기화
		int[][] square = new int[size][size];
		// 현재 좌표 x, y
		int x = 0;
		int y = 0;
		// m만큼 이동할 방향
		int directionX = 1;
		int directionY = 1;
		// x로 이동중인지 y로 이동중인지 결정
		boolean XY = true;

		// 시작은 고정
		// square[0][0] = 1;
		// 최고값까지 반복
		for (int i = 1; i < size * size; i++) {
			int remain = 0;

			square[x][y] = i;
			//System.out.println(square[x][y] + ":" + x + "," + y);
			// 이동할 양 = M 이 남아있으면 반복
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

		// 현재 좌표가 곧 마지막 N*N 이 됨
		answer[0] = x;
		answer[1] = y;

		System.out.println(answer[0] + ", " + answer[1]);
		return answer;
	}
}
