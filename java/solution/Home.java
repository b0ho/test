
public class Home {
	public static void main(String[] args) {
		Home s = new Home();
		int num = 4;
		int num2 = 1;
		int[] num_arr = { 120, 110, 140, 150 };
		String str = "";
		String str2 = "";
		String[] str_arr = {"",""};
		System.out.println("start");
		s.solution(str);
		System.out.println("end");
	}
	
	int a;
	int b;

	public String solution(String p) {
		String answer = "";
		for (int i = 0; i < 10; i++) {
			answer = "" + i;
			b += i;
			System.out.println(i);
			a += i;
		}

		return answer;
	}
}
