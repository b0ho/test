

public class one {
	public static void main(String[] args) {
		String str = "programming";
		one.solution(str);
	}

//	class Alpha {
//		String alpha = "";
//		int num = 0;
//		
//		Alpha() {
//			
//		}
//	}
//	
	public static String solution(String word) {
		String answer = "";

		// 알파벳 소문자 배열
		char[] alpha = new char[26];
		// 알파벳 순서에 해당하는 갯수 배열
		int[] num = new int[26];

		// 알파벳 초기화
		for (int i = 0; i < 26; i++) {
			alpha[i] = (char) (97 + i);
			// System.out.println(alpha[i]);
		}

		// 단어를 알파벳으로 쪼개서 알파벳 발견할때마다
		// 해당 알파벳 위치에 해당하는 갯수배열의 크기 1증가
		for (int i = 0; i < word.length(); i++) {
			num[word.charAt(i) - 97]++;
			// System.out.println(word.charAt(i));
			// System.out.println(word.charAt(i)-97);
			// System.out.println(num[word.charAt(i)-97]);
		}

		// 갯수배열 중 가장 큰 숫자를 찾음
		// 가장 많은 알파벳이 중복일 수 있음
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		// System.out.println(max);

		// 중복인 경우를 포함한 알파벳을 모두 정답에 추가
		for (int i = 0; i < num.length; i++) {
			if (num[i] == max) {
				answer += alpha[i];
			}
		}
		System.out.println(answer);

		return answer;
	}
}
