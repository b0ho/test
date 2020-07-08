
public class ttt {
	public static void main(String[] args) {
		ttt s = new ttt();
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
		//System.out.println("start");
		answer = 0;
		num = n;
		long tmp = 1;
		cnt = 0;

		while (tmp < n) {
			tmp = tmp * 3 + 2;
			cnt++;
		}

		// System.out.println(tmp);
		// System.out.println(cnt);
		// calc("**++++*++");

		rec(0, 2, 1, 3);
		//System.out.println(answer);

		//System.out.println("end");
		return answer;
	}

	public String rec(int now, int to, int star, long sum) {
		// System.out.println(s);

		if (sum == num) {
			answer++;
		}

		if (star + now < cnt * 3 && now < to) {

			rec(now + 1, to, star, sum + 1);
			if (star < cnt) {
				rec(now, to + 2, star + 1, sum * 3);
			}
		}

		return "";
	}

	public boolean calc(String s) {
		long tmp = 1;
		boolean chk = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				tmp = tmp * 3;
			}
			if (s.charAt(i) == '+') {
				tmp = tmp + 1;
			}
		}

		if (tmp == num) {
			chk = true;
			// System.out.println(s);
		}

		return chk;
	}

}