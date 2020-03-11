import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class 블록이동하기 {
	public static void main(String[] args) {
		블록이동하기 s = new 블록이동하기();
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println("start");
		s.solution(board);
		System.out.println("end");
	}

	class Node {
		int a_x = 0;
		int a_y = 0;
		int b_x = 0;
		int b_y = 0;
		int dist = 0;

		Node(int a_x, int a_y, int b_x, int b_y, int dist) {
			this.a_x = a_x;
			this.a_y = a_y;
			this.b_x = b_x;
			this.b_y = b_y;
			this.dist = dist;
		}

		Node(int a_x, int a_y, int b_x, int b_y) {
			this.a_x = a_x;
			this.a_y = a_y;
			this.b_x = b_x;
			this.b_y = b_y;
		}

		Node() {

		}
	}

	public int solution(int[][] board) {
		int answer = 0;
		int size = board.length;
		ArrayList<ArrayList<Integer>> new_board = new ArrayList<>();
		ArrayList<Node> visited = new ArrayList<>();
		Deque<Node> deque = new ArrayDeque<Node>();

		for (int i = 0, a = 0; i < size + 2; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j = 0, b = 0; j < size + 2; j++) {
				if (i == 0 || j == 0 || i == size + 1 || j == size + 1) {
					tmp.add(1);
				} else {
					tmp.add(board[a][b]);
					b++;
				}
				System.out.print(tmp.get(j) + " ");
			}
			if (i != 0) {
				a++;
			}
			System.out.println();
			new_board.add(tmp);
		}

		visited.add(new Node(1, 1, 1, 2));
		deque.push(new Node(1, 1, 1, 2, 0));

		while (deque.size() != 0) {

			Node Tnode = deque.poll();
			answer = Tnode.dist + 1;

			
			for (Node n : move(Tnode, new_board)) {
				if ((n.a_x == size && n.a_y == size) || (n.b_x == size && n.b_y == size)) {
					return answer;
				}

				if (!visited.contains(n)) {
					visited.add(n);
					deque.push(new Node(n.a_x, n.a_y, n.b_x, n.b_y, answer));
				}
			}
		}

		return 0;
	}

	public ArrayList<Node> move(Node node, ArrayList<ArrayList<Integer>> board) {
		int[][] straight = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int[] rotate = { 1, -1 };
		ArrayList<Node> Alist = new ArrayList<Node>();

		for (int[] s : straight) {
			if (board.get(node.a_x + s[0]).get(node.a_y + s[1]) == 0
					&& board.get(node.b_x + s[0]).get(node.b_y + s[1]) == 0) {
				Alist.add(new Node(node.a_x + s[0], node.a_y + s[1], node.b_x + s[0], node.b_y + s[1]));
			}
		}

		if (node.a_x == node.b_x) {
			for (int r : rotate) {
				if (board.get(node.a_x + r).get(node.a_y) == 0 && board.get(node.b_x + r).get(node.b_y) == 0) {
					Alist.add(new Node(node.a_x + r, node.a_y, node.a_x, node.a_y));
					Alist.add(new Node(node.b_x + r, node.b_y, node.b_x, node.b_y));
				}
			}
		} else {
			for (int r : rotate) {
				if (board.get(node.a_x).get(node.a_y + r) == 0 && board.get(node.b_x).get(node.b_y + r) == 0) {
					Alist.add(new Node(node.a_x, node.a_y, node.a_x, node.a_y + r));
					Alist.add(new Node(node.b_x, node.b_y, node.b_x, node.b_y + r));
				}
			}
		}

		return Alist;
	}
}
