import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())

for test_case in range(1, T + 1):
    N = input()
    answer = 0

    if N == N[::-1]:
        answer = 1

    # print(N[:int((len(N) / 2))])
    # print(N[int((len(N) / 2)):])
    # print()

    # if len(N) % 2 == 0:
    #     print(N[:int((len(N) / 2))])
    #     print(N[int((len(N) / 2)):])

    #     if (N[:int((len(N) / 2))]) == (N[int((len(N) / 2)):]):
    #         anwer = 1

    # else:
    #     print(N[:int((len(N) / 2))])
    #     print(N[int((len(N) / 2 + 1)):])

    print("#" + str(test_case) + " " + str(answer))
