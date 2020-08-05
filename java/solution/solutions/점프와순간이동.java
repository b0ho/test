package solutions;

public class 점프와순간이동 {
	public int solution(int n) {
		int answer = 0;

		// 거꾸로 계산하는게 좋아보임
		// +1 할것인가 *2 할것인가 -> /2 할것인가 -1 할것인가

		while (true) {
			// 0 이 되면 종료
			if (n == 0) {
				break;
			}

			// 나눌 수 있으면 나눈다.
			if (n % 2 == 0) {
				n /= 2;
			}
			// 그렇지 않으면 점프
			// 점프에는 거리에 따른 가중치가 없으므로
			// 최대한 조금씩 (1씩) 변화 시키면서
			// 나눌 수 있으면 최대한 나누는 것이 이득이다.
			else {
				n--;
				answer++;
			}
		}

		return answer;
	}
}
