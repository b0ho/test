
class 카펫 {
    public static void main(String args[]) {
        카펫 s = new 카펫();

        s.solution(24, 24);
    }

    public int[] solution(int brown, int red) {
        int[] answer = { 0, 0 };
        int red_w;
        int red_h;

        for (int i = 1; i <= red; i++) {
            if (red % i == 0) {
                red_w = red / i;
            } else {
                red_w = red / i + 1;
            }
            red_h = i;

            if (red_w < red_h) {
                continue;
            }

            // System.out.println(i + " " + red_w + " " + red_h);

            if (red_w * 2 + red_h * 2 + 4 == brown) {
                answer[0] = red_w + 2;
                answer[1] = red_h + 2;
                break;
            }
        }

        return answer;
    }
}