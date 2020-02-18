package solution;

import java.util.PriorityQueue;

class Solution {
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        System.out.println(s.solution(scoville, K));
    }

    // 오름차순 정렬 한다.
    // 지수 공식에 대입한다.
    // 위를 반복하다 k이상이 되면 종료하고 cnt 리턴
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovilles = new PriorityQueue<>(scoville.length);
        for (int i : scoville) {
            scovilles.offer(i);
        }

        while (scovilles.peek() <= K) {
            // 섞을수가 없으면 (사이즈 = 1) 종료 : -1
            if (scovilles.size() < 2) {
                answer = -1;
                return answer;
            }

            answer = answer + 1;

            int first = scovilles.poll();
            int second = scovilles.poll();

            // 지수 공식
            int tmp = first + (second * 2);

            scovilles.offer(tmp);

        }
        return answer;
    }

}
