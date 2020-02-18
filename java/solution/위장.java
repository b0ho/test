package solution;

//재귀로하면 오래걸림,,
//import java.util.ArrayList;
import java.util.HashMap;

class 위장 {
    static int answer;

    public static void main(String args[]) {
        위장 s = new 위장();
        String[][] c = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                { "green_turban", "headgear" } };
        s.solution(c);
        System.out.println(answer);
    }

    public int solution(String[][] clothes) {
        answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        for (Integer i : map.values()) {
            answer *= i + 1;
        }
        return answer - 1;
    }

    // public static void rec(String[][] clothes, int cnt, ArrayList<String> arr,
    // int len) {
    // if (cnt < clothes.length) {
    // if (!arr.contains(clothes[cnt][1])) {
    // arr.add(clothes[cnt][1]);
    // answer++;
    // }
    // } else {
    // arr.clear();
    // cnt = 0;
    // }

    // if (len < clothes.length * clothes[0].length) {
    // rec(clothes, cnt + 1, arr, len + 1);
    // }
    // }

}
