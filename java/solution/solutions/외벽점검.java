package solutions;
import java.util.ArrayList;

public class 외벽점검 {
	public static void main(String[] args) {
		외벽점검 s = new 외벽점검();
		int num = 12;
		int num2 = 2;
		int[] arr = { 1, 5, 6, 10 };
		int[] arr2 = { 1, 2, 3, 4 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "abcabcabcabcdededededede";
		// System.out.println("start");
		s.solution(num, arr, arr2);
		// System.out.println("end");
	}

	public int answer = Integer.MAX_VALUE;
	public int size;
	public int[] candy;

	public int solution(int n, int[] weak, int[] dist) {
		ArrayList<Integer> weakList = new ArrayList<>();
		size = n;
		candy = dist;

		// 리스트로 변환
		for (int i = 0; i < weak.length; i++) {
			weakList.add(weak[i]);
		}

		// 재귀로 dist 경우에 대해 모두 검사
		// 속도 문제로 위에서 줄어들기로,,
		for (int i = dist.length - 1; i > 0; i--) {
			dfs(weakList, i, 0);
		}

		// 점검 불가능한 경우 -1
		if (answer == Integer.MAX_VALUE) {
			return -1;
		}

		System.out.println(answer);
		return answer;
	}

	// 재귀
	public void dfs(ArrayList<Integer> week, int idx, int cnt) {
		// 최소값을 찾아서 종료
		if (week.size() == 0) {
			answer = Math.min(answer, cnt);
			return;
		}

		// 모든 dist 를 탐색했으면 재귀 종료
		if (idx < 0) {
			return;
		}
		// 그렇지 않으면 카운터 증가
		cnt++;

		// 하면서 업무 수행
		for (int i = 0; i < week.size(); i++) {
			// 재귀에서 사용하고 넘겨줄 List
			ArrayList<Integer> nextList = new ArrayList<>();
			// 현재 week
			int now = week.get(i);
			// week 위치가 범위를 벗어나는 경우 범위만큼 줄어들면서 증가
			int changeNow = now + candy[idx];
			if (now + candy[idx] >= size) {
				changeNow -= size;
			}

			for (int j = 0; j < week.size(); j++) {
				// 이부분으로 속도가 크게 단축됨,, 왜지?
				if (i == j) {
					continue;
				}

				int next = week.get(j);

				// 범위를 벗어나는 경우를 고려하여 다음 값 추가
				if (changeNow < now && next < now && next > changeNow) {
					nextList.add(next);
				}
				if (changeNow >= now && (next < now || next > changeNow)) {
					nextList.add(next);
				}

			}
			// 새로운 재귀 시작
			dfs(nextList, idx - 1, cnt);

		}
	}
}
