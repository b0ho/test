package solutions;


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

		// ���ĺ� �ҹ��� �迭
		char[] alpha = new char[26];
		// ���ĺ� ������ �ش��ϴ� ���� �迭
		int[] num = new int[26];

		// ���ĺ� �ʱ�ȭ
		for (int i = 0; i < 26; i++) {
			alpha[i] = (char) (97 + i);
			// System.out.println(alpha[i]);
		}

		// �ܾ ���ĺ����� �ɰ��� ���ĺ� �߰��Ҷ�����
		// �ش� ���ĺ� ��ġ�� �ش��ϴ� �����迭�� ũ�� 1����
		for (int i = 0; i < word.length(); i++) {
			num[word.charAt(i) - 97]++;
			// System.out.println(word.charAt(i));
			// System.out.println(word.charAt(i)-97);
			// System.out.println(num[word.charAt(i)-97]);
		}

		// �����迭 �� ���� ū ���ڸ� ã��
		// ���� ���� ���ĺ��� �ߺ��� �� ����
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		// System.out.println(max);

		// �ߺ��� ��츦 ������ ���ĺ��� ��� ���信 �߰�
		for (int i = 0; i < num.length; i++) {
			if (num[i] == max) {
				answer += alpha[i];
			}
		}
		System.out.println(answer);

		return answer;
	}
}
