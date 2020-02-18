package solution;

class 큰수만들기 {
    public static void main(String args[]) {
        큰수만들기 s = new 큰수만들기();
        String number = "1231234";
        int k = 3;
        System.out.println(s.solution(number, k));
    }

    // public String answer;
    // public ArrayList<Character[]> result;
    // public Character[] res;
    // int max = 0;

    // 뺄것을 찾는게 아니라
    // 시작할 수 있는 가장 큰 수를 찾기
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int max = 0;
        int len = number.length();
        int how = len - k;
        int now = 0;

        for (int i = 0; i < how; i++) {
            max = 0;
            for (int j = now; j < k + i + 1; j++) {
                if (max < number.charAt(j) - 48) {
                    max = number.charAt(j) - 48;
                    now = j + 1;
                }

            }
            answer.append(max);
        }
        System.out.println(answer);

        // char[] num_arr = number.toCharArray();
        // int len = num_arr.length;
        // int how = len - k;
        // ArrayList<Character> item = new ArrayList<Character>();
        // result = new ArrayList<Character[]>();
        // res = new Character[how];
        // for (int i = 0; i < num_arr.length; i++) {
        // item.add(num_arr[i]);
        // }

        // p(item, 0, len, how);

        return answer.toString();
    }

    // public void p(ArrayList<Character> item, int now, int len, int how) {
    // if (now == how) {

    // String tmp = "";
    // for (int i = 0; i < how; i++) {
    // tmp += res[i];
    // }

    // int num = Integer.parseInt(tmp);
    // if (num > max) {
    // max = num;
    // answer = "" + num;
    // }
    // return;
    // }
    // for (int i = 0; i < len - now; i++) {
    // res[now] = item.remove(i);
    // p(item, now + 1, len, how);
    // item.add(i, res[now]);
    // }
    // }
}
