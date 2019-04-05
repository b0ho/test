import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())


def calc(i, j):
    tmp = 0
    for a in range(M):
        for b in range(M):
            tmp += int(room[i + a][j + b])
            #print("tmp", tmp)
    return tmp


for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    room = [[x for x in input().split()]for y in range(N)]
    # print(room)
    answer = 0

    for i in range(N - M + 1):
        for j in range(N - M + 1):
            tmp = calc(i, j)
            if tmp > answer:
                answer = tmp

    print("#" + str(test_case) + " " + str(answer))
