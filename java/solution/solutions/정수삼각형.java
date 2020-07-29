package solutions;

public class 정수삼각형 {
    public static void main(String[] args) {
        정수삼각형 s = new 정수삼각형();
        int num = 4;
        int[] arr = { 120, 110, 140, 150 };
        int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        System.out.println("start");
        s.solution(arrs);
        System.out.println("end");
    }

    public int solution(int[][] triangle) {
        int answer = 0;
        // 위에서 아래부터 해도 될거같은데 굳이? 문제를 2번이나?

        // 맨 아래부터 위로 올라간다
        // 왼쪽과 오른쪽중 큰 녀석을 부모에 더해준다
        // 부모 i = 현재위치 = 자식 -1
        for (int i = triangle.length - 2; i >= 0; i--) {
            // 자식노드는 왼쪽 오른쪽 순서 상관 없음
            for (int j = 0; j < triangle[i].length; j++) {
                // 왼쪽이 더 크면 부모에 왼쪽더하기
                if (triangle[i + 1][j] > triangle[i + 1][j + 1]) {
                    triangle[i][j] += triangle[i + 1][j];
                }
                // 오른쪽이 더 크면 부모에 오른쪽 더하기
                else {
                    triangle[i][j] += triangle[i + 1][j + 1];
                }
            }
        }
        // 더하다보면 루트값에 최종값 = max 생김
        answer = triangle[0][0];
        // System.out.println(answer);
        return answer;
    }
}