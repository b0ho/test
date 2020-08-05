package solutions;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int num = 5000;
		int num2 = 3;
		int[] nums = { 3 };
		int[] nums2 = { 1 };
		int[][] numss = { { 2, 2 } };
		String str = "100-200*300-500+20";
		String str2 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[] strs = { "Jane", "Kim" };
		String[][] strss = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println("start");
		점프와순간이동 점프와순간이동 = new 점프와순간이동();
		System.out.println(점프와순간이동.solution(num));
		System.out.println("end");
	}
}
