
public class 입국심사 {
    public static void main(String[] args) {
        입국심사 s = new 입국심사();
        int num = 1000000000;
        int[] arr = { 7, 10 };
        System.out.println("start");
        s.t(num, arr);
        System.out.println("end");
    }

    public long t(int n, int[] times) {
        long answer = 0;
        long[] wait = { 0, 0 };

        if (times[0] > times[1]) {
            int tmp = times[0];
            times[0] = times[1];
            times[1] = tmp;
        }

        while (n > 0) {
            if (wait[0] <= wait[1]) {
                wait[0] += times[0];
            } else if (Math.abs(wait[0] - wait[1]) < times[1] - times[0]) {
                wait[0] += times[0];
            } else {
                wait[1] += times[1];
            }
            n--;
        }

        if (wait[0] > wait[1]) {
            answer = wait[0];
        } else {
            answer = wait[1];
        }
        System.out.println(answer);
        return answer;
    }
}
