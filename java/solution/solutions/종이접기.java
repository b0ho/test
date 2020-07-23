package solutions;
import java.util.Arrays;

class 종이접기 {
    public static void main(String[] args) {
        종이접기 s = new 종이접기();
        int num = 4;
        int[] arr = { 120, 110, 140, 150 };
        int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        System.out.println("start");
        s.solution(num);
        System.out.println("end");
    }

    public int[] solution(int n) {
        // 스트링빌더를 쓴다. 일반 스트링 배열 사용시 시간초과
        // 스트링빌더는 String 클래스와 다르게 내부적으로
        // 불필요한 함수들이 추가적으로 생성되지 않고
        // 동일 주소값에 append되는 방식이라서 훨씬 빠르다.
        // 아래는 선언과 동시에 초기화
        // 0으로 초기화하여 n = 1 인 경우를 포함한다.
        StringBuilder tmp = new StringBuilder("0");

        // for (int i = 1; i < n; i++) {
        // System.out.println("tmp : " + tmp);
        // Long n1 = Long.parseLong(tmp);
        // System.out.println("n1 : " + n1);
        // String x = "1";
        // int p = tmp.length() - (int) (Math.log10(n1) + 1);
        // System.out.println("p : " + p);

        // for (int j = 0; j < tmp.length(); j++) {
        // x += "1";
        // }
        // n1 = n1 ^ Long.parseLong(x);
        // System.out.println("n1 : " + n1);

        // String tmp2 = Long.toString(n1);
        // p = tmp.length() - tmp2.length();
        // for (int j = 0; j < p; j++) {
        // tmp2 = "1" + tmp2;
        // }
        // String tmp3 = "";
        // for (int j = 0; j < tmp2.length(); j++) {
        // tmp3 = tmp3 + tmp2.charAt(tmp2.length() - j - 1);
        // }
        // System.out.println("tmp2 : " + tmp2);
        // System.out.println("tmp3 : " + tmp3);
        // tmp = tmp + "0" + tmp3;
        // System.out.println("tmp : " + tmp);
        // System.out.println();
        // }

        // 1일때는 0이므로 2부터 n까지
        for (int i = 2; i <= n; i++) {
            // 데이터의 비교를 위한 것으로 n번 생성된다.
            // 값이 변하지 않으므로 String을 사용하여도 무관
            String tmp2 = tmp.toString();

            // 종이접기 규칙 : 한가운데 0 을 기준으로
            // 우측은 좌측의 xor 데칼코마니이다.
            // 따라서 기존 문자열에 기준 0 추가 후
            tmp.append(0);
            // 0일때와 1일때 분류하여 xor 데칼코마니 생성
            for (int j = tmp2.length() - 1; j >= 0; j--) {
                if (tmp2.charAt(j) == '0') {
                    tmp.append(1);
                } else {
                    tmp.append(0);
                }
            }
        }

        // answer의 크기를 알 수 없으므로 tmp 완료 후 선언
        int[] answer = new int[tmp.length()];
        // tmp를 answer 배열에 넣어준다.
        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = tmp.charAt(i) - 48;
            // System.out.println(tmp.charAt(i));
        }
        return answer;
    }

}