
public class 문자열압축 {

	public static void main(String[] args) {
		문자열압축 s = new 문자열압축();
		int num = 4;
		int num2 = 2;
		int[] arr = { 3, 2, 5 };
		int[] arr2 = { 2, 4, 1 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "abcabcabcabcdededededede";
		//System.out.println("start");
		s.solution(str);
		//System.out.println("end");
	}

	public int solution(String s) {
		// 최악인 경우 원본 문자열의 길이 반환
		int answer = s.length();

		// 문자열 비교 문제는 버퍼가 좋더라
		StringBuffer sb = new StringBuffer(s);

		// 문자열은 정해진 길이로 잘라야하므로
		// 최대 절반까지 밖에 자를 수 없다
		for (int i = 1; i <= s.length() / 2; i++) {
			// 정해진 길이로 잘라지지 않는 경우는 스킵
			if (s.length() % i != 0) {
				continue;
			}
			// 순환 마다 예상 결과 생성
			StringBuffer result = new StringBuffer();
			// 이것을 예상 결과에 덧붙여 나갈 것임
			String tmp = sb.substring(0, i);
			// System.out.println("tmp1 : " + tmp);
			// 같은 문자열 반복 카운터
			int cnt = 1;

			for (int j = i; j + i <= s.length(); j += i) {

				// 문자열이 같으면 카운터 증가하고
				// System.out.println("sb.substring(" + j + ", " + (j + i) + ") : " +
				// sb.substring(j, j + i));
				if (tmp.equals(sb.substring(j, j + i))) {
					cnt++;
					// System.out.println(cnt);
				}
				// 다르면 예상 결과에 추가
				else {
					// 1개면 문자열만
					if (cnt == 1) {
						result.append(tmp);
					}
					// n개면 개수를 붙여서 추가
					else {
						result.append(cnt);
						result.append(tmp);
					}
					// 초기화
					cnt = 1;
					// 비교 대상을 다음으로
					tmp = sb.substring(j, j + i);
				}

				// 마지막에 잘 안들어가서 추가,,
				if (cnt != 1 && j + i == s.length()) {
					result.append(cnt);
					result.append(tmp);
				}
				if (cnt == 1 && j + i == s.length()) {
					result.append(tmp);
				}

				// System.out.println("tmp : " + tmp);
				// System.out.println(result + ", " + result.length());
			}

			// 순환이 끝나면 최소 값 찾기
			if (answer > result.length()) {
				answer = result.length();
			}

			//System.out.println(i + ", " + result + ", " + result.length());
		}
		//System.out.println(answer);
		return answer;
	}

}
