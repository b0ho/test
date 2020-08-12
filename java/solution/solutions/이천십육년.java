package solutions;

import java.sql.Date;
import java.util.Calendar;

public class 이천십육년 {
	public String solution(int a, int b) {
		String answer = "";
		Date n = new Date(116, a - 1, b);

		Calendar c = Calendar.getInstance();
		c.setTime(n);

		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			answer = "SUN";
			break;
		case 2:
			answer = "MON";
			break;
		case 3:
			answer = "TUE";
			break;
		case 4:
			answer = "WED";
			break;
		case 5:
			answer = "THU";
			break;
		case 6:
			answer = "FRI";
			break;
		case 7:
			answer = "SAT";
			break;
		}

		return answer;

	}
}
