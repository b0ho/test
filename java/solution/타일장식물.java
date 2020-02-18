package solution;

class 타일장식물 {

    public static void main(String args[]) {
        타일장식물 s = new 타일장식물();
        int n = 8;
        s.solution(n);
    }

    public long solution(int N) {
        long answer = 0;
        long[] fibo = new long[N + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        // 피보나치로 다음값을 찾고
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            System.out.println(fibo[i]);
        }

        // 둘레 수식을 완성
        answer = fibo[N] * 4 + fibo[N - 1] * 2;

        System.out.println(answer);
        return answer;
    }
}
