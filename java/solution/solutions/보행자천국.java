package solutions;

public class 보행자천국 {
	public int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		int[][] right = new int[m + 1][n + 1];
		int[][] down = new int[m + 1][n + 1];
		right[1][1] = 1;
		down[1][1] = 1;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cityMap[i - 1][j - 1] == 0) {
					right[i][j] += (right[i - 1][j] + down[i][j - 1]) % 20170805;
					down[i][j] += (right[i - 1][j] + down[i][j - 1]) % 20170805;
				} else if (cityMap[i - 1][j - 1] == 1) {
					right[i][j] = 0;
					down[i][j] = 0;
				} else if (cityMap[i - 1][j - 1] == 2) {
					right[i][j] = right[i - 1][j];
					down[i][j] = down[i][j - 1];
				}
				System.out.println(down[i][j]);
			}
		}

		answer = right[m][n];

		// System.out.println(answer);
		return answer;
	}
}
