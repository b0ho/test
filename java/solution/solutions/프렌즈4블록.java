package solutions;
import java.util.ArrayList;
import java.util.Arrays;

public class 프렌즈4블록 {
    public static void main(String[] args) {
        프렌즈4블록 s = new 프렌즈4블록();
        int num = 4;
        int num2 = 5;
        String[] arr = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
        System.out.println("start");
        s.st(num, num2, arr);
        System.out.println("end");
    }

    public int st(int m, int n, String[] board) {
        int answer = 0;
        boolean flag = true;
        boolean[][] visit;
        ArrayList<ArrayList<String>> Cboard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            ArrayList<String> Sboard = new ArrayList<>(Arrays.asList(board[i].split("")));
            Cboard.add(Sboard);
        }

        while (flag == true) {
            flag = false;
            visit = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (Cboard.get(i).get(j).equals("")) {
                        continue;
                    }
                    if (Cboard.get(i).get(j).equals(Cboard.get(i).get(j + 1))
                            && Cboard.get(i).get(j).equals(Cboard.get(i + 1).get(j))
                            && Cboard.get(i).get(j).equals(Cboard.get(i + 1).get(j + 1))) {
                        visit[i][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j] = true;
                        visit[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j] == true) {
                        answer++;
                        for (int j2 = i - 1; j2 > -1; j2--) {
                            Cboard.get(j2 + 1).set(j, Cboard.get(j2).get(j));
                            Cboard.get(j2).set(j, "");
                        }
                    }
                }
            }
        }

        System.out.println(answer);

        return answer;

    }
}