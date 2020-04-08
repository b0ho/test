import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드게임 {
    public static void main(String[] args) {
        카드게임 s = new 카드게임();
        int num = 4;
        int num2 = 2;
        int[] arr = { 3, 2, 5 };
        int[] arr2 = { 2, 4, 1 };
        int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        System.out.println("start");
        s.solution(arr, arr2);
        System.out.println("end");
    }

    public int solution(int[] left, int[] right) {
        int answer = 0;
        int[][] dp = new int[left.length + 1][right.length + 1];

        // -1로 dp 초기화
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }

        // 시작하기 위해서 초기값은 0
        dp[0][0] = 0;
        // 검사해야할 곳 (왼쪽 버리기, 둘다버리기, 오른쪽버리기)이
        // 현재보다 작으면 (max가 아니면) 현재값을 넘기고
        // 오른쪽을 버릴때만 현재값에 오른쪽값을 더하여 넘김
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {

                // 전에 해당한적이 없는 경우
                if (dp[i][j] == -1) {
                    continue;
                }

                // 오른쪽이 버려지는 경우
                if (right[j] < left[i]) {
                    dp[i][j + 1] = dp[i][j] + right[j];
                }

                // 둘다 버려지는 경우
                if (dp[i + 1][j + 1] < dp[i][j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                // 왼쪽이 버려지는 경우
                if (dp[i + 1][j] < dp[i][j]) {
                    dp[i + 1][j] = dp[i][j];
                }
            }

            // 각 수행의 끝 값이 최대값인지 검사
            if (answer < dp[i][left.length]) {
                answer = dp[i][left.length];
            }

        }

        return answer;
    }
}