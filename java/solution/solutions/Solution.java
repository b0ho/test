package solutions;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int num = 3;
		int num2 = 2;
		int[] nums = { 3 };
		int[] nums2 = { 1 };
		int[][] numss = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "100-200*300-500+20";
		String str2 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[] strs = {"Jane", "Kim" };
		String[][] strss = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println("start");
		수식최대화 수식최대화 = new 수식최대화();
		System.out.println(수식최대화.solution(str));
		System.out.println("end");
	}
}
