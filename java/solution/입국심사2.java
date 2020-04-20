import java.util.Arrays;

public class 입국심사2 {
    public static void main(String[] args) {
        입국심사2 s = new 입국심사2();
        int num = 6;
        int[] arr = { 1, 2, 3 };
        System.out.println("start");
        s.t(num, arr);
        System.out.println("end");
    }

    public long t(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long) times[times.length - 1] * n;
        long answer = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / (long) times[i];
            }
            if (sum == n) {
                answer = mid;
            } else if (sum > n) {
                max = mid;
            } else
                min = mid;
        }
        System.out.println(answer);
        return answer;
    }
}
