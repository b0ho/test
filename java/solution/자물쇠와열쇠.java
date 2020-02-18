package solution;

public class 자물쇠와열쇠 {
    public static void main(String args[]) {
        자물쇠와열쇠 s = new 자물쇠와열쇠();
        int[][] arr_1 = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
        int[][] arr_2 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        s.solution(arr_1, arr_2);
    }

    // 상태가 바뀔때마다 재귀
    // 큰재귀 4번 : 회전
    // 상하좌우 움직일 때마다 재귀
    // 상하좌우 이동시 방향성!과 최대크기! 검사
    // 모든 재귀 시작시 성공여부 검사
    boolean answer = false;

    public boolean solution(int[][] key, int[][] lock) {
        for (int i = 0; i < 4; i++) {
            rec(turn(key, i), lock, lock.length, lock.length, lock.length, lock.length);
        }
        // System.out.println(answer);
        return answer;
    }

    public void rec(int[][] find_key, int[][] find_lock, int u, int d, int l, int r) {
        if (u <= find_lock.length)
            up(find_key, find_lock, u, d, l, r);
        if (d <= find_lock.length)
            down(find_key, find_lock, u, d, l, r);
        if (l <= find_lock.length)
            left(find_key, find_lock, u, d, l, r);
        if (r <= find_lock.length)
            right(find_key, find_lock, u, d, l, r);
    }

    public int[][] turn(int[][] turn_key, int n) {
        int[][] tmp1 = new int[turn_key.length][turn_key.length];
        int[][] tmp2 = new int[turn_key.length][turn_key.length];
        int[][] tmp3 = new int[turn_key.length][turn_key.length];
        if (n == 0) {
            tmp1 = turn_key;
            return tmp1;
        }
        if (n >= 1) {
            for (int i = 0; i < turn_key.length; i++) {
                for (int j = 0; j < turn_key.length; j++) {
                    tmp1[i][j] = turn_key[turn_key.length - 1 - j][i];
                }
            }
            if (n == 1) {
                return tmp1;
            }
        }
        if (n >= 2) {
            for (int i = 0; i < turn_key.length; i++) {
                for (int j = 0; j < turn_key.length; j++) {
                    tmp2[i][j] = tmp1[turn_key.length - 1 - j][i];
                }
            }
            if (n == 2) {
                return tmp2;
            }
        }
        if (n >= 3) {
            for (int i = 0; i < turn_key.length; i++) {
                for (int j = 0; j < turn_key.length; j++) {
                    tmp3[i][j] = tmp2[turn_key.length - 1 - j][i];
                }
            }
            return tmp3;
        }

        return tmp1;
    }

    public void up(int[][] now_key, int[][] lock, int u, int d, int l, int r) {
        if (u <= 0 || d > lock.length) {
            return;
        } else {
            int[][] tmp = new int[now_key.length][now_key.length];
            int[][] toto = new int[now_key.length][now_key.length];
            for (int i = 0; i < now_key.length - 1; i++) {
                for (int j = 0; j < now_key.length; j++) {
                    tmp[i][j] = now_key[i + 1][j];
                }
            }
            for (int i = 0; i < now_key.length; i++) {
                for (int j = 0; j < now_key.length; j++) {
                    if (i == lock.length) {
                        toto[i][j] = 0;
                    } else {
                        toto[i][j] = tmp[i][j];
                    }
                }
            }

            if (comf(toto, lock) == false) {
                rec(toto, lock, u - 1, d + 1, l, r);
            } else {
                answer = true;
                return;
            }
        }
    }

    public void down(int[][] now_key, int[][] lock, int u, int d, int l, int r) {
        if (d <= 0 || u > lock.length) {
            return;
        } else {
            int[][] tmp = new int[now_key.length][now_key.length];
            int[][] toto = new int[now_key.length][now_key.length];
            for (int i = 1; i < now_key.length; i++) {
                for (int j = 0; j < now_key.length; j++) {
                    tmp[i][j] = now_key[i - 1][j];
                }
            }
            for (int i = 0; i < now_key.length; i++) {
                for (int j = 0; j < now_key.length; j++) {
                    if (i == 0) {
                        toto[i][j] = 0;
                    } else {
                        toto[i][j] = tmp[i][j];
                    }
                }
            }

            if (comf(toto, lock) == false) {
                rec(toto, lock, u + 1, d - 1, l, r);
            } else {
                answer = true;
                return;
            }
        }
    }

    public void left(int[][] now_key, int[][] lock, int u, int d, int l, int r) {
        if (l <= 0 || r > lock.length) {
            return;
        } else {
            int[][] tmp = new int[now_key.length][now_key.length];
            int[][] toto = new int[now_key.length][now_key.length];
            for (int i = 0; i < now_key.length; i++) {
                for (int j = 0; j < now_key.length - 1; j++) {
                    tmp[i][j] = now_key[i][j + 1];
                }
            }
            for (int i = 0; i < now_key.length; i++) {
                for (int j = 0; j < now_key.length; j++) {
                    if (j == lock.length) {
                        toto[i][j] = 0;
                    } else {
                        toto[i][j] = tmp[i][j];
                    }
                }
            }

            if (comf(toto, lock) == false) {
                rec(toto, lock, u, d, l - 1, r + 1);
            } else {
                answer = true;
                return;
            }
        }
    }

    public void right(int[][] now_key, int[][] lock, int u, int d, int l, int r) {
        if (r <= 0 || l > lock.length) {
            return;
        } else {
            int[][] tmp = new int[now_key.length][now_key.length];
            int[][] toto = new int[now_key.length][now_key.length];
            for (int i = 0; i < now_key.length; i++) {
                for (int j = 1; j < now_key.length; j++) {
                    tmp[i][j] = now_key[i][j - 1];
                }
            }
            for (int i = 0; i < now_key.length; i++) {
                for (int j = 0; j < now_key.length; j++) {
                    if (j == 0) {
                        toto[i][j] = 0;
                    } else {
                        toto[i][j] = tmp[i][j];
                    }
                }
            }

            if (comf(toto, lock) == false) {
                rec(toto, lock, u, d, l + 1, r - 1);
            } else {
                answer = true;
                return;
            }
        }
    }

    public boolean comf(int[][] now_key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (now_key[i][j] == lock[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}