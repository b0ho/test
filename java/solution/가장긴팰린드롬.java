class 가장긴팰린드롬 {
    public static void main(String[] args) {
        가장긴팰린드롬 s = new 가장긴팰린드롬();
        int num = 1;
        long n = 5;
        String str = "abacde";
        int[] arr = { 3, 1, 2 };
        int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        System.out.println("start");
        s.solution(str);
        System.out.println("end");
    }

    public int solution(String s) {
        // 2500이하의 자연수, 0은 자연수인가,,
        // 하지만 어찌됬든 문자열이 입력이있으므로 최소한 1일것
        int answer = 1;

        // 전체 문자열 길이부터 1씩 감소해가며 팰린드롬 탐색
        for (int i = s.length(); i > 0; i--) {
            // i의 길이 에서 부분문자열 전체 탐색
            // 부분 문자열은 앞에서 탐색과 뒤에서 탐색의 차이를 알수없음
            for (int j = 0; j < s.length() - i + 1; j++) {
                // reverse하여 문자열 비교하기 위해 부분문자열 생성
                StringBuffer bs = new StringBuffer(s.substring(j, j + i));

                // System.out.println(bstmp);
                // System.out.println(bstmp.reverse());

                // 스트링버퍼로 그냥 비교하면 잘 안된다,,
                // 스트링버퍼의 equals는 재정의가 안되었다는듯,,
                // 그런데 reverse 속도가 안나옴
                if (bs.toString().equals(bs.reverse().toString())) {
                    // System.out.println(i);

                    // 가장 긴 숫자만 찾으면 됨
                    // 따라서 모든 경우 중 하나라도 찾으면 종료
                    // 그때의 팰린드롬 사이즈 반환
                    return i;
                }
            }
        }

        return answer;
    }
}
