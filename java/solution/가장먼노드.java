package solution;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        int[] len = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        boolean[][] graph = new boolean[n + 1][n + 1];
        Queue<Node> queue = new LinkedList<>();

        // 노드가 존재하는지 검사를 위한 배열
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }

        // 1번노드 1 -> 1 에서 시작
        queue.add(new Node(1, 1));

        // 1번노드는 true
        visited[1] = true;

        while (true) {
            // 큐가 비었으면 종료
            if (queue.isEmpty()) {
                break;
            }

            // 큐에서 하나를 뺴고
            Node node = queue.poll();
            for (int i = 1; i <= n; i++) {
                // 방문할 수 있으면
                if (graph[node.y][i] && visited[i] == false) {
                    System.out.println(node.y + "::" + i);
                    // 노드를 생성하여 큐에 넣고 방문을 표시, 길이 배열에 추가한다.
                    queue.add(new Node(node.y, i));
                    visited[i] = true;
                    len[i] = len[node.y] + 1;
                    System.out.println(len[i]);
                }
            }
        }

        // 가장 긴 길이를 max에 저장
        for (int i = 1; i <= n; i++) {
            if (max < len[i]) {
                max = len[i];
                answer = 0;
            }
        }

        // 길이가 max와 같으면 정답개수 증가
        for (int i = 1; i <= n; i++) {
            if (max == len[i])
                answer++;
        }

        System.out.println(answer);
        return answer;
    }

    // 노드
    public class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

public class 가장먼노드 {

    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] v = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        s.solution(24, v);
    }
}