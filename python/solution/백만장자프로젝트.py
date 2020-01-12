import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())

for test_case in range(1, T + 1):
    # 차익
    answer = 0
    n = int(input())
    day = list(map(int, input().split()))

    max_value = day[n-1]
    
    #첫번째 날부터 검사
    for now in range(n-2, -1, -1):
        print("----------", now)
        print(max_value, day[now])
        if max_value > day[now]:
            answer += max_value - day[now]
        else:
            max_value = day[now]
        print(max_value)
        print("answer", answer)

    print("#" + str(test_case) + " " + str(answer))
