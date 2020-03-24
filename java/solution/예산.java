
public class 예산 {
    public static void main(String[] args) {
        예산 s = new 예산();
        int num = 4;
        int[] arr = { 120, 110, 140, 150 };
        System.out.println("start");
        s.a(arr, num);
        System.out.println("end");
    }

    public int a(int[] budgets, int M) {
        int answer = 0;
        int sum = 0;

        for (int i : budgets) {
            sum += i;
            if (answer < i) {
                answer = i;
            }
        }

        if (sum < M) {
            return answer;
        } else {
            int max = answer;
            int min = 0;
            int mid = 0;

            while (min <= max) {
                int tmp = 0;
                mid = (max + min) / 2;

                for (int i : budgets) {
                    if (i >= mid) {
                        tmp += mid;
                    } else {
                        tmp += i;
                    }
                }

                if (tmp > M) {
                    max = mid - 1;
                } else {
                    answer = mid;
                    min = mid + 1;
                }
            }

        }
        return answer;

    }
}