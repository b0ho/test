package solution;

public class 탑 {
    public static void main(String args[]) {
        탑 s = new 탑();
        int[] n = { 6, 9, 5, 7, 4 };
        s.solution(n);
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;

        for (int i = 1; i < heights.length; i++) {
            for (int j = i; j > -1; j--) {
                // System.out.println(i + " " + j + " " + heights[i] + " " + heights[j]);
                if (heights[i] < heights[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}