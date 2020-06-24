import java.util.*;

public class 튜플 {
	public static void main(String[] args) {
		튜플 s = new 튜플();
		int num = 12;
		int num2 = 2;
		int[] arr = { 1, 5, 6, 10 };
		int[] arr2 = { 1, 2, 3, 4 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		// System.out.println("start");
		s.solution(str);
		// System.out.println("end");
	}

	// 배열인듯 아닌듯 거지같이 되어있는 스트링을 안헷갈리게 잘 파싱하기
	// 요소의 길이순 오름차순 정렬
	// LinkedHashSet 사용법
	// Iterator 사용법
	public int[] solution(String s) {
		// 스트링 정제 과정
		String 앞뒤중괄호자르기 = s.substring(2, s.length() - 2);
		String 튜플간중괄호자르기 = 앞뒤중괄호자르기.replace("},{", "#");
		String[] 튜플별로저장 = 튜플간중괄호자르기.split("#");
		// System.out.println(s1);

		// 정렬을 편하게 하기위해 arrayList로
		ArrayList<String> 튜플리스트 = new ArrayList<>();
		for (int i = 0; i < 튜플별로저장.length; i++) {
			// 이때 저장되는 것은
			튜플리스트.add(튜플별로저장[i]);
			// System.out.println(튜플별로저장[i]);
		}

		// 정렬 기준은 요소의 길이로 변경
		Comparator<String> c = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};

		// 정렬하면 리스트의 크기가 1부터 오름차순 정렬됨
		Collections.sort(튜플리스트, c);
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.println(tuples.get(i));
//		}
//		System.out.println();

		// hashset 이라는 것을 쓰면 추가할때 중복은 알아서 제외해주더라
		Set<Integer> 튜플셋 = new LinkedHashSet<>();

		// set에 저장
		for (int i = 0; i < 튜플리스트.size(); i++) {
			// 튜플까지 쪼개어 해시셋에 저장
			String[] t = 튜플리스트.get(i).split(",");
			for (int j = 0; j < t.length; j++) {
				튜플셋.add(Integer.parseInt(t[j]));
//				System.out.print(t[j]);
			}
//			System.out.println();
		}

		int[] answer = new int[튜플셋.size()];
		// System.out.println(튜플셋.size());

		// 요소를 뽑아 정답배열에 저장
		// 컬렉션:LinkedHashSet 에 저장된 요소를 읽을 때 쓰더라~
		Iterator<Integer> 반복자 = 튜플셋.iterator();
		int idx = 0;
		while (반복자.hasNext()) {
			answer[idx++] = 반복자.next();
		}

		// System.out.print(Arrays.toString(answer));
		// 반환해주면 끝이다?
		return answer;
	}

}
