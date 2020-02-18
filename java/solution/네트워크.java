package solution;

//정렬한 뒤 중간부터 시작해서 좌 우로 차례 검사
class Solution {
    static int[] visited;
    static int[][] computers;
    static int n;

    public static void main(String args[]) {
        Solution s = new Solution();
        n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        s.solution(n, computers);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        Solution.computers = computers;
        Solution.n = n;

        for (int i = 0; i < n; i++) {
            // System.out.println("대순환");
            if (visited[i] == 0) {
                answer++;
                rec(i);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public void rec(int i) {
        if (visited[i] == 1) {
            return;
        }
        visited[i] = 1;

        for (int j = 0; j < n; j++) {
            // System.out.println(i + " " + j + " " + computers[i][j]);
            if (j != i && computers[i][j] == 1) {
                // System.out.println("소순환");
                rec(j);
            }
        }
    }

}
