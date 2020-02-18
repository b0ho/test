package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//dfs와 bfs의 차이는 이미 방문한 곳을 만났을때
//이어서 진행하느냐(dfs), 처음으로 돌아가느냐(bfs) 차이
class Main {
    static int map[][];
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);

        sc.close();
    }

    private static void dfs(int now) {
        System.out.print(now + " ");
        visit[now] = true;
        for (int next = 1; next < visit.length; next++) {
            if (map[now][next] == 1 && visit[next] == false) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            System.out.print(now + " ");

            for (int next = 1; next < visit.length; next++) {
                if (map[now][next] == 1 && visit[next] == false) {
                    que.offer(next);
                    visit[next] = true;
                }
            }
        }
    }
}