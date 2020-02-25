
//모든 경우의 수식을 완성할 필요가 없음
//수식 완성해보기
class 타겟넘버 {
    static int answer;
    static int[][] arr = new int[100][5];
    static int cnt = 0;
    static int f = 0;

    public static void main(String args[]) {
        타겟넘버 s = new 타겟넘버();
        int[] n = { 1, 1, 1, 1, 1 };
        int t = 3;
        s.solution(n, t);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        rec(numbers, target, 0, 0, 0);
        System.out.println(answer);
        return answer;
    }

    public static void rec(int[] numbers, int target, int sum, int num, int tmp) {
        if (num == numbers.length) {
            if (sum == target) {
                answer++;
                return;
            }
        } else if (num < numbers.length) {
            rec(numbers, target, sum - numbers[num], num + 1, -1 * numbers[num]);
            rec(numbers, target, sum + numbers[num], num + 1, numbers[num]);
        }
    }
}
