import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {
	public static void main(String[] args) {
		후보키 s = new 후보키();
		int num = 41;
		int num2 = 2;
		int[] arr = { 1, 5, 6, 10 };
		int[] arr2 = { 1, 2, 3, 4 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[][] strs = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		// System.out.println("start");
		s.solution(strs);
		// System.out.println("end");
	}

	public int solution(String[][] relation) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < (1 << relation[0].length); i++) {
			HashSet<String> set = new HashSet<String>();

			for (int j = 0; j < relation.length; j++) {
				String str = "";

				for (int j2 = 0; j2 < relation[0].length; j2++) {
					if ((i & (1 << j2)) > 0) {
						str = str + relation[j][j2];
					}
				}
				set.add(str);

			}
			if ((set.size() == relation.length) && (isCan(list, i) == true)) {
				list.add(i);
			}

		}
		answer = list.size();

		return answer;
	}

	public boolean isCan(ArrayList<Integer> arr, int idx) {
		for (int i = 0; i < arr.size(); i++) {
			if ((arr.get(i) & idx) == arr.get(i)) {
				return false;
			}
		}

		return true;
	}
}
