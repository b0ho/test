package solutions;

class 땅따먹기 {
	int solution(int[][] land) {
		int answer = 0;

		// System.out.println(land.length);
		// System.out.println(land[0].length);

		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				int max = 0;
				for (int k = 0; k < land[0].length; k++) {
					if (j != k) {
						if (max < land[i - 1][k]) {
							max = land[i - 1][k];
						}
					} else {
						continue;
					}
				}
				land[i][j] += max;
			}
		}

		for (int i = 0; i < land[0].length; i++) {
			if (answer < land[land.length - 1][i]) {
				answer = land[land.length - 1][i];
			}
		}

		return answer;
	}
}
