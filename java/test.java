package test.java;

import java.util.Arrays;

public class test {
    public static void main(String args[]) {
        test s = new test();
        // int[] n = { 3, 0, 6, 1, 5 };
        int[] n = { 2, 7, 5 };
        s.solution(n);
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int h = citations.length - 1; h > -1; h--) {
            System.out.println(h);
            if (citations[h] <= h) {
                answer = h;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }
}