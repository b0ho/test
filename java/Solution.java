import java.util.*;

class Solution {
    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] num = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
        s.solution(num);
    }

    int id;

    // 노드 객체 생성
    // 노드를 통해 이진트리 생성
    // 생성된 이진트리 전위, 후위 탐색
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];

        // 노드들은 y가 큰게 먼저 같으면 x가 작은게 먼저 순서
        PriorityQueue<Node> Pqueue = new PriorityQueue<>((q1, q2) -> {
            if (q1.y == q2.y) {
                return q1.x - q2.x;
            }
            return q2.y - q1.y;
        });

        // x, y좌표를 노드로 변환
        for (int i = 0; i < nodeinfo.length; i++) {
            Pqueue.offer(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        // 정렬하여 이진트리 완성
        Node root = Pqueue.poll();
        while (!Pqueue.isEmpty()) {
            Node parentNode = null;
            Node node = root;
            Node childNode = Pqueue.poll();
            while (node != null) {
                if (childNode.x < node.x) {
                    parentNode = node;
                    node = node.left;
                } else {
                    parentNode = node;
                    node = node.right;
                }
            }
            if (parentNode.x > childNode.x) {
                if (parentNode != null) {
                    parentNode.left = childNode;
                }
            } else {
                if (parentNode != null) {
                    parentNode.right = childNode;
                }
            }
        }

        // 전위순회
        id = 0;
        int[] preArray = new int[nodeinfo.length];
        preOrder(root, preArray);
        answer[0] = preArray;

        // 후위순회
        id = 0;
        int[] postArray = new int[nodeinfo.length];
        postOrder(root, postArray);
        answer[1] = postArray;

        return answer;
    }

    // Node 객체
    public class Node {
        int id;
        int x;
        int y;
        Node left;
        Node right;

        // 노드 생성시 아이디와 x, y 값 필요
        // left, right 노드와 비교하여 삽입 위치를 찾아줘야함,
        public Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            left = null;
            right = null;
        }
    }

    // 전위 탐색 : 노드, 왼쪽, 오른쪽
    public void preOrder(Node node, int[] preArray) {
        if (node == null) {
            return;
        }
        preArray[id++] = node.id;
        preOrder(node.left, preArray);
        preOrder(node.right, preArray);
    }

    // 후위탐색 : 왼쪽, 오른쪽, 노드
    public void postOrder(Node node, int[] postArray) {
        if (node == null) {
            return;
        }
        postOrder(node.left, postArray);
        postOrder(node.right, postArray);
        postArray[id++] = node.id;
    }
}
