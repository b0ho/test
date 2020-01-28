package test.java;

import java.util.Arrays;

public class Solution {
    public static void main(String args[]) {
        Solution s = new Solution();
        int n = 6;
        int[] arr_1 = { 46, 33, 33, 22, 31, 50 };
        int[] arr_2 = { 27, 56, 19, 14, 14, 10 };
        s.solution(n, arr_1, arr_2);
    }

    public String[] solution(int num, int[] arr1, int[] arr2) {
        String[] answer = new String[num];

        for (int i = 0; i < num; i++) {
            String tmp = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (true) {
                if (tmp.length() < num) {
                    tmp = "0" + tmp;
                } else {
                    break;
                }
            }
            // System.out.println(tmp);
            answer[i] = "";
            for (int j = 0; j < num; j++) {
                if (tmp.charAt(j) == '1') {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
                // System.out.print(answer[i]);
            }
            // System.out.println(answer[i]);
        }

        return answer;
    }
}