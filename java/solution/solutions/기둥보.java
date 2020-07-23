package solutions;
import java.util.*;

public class 기둥보 {
	public static void main(String[] args) {
		기둥보 s = new 기둥보();
		int num = 5;
		int num2 = 2;
		int[] arr = { 2, 4 };
		int[] arr2 = { 1, 3, 5 };
		int[][] arrs = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 },
				{ 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[][] strs = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		// System.out.println("start");
		s.solution(num, arrs);
		// System.out.println("end");
	}

	static ArrayList<Frame> list;
	static int len;
	static final int pillar = 0;
	static final int board = 1;
	static final int build = 1;
	static final int remove = 0;

	public int[][] solution(int n, int[][] build_frame) {
		list = new ArrayList<>();
		for (int[] build_arr : build_frame) {
			Frame frame = new Frame(build_arr[0], build_arr[1], build_arr[2]);
			int build_state = build_arr[3];
			if (build_state == build) {
				list.add(frame);
				if (check(list))
					continue;
				list.remove(list.size() - 1);
			} else {
				list.remove(frame);
				if (check(list))
					continue;
				list.add(frame);
			}
		}

		Collections.sort(list, new Comparator<Frame>() {
			public int compare(Frame o1, Frame o2) {
				if (o1.x < o2.x)
					return -1;
				else if (o1.x == o2.x) {
					if (o1.y < o2.y)
						return -1;
					else if (o1.y == o2.y) {
						if (o1.type < o2.type)
							return -1;
						else
							return 1;
					}
				}
				return 1;
			}
		});

		int[][] answer = new int[list.size()][3];

		for (int i = 0; i < list.size(); i++) {
			Frame f = list.get(i);
			answer[i][0] = f.x;
			answer[i][1] = f.y;
			answer[i][2] = f.type;
		}

		return answer;
	}

	static boolean check(ArrayList<Frame> list) {
		for (Frame frame : list) {
			switch (frame.type) {
			case pillar:
				if (frame.y == 0 || list.contains(new Frame(frame.x - 1, frame.y, 1))
						|| list.contains(new Frame(frame.x, frame.y, 1))
						|| list.contains(new Frame(frame.x, frame.y - 1, 0)))
					continue;
				else
					return false;
			case board:
				if (list.contains(new Frame(frame.x, frame.y - 1, 0))
						|| list.contains(new Frame(frame.x + 1, frame.y - 1, 0))
						|| (list.contains(new Frame(frame.x - 1, frame.y, 1))
								&& list.contains(new Frame(frame.x + 1, frame.y, 1))))
					continue;
				else
					return false;
			}
		}
		return true;
	}

	static class Frame {
		int x;
		int y;
		int type;

		public Frame(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Frame other = (Frame) obj;
			if (x != other.x || y != other.y || type != other.type) {
				return false;
			}

			return true;
		}
	}

}
