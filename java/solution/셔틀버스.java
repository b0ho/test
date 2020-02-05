package test.java.solution;

import java.util.Collections;
import java.util.Vector;

class 셔틀버스 {
    public static void main(String args[]) {
        셔틀버스 s = new 셔틀버스();
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = { "08:00", "08:01", "08:02", "08:03" };
        s.solution(n, t, m, timetable);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        // 벡터를 쓰면 크기가 가변하여 용이함
        Vector<Integer> waitTable = new Vector<Integer>();
        Vector<Integer> busTable = new Vector<Integer>();
        int conTime = 0;

        // 스트링 시간을 분단위로 변환
        for (int i = 0; i < timetable.length; i++) {
            String tmp = timetable[i];
            waitTable.add(Integer.parseInt(tmp.substring(0, 2)) * 60 + Integer.parseInt(tmp.substring(3, 5)));
            // System.out.println(waitTable);
        }
        Collections.sort(waitTable);

        // 버스 출발 시간표
        for (int i = 0; i < n; i++) {
            busTable.add(540 + t * i);
        }

        // 가능한 경우 대기자 제거
        if (n > 1) {
            for (int i = 0; i < busTable.size() - 1; i++) {
                for (int j = 0; j < m; j++) {
                    if (waitTable.size() != 0 && busTable.get(i) >= waitTable.get(0)) {
                        waitTable.remove(0);
                        // System.out.println(waitTable.toString());
                    }
                }
            }
        }

        // 탑승가능인원수보다 남은 대기자가 더 많으면 막차 못탐
        if (m <= waitTable.size()) {
            for (int i = 0; i < m; i++) {
                // 대기자가 얼마나 일찍 와있나,,
                if (busTable.get(busTable.size() - 1) >= waitTable.get(0)) {
                    // 먼저 태울수 있으면, 다시 대기자를 제거
                    if (i < m - 1) {
                        waitTable.remove(0);
                    } else {
                        // 다 지웠으면 마지막 대기자보다는 1분빨리 나감
                        conTime = waitTable.get(0) - 1;
                        break;
                    }

                    // 막차보다 늦게오면 막차 탈수있음
                } else {
                    conTime = busTable.get(busTable.size() - 1);
                    break;
                }
            }
        } else {
            // 막차 탈 수 있으면 막차탐
            conTime = busTable.get(busTable.size() - 1);
        }

        // 다시 스트링으로 변환
        if (conTime / 60 < 10) {
            answer += "0" + conTime / 60 + ":";
        } else {
            answer += conTime / 60 + ":";
        }
        if (conTime % 60 < 10) {
            answer += "0" + conTime % 60;
        } else {
            answer += conTime % 60;
        }

        // System.out.println(answer);
        return answer;
    }
}