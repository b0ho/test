package solutions;

import java.util.ArrayList;

public class 폰켓몬 {
	public static void main(String[] args) {
        폰켓몬 s = new 폰켓몬();
        int[] n = { 6, 9, 5, 7, 4 };
        s.solution(n);
	}

	public int solution(int[] nums) {
		int answer = 0;
		ArrayList<Integer> candy = new ArrayList<Integer>();

		for (int i = 1; i < nums.length; i++) {
			if (!candy.contains(nums[i])) {
				candy.add(nums[i]);
			}
		}

		if (candy.size() > nums.length / 2) {
			answer = nums.length / 2;
		} else {
			answer = candy.size();
		}

		return answer;

	}
}
