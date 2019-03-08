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
    tmp = UD(tmp, name, loc, lr)

    # 왼쪽으로 이동할지 오른쪽으로 이동할지 결정
    # 최초 결정 이후에는 한쪽 방향으로만 이동
    if name.find("A") > len(name)/2-1:
        lr *= - 1
        loc = len(name)

    # 입력 문자열과 같아질때까지 반복
    while 1:

        # 최종 이동값을 반환
        if tmp == name:
            # print(answer)
            return answer

        # 좌 or 우로 이동
        loc += lr
        answer += 1

        # 이동값을 매번 추가
        tmp = UD(tmp, name, loc, lr)

    return answer


# 알파벳을 변환
def UD(tmp, name, loc, lr):
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