package solutions;

public class 사단고음 {
	public static void main(String[] args) {
		사단고음 s = new 사단고음();
		int num = 41;
		int num2 = 2;
		int[] arr = { 1, 5, 6, 10 };
		int[] arr2 = { 1, 2, 3, 4 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		// System.out.println("start");
		s.solution(num);
		// System.out.println("end");
	}

	long cnt;
	int answer;
	int num;

	public int solution(int n) {
		System.out.println("start");
		answer = 0;
		num = n;
		long tmp = 1;
		cnt = 0;
		// StringBuilder test = new StringBuilder("**++++*++");
		StringBuilder sb = new StringBuilder("*");

		while (tmp < n) {
			tmp = tmp * 3 + 2;
			cnt++;
		}

		// System.out.println(tmp);
		// System.out.println(cnt);
		// calc(test);

		rec(sb, 0, 2, 1);
		System.out.println(answer);

		System.out.println("end");
		return answer;
	}

	public String rec(StringBuilder s, int now, int to, int star) {
		//System.out.println(newsb);

		if (star == cnt) {
			if (calc(s) == true) {
				answer++;
			}
		} else if (star > cnt) {
			return "";
		}

		if (s.length() < cnt * 3 && now < to) {
			rec(new StringBuilder(s).append('+'), now + 1, to, star);
			if (star < cnt) {
				rec(new StringBuilder(s).append('*'), now, to + 2, star + 1);
			}
		}

		return "";
	}

	public boolean calc(StringBuilder s) {
		long tmp = 1;
		boolean chk = false;

		for (int i = 0; i < s.length(); i++) {
			//System.out.print(s.charAt(i));
			if (s.charAt(i) == '*') {
				tmp = tmp * 3;
			}
			if (s.charAt(i) == '+') {
				tmp = tmp + 1;
			}
			// System.out.println(tmp);
		}

		if (tmp == num) {
			chk = true;
			//System.out.println("!!");
		}
		//System.out.println();
		return chk;
	}

}
