package solutions;
import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
    public static void main(String[] args) {
        여행경로 s = new 여행경로();
        int num = 4;
        int num2 = 2;
        int[] arr = { 3, 2, 5 };
        int[] arr2 = { 2, 4, 1 };
        int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        String[][] arrs_str = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                { "ATL", "SFO" } };
        System.out.println("start");
        s.solution(arrs_str);

        System.out.println("end");
    }

    public static ArrayList<String> str;

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        // 문자열 정렬을 편하게 하기 위해 스트링 ArrayList 사용
        str = new ArrayList<>();

        // 시작은 인천이라는 뜻
        dfs("", "ICN", 0, visited, tickets);

        // 후보들을 정렬시킴
        Collections.sort(str);

        // 가장 첫번째가 알파벳 순이므로 정답
        String[] answer = str.get(0).split(":");

        return answer;
    }

    // 재귀로 검사
    public static void dfs(String tmp, String to, int cnt, boolean[] visit, String[][] tic) {
        // 후보문자열 = 현재문자열 + 방문할 곳
        // 구분기호 추가하여 나중에 분리하여 정답에 담을 예정
        tmp += to + ":";

        // 모든 항공편수만큼 돌았으면 문자열 저장
        if (cnt == tic.length) {
            // 후보들을 모두 저장
            str.add(tmp);
        }

        // 이제 수많은 파생 재귀들이 생길 예정
        for (int i = 0; i < tic.length; i++) {
            // 방문할 곳이 시작점이고 방문하지 않았으면
            if (tic[i][0].equals(to) && visit[i] == false) {
                // 방문 중 시작
                visit[i] = true;

                // 목적지 설정 및 카운터 증가 후 재귀
                dfs(tmp, tic[i][1], cnt + 1, visit, tic);

                // 방문 종료
                visit[i] = false;
            }
        }
    }
}
