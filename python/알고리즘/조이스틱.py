name = 'JEROEN'
answer = 0


def solution(name):
    global answer
    # 변환하기 전은 문자열 AA...
    tmp = ""
    for n in range(len(name)):
        tmp += "A"

    loc = 0
    lr = 1

    # 첫번째는 좌우이동없이 변환
    tmp = UD(tmp, name, loc)

    # 입력 문자열과 같아질때까지 반복
    while 1:

        # 최종 이동값을 반환
        if tmp == name:
            # print(answer)
            return answer

        # 좌 or 우로 이동
        right = LR(name, loc + 1, 1)
        left = LR(name, loc - 1, -1)
        if right > left:
            answer += left
            loc = left
        else:
            answer += right
            loc = right

        # 이동값을 매번 추가
        tmp = UD(tmp, name, loc)

    return answer


# 좌우 이동을 결정
def LR(name, loc, lr):
    cnt = 0
    while True:
        if name[loc] == "A":
            loc += lr
            cnt += 1
        else:
            return cnt


# 알파벳을 변환
def UD(tmp, name, loc):
    global answer
    n = 0

    # N보다 작으면 UP
    if (ord(name[loc]) - ord("A")) < 13:
        n = ord(name[loc]) - ord("A")

    # N보다 크면 DOWN
    else:
        n = ord("Z") - ord(name[loc]) + 1

    # tmp 변환
    tmp = tmp[:loc] + name[loc] + tmp[loc+1:]

    # UP or DOWN 수 반환
    answer += n

    print(n)
    print(tmp)

    return tmp


print(solution(name))
