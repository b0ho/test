
package solutions;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int num = 3;
		int num2 = 3;
		int[] nums = { 3 };
		int[] nums2 = { 1 };
		int[][] numss = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		int[][] numss2 = { { 1, 1, 1, 1 }, { 1, 200, 1, 1 }, { 1, 500, 1, 1 }, { 1, 200, 1, 1 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String str2 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[] strs = { "Jane", "Kim" };
		String[][] strss = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println("start");
		땅따먹기 땅따먹기 = new 땅따먹기();
		System.out.println(땅따먹기.solution(numss));
		System.out.println("end");
	}
}