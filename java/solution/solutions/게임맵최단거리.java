package solutions;

import java.util.*;

public class 게임맵최단거리 {

	public static void main(String args[]) {
		게임맵최단거리 s = new 게임맵최단거리();
		int[][] v = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } };
		s.solution(v);
	}

	public int solution(int[][] maps) {
		// 카운터 보다는 깊이에 가까움
		int answer = 0;

		// 연결형 큐로 좌표 저장
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));

		// 큐가 다 빌때까지 반복
		while (!q.isEmpty()) {
			// 가장 먼저온 녀석의 좌표 사용
			Point now_p = q.poll();
			int now_x = now_p.x;
			int now_y = now_p.y;
			// 카운터는 해당 좌표의 깊이
			// maps 좌표상의 값은 계속 바뀜
			answer = maps[now_x][now_y];

			// 적지점에 도착하면 종료
			if (now_x == maps.length - 1 && now_y == maps[0].length - 1) {
				return answer;
			}

			// 상, 하, 좌, 우 이동을 위해
			// 이동가능한지 체크, 벽이 아닌지 체크
			// 이동된 경우 큐에 넣고
			// maps 상의 해당 좌표에 +1
			if (now_x - 1 >= 0 && maps[now_x - 1][now_y] == 1) {
				q.add(new Point((now_x - 1), now_y));
				maps[now_x - 1][now_y] = answer + 1;
			}
			if (now_y - 1 >= 0 && maps[now_x][now_y - 1] == 1) {
				q.add(new Point((now_x), now_y - 1));
				maps[now_x][now_y - 1] = answer + 1;
			}
			if (now_x + 1 <= maps.length - 1 && maps[now_x + 1][now_y] == 1) {
				q.add(new Point((now_x + 1), now_y));
				maps[now_x + 1][now_y] = answer + 1;
			}
			if (now_y + 1 <= maps[0].length - 1 && maps[now_x][now_y + 1] == 1) {
				q.add(new Point((now_x), now_y + 1));
				maps[now_x][now_y + 1] = answer + 1;
			}

		}

		// 도착하지못했는데 반복문 종료시 -1,,
		// 도착못하는 경우
		return -1;
	}
}

// 좌표 표현을 위한 클래스
class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
