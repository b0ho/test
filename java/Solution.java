package test.java;

import java.util.*;

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

        List<Integer> scoville_arr = new ArrayList<Integer>(scoville.length);
        for (int i : scoville) {
            scoville_arr.add(i);
        }

        while (true) {
            // 섞을수가 없으면 (사이즈 = 1) 종료 : -1
            if (scoville_arr.size() < 2) {
                answer = -1;
                return answer;
            }

            answer = answer + 1;

            // 매번 정렬
            Collections.sort(scoville_arr);

            // 지수 공식
            int tmp = scoville_arr.get(0) + scoville_arr.get(1) * 2;

            // K보다 크거나 같으면 종료 : cnt
            if (tmp >= K) {
                return answer;
            }

            // 1번과 2번 제거, 새 지수 추가
            scoville_arr.remove(0);
            scoville_arr.remove(1);
            scoville_arr.add(tmp);

        }

    }

}
