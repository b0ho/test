
public class 멀쩡한사각형 {
	public static void main(String[] args) {
		멀쩡한사각형 s = new 멀쩡한사각형();
		int num = 8;
		int num2 = 12;
		int[] arr = { 3, 2, 5 };
		int[] arr2 = { 2, 4, 1 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "abcabcabcabcdededededede";
		// System.out.println("start");
		s.solution(num, num2);
		// System.out.println("end");
	}

	public long solution(int w, int h) {
		long answer = 1;
		long gcd = 1;
		long Lw = w;
		long Lh = h;

		while (h != 0) {
			int tmp = w % h;
			w = h;
			h = tmp;
			if (h == 0) {
				gcd = Math.abs(w);
			}
		}
		System.out.println(gcd);
		
		answer = Lw * Lh - (Lw + Lh - gcd);

		System.out.println(answer);
		return answer;
	}
}
