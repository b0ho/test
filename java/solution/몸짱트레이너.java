public class 몸짱트레이너 {
	public static void main(String[] args) {
		몸짱트레이너 s = new 몸짱트레이너();
		int n = 3;
		int m = 2;
		int[][] timetable = { { 1170, 1210 }, { 1200, 1260 } };
		System.out.println("ss");
		s.solution(n, m, timetable);
	}

	public int solution(int n, int m, int[][] timetable) {
		int answer = 0;
		int maxTime = 0;
		int[] availableTime = new int[721];

		for (int i = 0; i < timetable.length; i++) {
			for (int j = timetable[i][0] - 600; j <= timetable[i][1] - 600; j++) {
				availableTime[j]++;
			}
		}

		for (int i = 0; i < availableTime.length; i++) {
			if (maxTime < availableTime[i]) {
				maxTime = availableTime[i];
			}
		}

		if (maxTime <= 1) {
			return 0;
		}

		int maxDist = 2 * (n - 1);
		boolean[][] locker = new boolean[n][n];

		for (int i = maxDist; i > 2; i--) {
			for (int firstCol = 0; firstCol < n; firstCol++) {
				int col = firstCol;
				int cnt = 0;
				while (col < n) {
					locker[0][col] = true;
					col += i;
					cnt++;
				}
				for (int row = 1; row < n; row++) {
					col = 0;
					loop: while (col < n) {
						for (int prevRow = row - 1; prevRow >= 0; prevRow--) {
							if (prevRow - row > i)
								break;
							for (int prevCol = 0; prevCol < n; prevCol++) {
								if (locker[prevRow][prevCol]) {
									if (distance(row, col, prevRow, prevCol) < i) {
										col++;
										continue loop;
									}
								}
							}
						}

						locker[row][col] = true;
						col += i;
						cnt++;
					}
				}
				
				locker = new boolean[n][n];
				if (cnt >= maxTime) {
					return i;
				}
			}
		}

		if (n * n / 2 + n % 2 >= maxTime) {
			return 2;
		}

		if (n * n >= maxTime) {
			return 1;
		}
		
		return answer;
	}

	public int distance(int row, int col, int prevRow, int prevCol) {
		return Math.abs(row - prevRow) + Math.abs(col - prevCol);
	}
}
