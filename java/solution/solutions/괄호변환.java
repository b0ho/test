package solutions;

class 괄호변환 {
	public static void main(String[] args) {
		괄호변환 s = new 괄호변환();
		int num = 4;
		int num2 = 1;
		int[] num_arr = { 120, 110, 140, 150 };
		String str = "()))((()";
		String str2 = "";
		String[] str_arr = { "", "" };
		System.out.println("start");
		s.solution(str);
		System.out.println("end");
	}

	// 조건3, 조건4-2 전체가 하나의 함수로 작동되어야함
	public String solution(String p) {
		// 모든 변수는 재귀때마다 초기화되어야함 : 매번 새로운 u, v를 생성
		String answer = "";
		int left = 0;
		int right = 0;
		boolean correct = true;
		// int size = ;

		// 조건 1
		if (p.length() == 0) {
			return answer;
		}

		// 균형잡힌 문자열 : 괄호의 개수를 비교
		for (int i = 0; i < p.length(); i++) {

			if (p.charAt(i) == '(') {
				left++;
			}
			if (p.charAt(i) == ')') {
				right++;
			}
			// 한순간이라도 오른쪽이 더 많았다면
			// 그순간 올바르지 않은 문자열임
			if (left < right) {
				correct = false;
			}

			// 조건 2 : 한번이라도 left == right 가 되면
			// 균형잡힌 u가 존재하는 것임
			// + (와 )의 개수는같으므로 자동적으로 v도 균형잡힘
			// 즉 left == right 인 순간 조건 2 충족됨
			if (left == right) {

				// 올바른 문자열 : 조건 3
				if (correct == true) {
					// 조건 3 : u -> 현재 부분까지
					answer += p.substring(0, i + 1);

					// 조건 3 : v -> u 뒷 부분부터
					answer += solution(p.substring(i + 1, p.length()));

					// 조건 3-1
					return answer;
				}

				// 조건 4
				else if (correct == false) {
					// 조건 4-1
					answer += "(";

					// 조건 4-2 : v -> u 뒷 부분부터
					answer += solution(p.substring(i + 1, p.length()));

					// 조건 4-3
					answer += ")";

					// 조건 4-4 : u 첫번째와 마지막 제거를 위한 범위 조절
					for (int j = 1; j < i; j++) {
						if (p.charAt(j) == ')') {
							answer += "(";
						}
						if (p.charAt(j) == '(') {
							answer += ")";
						}
					}

					// 조건 4-5
					return answer;
				}
			}
		}
		return answer;
	}
}
