package solutions;
class 땅따먹기 {
	public static void main(String[] args) {
		땅따먹기 s = new 땅따먹기();
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println("start");
		s.solution(land);
		System.out.println("end");
	}

	int[][] Areas;
	int max;

	public int solution(int[][] land) {
		int answer = 0;
		Areas = land;
		max = 0;

		for (int i = 0; i < land[i].length - 1; i++) {
				int tmp = rec(0, i, 0);
				if (tmp > max) {
					max = tmp;
				}
		}

		answer = max;
		return answer;
	}

	public int rec(int x, int y, int sum) {
		if (x == 0 || x != y) {
			System.out.println(Areas[x][y]);
			sum += Areas[x][y];
			if (x + 1 < Areas.length) {
				rec(x + 1, y, sum);
			}
		}

		return sum;
	}
}
