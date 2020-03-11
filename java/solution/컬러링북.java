class 컬러링북 {
	public static void main(String[] args) {
		컬러링북 s = new 컬러링북();
		int n = 6;
		int m = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		System.out.println("start");
		s.solution(n, m, picture);
		System.out.println("end");
	}

	int cnt;
	int[][] Areas;
	boolean[][] check;

	public int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2]; // 정답
		int numberA = 0;// 영역의 총 개수
		int SizeA = 0;// 가장 큰 영역의 면적
		Areas = picture; // 좌표 배열
		check = new boolean[m][n]; // 방문 체크 배열

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 이미 방문했으면 다음으로 넘어감
				if (picture[i][j] == 0 || check[i][j] == true) {
					continue;
				}

				// 재귀로 검사
				removeA(i, j);

				// 가장 사이즈가 큰 영역을 바꿈
				if (SizeA < cnt) {
					SizeA = cnt;
				}

				// 영역의 개수를 증가
				numberA++;

				// !!!!카운터 초기화 1이면 에러
				cnt = 0;
			}
		}

		answer[0] = numberA;
		answer[1] = SizeA;
		return answer;
	}

	public void removeA(int i, int j) {
		// 방문함
		check[i][j] = true;
		// 방문 시작하면서 카운터 증가
		cnt++;

		// 같은 영역이면서 인덱스 크기 안에 있을 때 상하좌우 모두 검사
		if (i > 0 && Areas[i - 1][j] == Areas[i][j] && check[i - 1][j] == false) {
			removeA(i - 1, j);
		}
		if (i < Areas.length - 1 && Areas[i + 1][j] == Areas[i][j] && check[i + 1][j] == false) {
			removeA(i + 1, j);
		}
		if (j > 0 && Areas[i][j - 1] == Areas[i][j] && check[i][j - 1] == false) {
			removeA(i, j - 1);
		}
		if (j < Areas[0].length - 1 && Areas[i][j + 1] == Areas[i][j] && check[i][j + 1] == false) {
			removeA(i, j + 1);
		}
	}
}
