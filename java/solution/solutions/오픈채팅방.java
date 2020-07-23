package solutions;
import java.util.HashMap;

public class 오픈채팅방 {
	public static void main(String[] args) {
		오픈채팅방 s = new 오픈채팅방();
		int num = 12;
		int num2 = 2;
		int[] arr = { 1, 5, 6, 10 };
		int[] arr2 = { 1, 2, 3, 4 };
		int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		String str = "abcabcabcabcdededededede";
		String[] strs = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		// System.out.println("start");
		s.solution(strs);
		// System.out.println("end");
	}

	// 상태변화에 대한 처리와 메시지 출력에 대한 처리를 따로 해주기
	// 해시맵 사용법
	public String[] solution(String[] record) {
		// 고유번호를 가지고 내용이 바뀌므로 킹시맵
		HashMap<String, String> 킹시맵 = new HashMap<String, String>();
		// 자바는 객체의 크기를 선언해주어야 하는데
		// change 일때를 제외한 메시지 개수는 모르므로,, 나중을 위한 카운터
		int inout = 0;

		// foreach 문 idx 값이 필요 없어서 사용
		//
		for (String 메시지 : record) {
			// 메시지내용들[0] : 조건
			// 메시지내용들[1] : ID
			// 메시지내용들[2] : 닉네임
			String[] 메시지내용들 = 메시지.split(" ");
			if (메시지내용들[0].equals("Enter")) {
				// 입장인 경우 이전에 이미 내역이 있으면 해시맵에 닉네임 교체
				if (킹시맵.containsKey(메시지내용들[1])) {
					킹시맵.replace(메시지내용들[1], 메시지내용들[2]);
				}
				// 내역 없으면 해시맵에 ID와 닉네임 추가
				else {
					킹시맵.put(메시지내용들[1], 메시지내용들[2]);
				}
				inout++;
			}
			// 입장인 경우와 마찬가지로 해시맵에 닉네임 교체
			else if (메시지내용들[0].equals("Change")) {
				킹시맵.replace(메시지내용들[1], 메시지내용들[2]);
			}
			// Leave 인 경우는 정답을 위한 카운터만 증가
			else {
				inout++;
			}
		}

		String[] answer = new String[inout];
		int cnt = 0;

		// 들어올때와 나올때의 스트링을 만들어 정답 배열에 추가
		// 일반 for 문 써도 되는데 이미 잘 돌아가니까 굳이?
		for (String 메시지 : record) {
			String[] 메시지내용들 = 메시지.split(" ");
			if (메시지내용들[0].equals("Enter")) {
				answer[cnt] = 킹시맵.get(메시지내용들[1]) + "님이 들어왔습니다.";
				cnt++;
			} else if (메시지내용들[0].equals("Leave")) {
				answer[cnt] = 킹시맵.get(메시지내용들[1]) + "님이 나갔습니다.";
				cnt++;
			}
		}

		return answer;
	}
}