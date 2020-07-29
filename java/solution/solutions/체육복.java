package solutions;
import java.util.ArrayList;

public class 체육복 {
	public static void main(String[] args) {
		체육복 s = new 체육복();
		int num = 3;
		int num2 = 2;
		int[] arr = { 3 };
		int[] arr2 = { 1 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[][] strs = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		// System.out.println("start");
		s.solution(num, arr, arr2);
		// System.out.println("end");
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		ArrayList<Integer> Alost = new ArrayList<>();
		ArrayList<Integer> Areserve = new ArrayList<>();

		int[] arr = new int[n];

		for (int i = 0; i < reserve.length; i++) {
			arr[reserve[i]-1]++;
		}

		for (int i = 0; i < lost.length; i++) {
			arr[lost[i]-1]--;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				if (i - 1 >= 0 && arr[i - 1] == 1) {
					arr[i]++;
					arr[i - 1]--;
					answer++;
					continue;
				} else if (i + 1 < n && arr[i + 1] == 1) {
					arr[i]++;
					arr[i + 1]--;
					answer++;
					continue;
				}
			} else {
				answer++;
			}
		}

//		int a = 0;
//		int b = 0;
//		for (int i = 0; i < n; i++) {
//			if (a < lost.length && lost[a] == i + 1) {
//				Alost.add(1);
//				a++;
//			} else {
//				Alost.add(0);
//			}
//			if (b < reserve.length && reserve[b] == i + 1) {
//				Areserve.add(1);
//				b++;
//			} else {
//				Areserve.add(0);
//			}
//		}
//
//		for (int i = 0; i < n; i++) {
//			if (Alost.get(i) == 1) {
//				if (Areserve.get(i) == 1) {
//					Alost.set(i, 0);
//					Areserve.set(i, 0);
//					continue;
//				}
//				if (i > 0 && Alost.get(i - 1) == 0 && Areserve.get(i - 1) == 1) {
//					Alost.set(i, 0);
//					Areserve.set(i - 1, 0);
//					continue;
//				}
//				if (i < n && Alost.get(i + 1) == 0 && Areserve.get(i + 1) == 1) {
//					Alost.set(i, 0);
//					Areserve.set(i + 1, 0);
//					continue;
//				}
//			}
//		}
//
//		for (int i = 0; i < Alost.size(); i++) {
//			// System.out.print(Alost.get(i));
//			if (Alost.get(i) == 0) {
//				answer++;
//			}
//		}

		System.out.println(answer);
		return answer;
	}
}
