package solutions;
import java.util.PriorityQueue;

class 무지의먹방라이브 {
    public static void main(String[] args) {
        무지의먹방라이브 s = new 무지의먹방라이브();
        int num = 1;
        long n = 5;
        int[] arr = { 3, 1, 2 };
        int[][] arrs = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        System.out.println("start");
        s.solution(arr, n);
        System.out.println("end");
    }

    public int solution(int[] food_times, long k) {
        int answer = -1;

        // 배열을 pq에 넣는다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // PQ 는 무조건 정렬 기준을 정해줘야 하는줄 알았는데
            // 기본으로 사용하면 숫자 오름차순이었다,,,
            pq.add(food_times[i]);
        }

        // 효율성을 위한 변태 숫자들을 위해 long사용
        long 현재음식여분 = 0;
        long 이전음식여분 = 0;
        long 바뀐전체여분 = k;

        // 큐가 모두 없어질때까지 반복
        while (pq.size() > 0) {
            // 작은 숫자부터
            현재음식여분 = pq.poll();

            // 여기까지 왔으면 전체양이 큐에서빠진 녀석 만큼 줄어야한다
            // 전체 사이클이 n*m 만큼 줄면서 동시에
            // 새로 큐에서 나온 다음 녀석은 이전 녀석만큼 줄어든 값으로 비교해야한다.
            // 이렇게 하지않고 전체 배열이 1초씩 줄어들면 시간초과!

            // 전체여분은 줄어든 만큼 * 큐의 크기만큼 해주어야 사이클 제거가 된다. = n*m
            // pq에서 이미 하나가 빠졌지만 사이클은 빠지기 전만큼 돌아야하므로 size + 1
            if (바뀐전체여분 >= (현재음식여분 - 이전음식여분) * (pq.size() + 1)) {
                바뀐전체여분 = 바뀐전체여분 - (현재음식여분 - 이전음식여분) * (pq.size() + 1);
                이전음식여분 = 현재음식여분;
            }

            // 더이상 사이클을 소화하지 못하면 종료
            else {
                break;
            }
        }

        // 종료 시점에서는 이미 큐에서 빠진 상태이기 때문에 size + 1
        int 종료조건 = (int) (바뀐전체여분 % (pq.size() + 1));
        int cnt = 0;
        for (int i = 0; i < food_times.length; i++) {
            // 작은값부터 순서대로 정렬되었던 PQ와 다르게
            // 원래 리스트는 크기순이 아님
            // 하지만 큐가 모두 제거된 순간의 가장 작은값 = 이전음식여분
            // 의 값 보다 클때 카운터를 증가시키다보면
            // 크기순을 찾아갈 수가 있다.
            if (food_times[i] > 이전음식여분) {
                cnt++;
            }

            // 그 개수가 종료조건을 충족하면
            // 그 다음 위치가 원본 배열의 시작 위치 == 방송 시작 위치의 인덱스
            if (cnt == 종료조건 + 1) {
                answer = i + 1;
                break;
            }
        }

        // System.out.println(answer);
        // for문이 끝날때까지 종료위치를 못찾았다
        // == 리스트에 남은 음식이 없다 == -1
        return answer;
    }
}