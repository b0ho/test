<<<<<<< HEAD
package solutions;

import java.util.*;
import javax.script.*;

public class 수식최대화 {
	public long solution(String expression) {
		long answer = 0;

//		 expression 길이가 100이하 이므로 최대 연산 가능 회수가 50 이하로 낮음
//		 연산자가 3개 뿐이므로 우선순위 조합이 6개로 작음
//		 수식은 그대로이고 우선순위만 바뀔 뿐이므로 최대 연산 수는 300 이하로 완전탐색 가능
//		 입력이 예쁘게 정제되어 예외처리에 크게 신경쓸 필요 없음

		// 조합에 따라 수식 완성
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0: {
				Long tmp = Long.parseLong(calc(expression, '-', '+', '*'));
				if (tmp > answer) {
					answer = tmp;
				}
				break;
			}
			case 1: {
				Long tmp = Long.parseLong(calc(expression, '-', '*', '+'));
				if (tmp > answer) {
					answer = tmp;
				}
				break;
			}
			case 2: {
				Long tmp = Long.parseLong(calc(expression, '+', '*', '-'));
				if (tmp > answer) {
					answer = tmp;
				}
				break;
			}
			case 3: {
				Long tmp = Long.parseLong(calc(expression, '+', '-', '*'));
				if (tmp > answer) {
					answer = tmp;
				}
				break;
			}
			case 4: {
				Long tmp = Long.parseLong(calc(expression, '*', '+', '-'));
				if (tmp > answer) {
					answer = tmp;
				}
				break;
			}
			case 5: {
				Long tmp = Long.parseLong(calc(expression, '*', '-', '+'));
				if (tmp > answer) {
					answer = tmp;
				}
				break;
			}
			}
			System.out.println();
		}

		return answer;
	}

	public String calc(String exp, char a, char b, char c) {
		Deque<String> DQ1 = new LinkedList<String>();
		Deque<String> DQ2 = new LinkedList<String>();
		Deque<String> DQ3 = new LinkedList<String>();
		String tmp = "";
		String num = "";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		try {
			// 스택에 숫자와 연산자로 나눠 담는다.
			for (int i = 0; i < exp.length(); i++) {
				if (exp.charAt(i) >= '0') {
					// System.out.print(exp.charAt(i));
					tmp += exp.charAt(i);
				} else {
					// System.out.print(exp.charAt(i));
					DQ1.add(tmp);
					DQ1.add(exp.charAt(i) + "");
					tmp = "";
				}
				if (i == exp.length() - 1) {
					DQ1.add(tmp);
				}
			}
			
//			while (!DQ1.isEmpty()) {
//				System.out.println(DQ1.poll());
//			}

			// 큐가 없어질때까지 연산한다.
			while (!DQ1.isEmpty()) {
				String now1 = DQ1.poll();
				if (DQ1.isEmpty()) {
					DQ2.add(now1);
					break;
				}
				if (DQ1.peek().equals(a + "")) {
					now1 = engine.eval(now1 + DQ1.poll() + DQ1.poll()) + "";
					DQ1.push(now1);
				} else {
					DQ2.add(now1);
					DQ2.add(DQ1.poll());
				}
			}

//			while(!DQ2.isEmpty()) {
//			System.out.println(DQ2.poll());
//		}

			while (!DQ2.isEmpty()) {
				String now2 = DQ2.poll();
				if (DQ2.isEmpty()) {
					DQ3.add(now2);
					break;
				}
				if (DQ2.peek().equals(b + "")) {
					now2 = engine.eval(now2 + DQ2.poll() + DQ2.poll()) + "";
					DQ2.push(now2);
				} else {
					DQ3.add(now2);
					DQ3.add(DQ2.poll());
				}
			}

//			while(!DQ3.isEmpty()) {
//			System.out.println(DQ3.poll());
//		}

			while (!DQ3.isEmpty()) {
				String now3 = DQ3.poll();
				if (DQ3.isEmpty()) {
					DQ3.add(now3);
					break;
				}
				if (DQ3.peek().equals(c + "")) {
					now3 = engine.eval(now3 + DQ3.poll() + DQ3.poll()) + "";
					DQ3.push(now3);
				} else {
					DQ3.add(now3);
					DQ3.add(DQ3.poll());
				}
			}

			num = Math.abs(Long.parseLong(DQ3.pop())) + "";
			System.out.println(num);

		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}
=======
package solutions;

public class 수식최대화 {
	public long solution(String expression) {
		long answer = 0;

		return answer;
	}
}
>>>>>>> branch 'master' of https://github.com/b0ho/test
