package solutions;

public class 주식가격 {
	public static void main(String[] args) {
		주식가격 s = new 주식가격();
		int num = 5;
		int num2 = 2;
		int[] arr = { 1, 2, 3, 2, 3 };
		int[] arr2 = { 1, 3, 5 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[][] strs = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		// System.out.println("start");
		s.solution(arr);
		// System.out.println("end");
	}

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < answer.length; i++) {
			for (int j = i + 1; j < answer.length; j++) {
                answer[i]++;
				if (prices[i] > prices[j]){
                    break;
                }
			}
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		return answer;
	}
}
