package solutions;

public class 등굣길 {
	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;

		// 최단 경로의 개수는 되돌아 가지 않는 이전 경로들의 합
		// 종료가 반드시 오른쪽 하단이므로 최단 가능 경로는 왼쪽과 위 뿐임
		// 거리 배열에 좌표마다 가능한 최단 경로의 수를 증적해 나가면됨

		// 최초에 거리 배열 0으로 초기화가 필요함
		int[][] streets = new int[m][n];

		// 웅덩이를 좌표로 접근하기 위해 거리 배열에 추가
		// 일반 좌표와 차이를 두기 위해 -1로
		for (int[] puddle : puddles) {
			streets[puddle[0] - 1][puddle[1] - 1] = -1;
		}

		// 시작은 1
		streets[0][0] = 1;

		// 모든 좌표를 검사
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// 웅덩이 이면 == -1 이면 해당 좌표는 계산하지 않고 0으로 바꿔줌
				// 0으로 설정해 주어야 다음 좌표들에서 증적 가능
				if (streets[i][j] == -1) {
					streets[i][j] = 0;
					continue;
				}

				// 위쪽과 왼쪽만 접근하므로 바운더리 체크는 0이 아닐때
				if (i != 0) {
					// 현재 좌표에 이전 최소값을 더함
					// 이때 1000000007으로 나누지 않으면 효율성 실패
					// 정수범위 때문인듯??
					streets[i][j] += streets[i - 1][j] % 1000000007;
				}
				// 끝인 경우가 있으므로 각 각 더해 주어야함
				if (j != 0) {
					streets[i][j] += streets[i][j - 1] % 1000000007;
				}

			}
		}

		answer = streets[m - 1][n - 1] % 1000000007;

		return answer;
	}
}
