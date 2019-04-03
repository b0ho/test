
N = int(input())

# 처음은 무조건 1부터 시작
answer = "1"

# N 만큼 반복
for i in range(2, N + 1):
    # 3, 6, 9가 몇개인지 저장
    cnt = 0
    num = str(i)

    # 1000자리 일 경우 3번 확인
    if 100 <= i:
        if num[0] is "3" or num[0] is "6" or num[0] is "9":
            cnt += 1
        if num[1] is "3" or num[1] is "6" or num[1] is "9":
            cnt += 1
        if num[2] is "3" or num[2] is "6" or num[2] is "9":
            cnt += 1

    # 100자리 일 경우 2번 확인
    elif 10 <= i < 100:
        if num[0] is "3" or num[0] is "6" or num[0] is "9":
            cnt += 1
        if num[1] is "3" or num[1] is "6" or num[1] is "9":
            cnt += 1

    # 10자리 일 경우 1번확인
    elif i < 10:
        if num[0] is "3" or num[0] is "6" or num[0] is "9":
            cnt += 1

    # 3, 6, 9 카운터가 0이면 그냥 숫자 추가
    if cnt is 0:
        answer += " " + num

    # 3, 6, 6 카운터가 있으면 그만큼 - 추가
    else:
        answer += " " + "-" * cnt

print(answer)
