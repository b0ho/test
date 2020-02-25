
import java.util.Arrays;

//정렬한 뒤 중간부터 시작해서 좌 우로 차례 검사
class H_index {
    public static void main(String args[]) {
        H_index s = new H_index();
        // int[] n = { 3, 0, 6, 1, 5 };
        int[] n = { 2, 7, 5 };
        s.solution(n);
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int h = 0; h < citations[citations.length - 1]; h++) {
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= h && citations.length - i >= h) {
                    answer = h;
                    break;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}
