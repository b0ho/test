import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())

for test_case in range(1, T + 1):
    N_접수처개수, M_정비처개수, K_총방문자수, A_이용접수처, B_이용수리처 = map(int, input().split())

    a_접수소요시간 = input()
    b_정비소요시간 = input()

    # 최초 고객 리스트
    t_최초고객 = input()

    print(a_접수소요시간)
    print(b_정비소요시간)
    print(t_최초고객)

    # 각 각 창구들은 남은 시간만을 기억
    a_접수처 = dict()
    for i in range(K_총방문자수):
        a_접수처[i] = 0
        print(a_접수처[i])
    print(a_접수처)
    b_정비처 = dict()
    for i in range(K_총방문자수):
        b_정비처[i] = 0
        print(b_정비처[i])

    # 고객의 상태를 기억
    고객 = dict()
    for i in range(K_총방문자수):
        고객[i] = "방문전"
        print(고객[i])

    # 고객이 방문한 접수처의 이름을 기억
    고객접수처 = []

    # 고객이 방문한 수리처의 이름을 기억
    고객수리처 = []

    # 완료 고객 리스트
    모두완료고객 = []

    # 지갑 주인 목록
    answer = 0

    # 진행시간
    cnt = 0

    # 접수, 수리 가능 여부 확인을 위한 카운터
    접수가능 = N_접수처개수
    수리가능 = M_정비처개수

    # 완료 고객 리스트 크기가 최초 고객 리스트 크기와 같을 때까지 초단위 반복
    while(len(t_최초고객) is len(모두완료고객)):

        # 방문시간이 0인 방문전 고객을 접수 대기로 변화시킴
        for i in range(len(t_최초고객)):
            if (t_최초고객[0] is 0) and (고객[i] is "방문전"):
                고객[i] = "접수대기"

        # 가능한 접수처가 있으면 == 접수가능>0 이면
        # 완료 고객은 수리 대기로 이동하고 새로운 고객을 가져옴
        tmp = []
        for i in range(len(접수가능)):
            for t in range(len(고객)):
                if 고객[t] is 0:
                    tmp.append(t)
            tmp[i] =

        # 수리처 남은 시간이 0인 곳이 있으면
        # 완료 고객은 완료 리스트로 이동하고 새로운 고객을 가져옴
        # for i in range(len(수리가능))

        # 1초가 완료 되면 시간 증가
        cnt += 1

    # 시뮬레이션 완료
    # 각 접수처를 모두 방문한 방문자를 정답에 추가
    for i in range(K_총방문자수):
        if 고객접수처[i] is A_이용접수처 and 고객수리처[i] is B_이용수리처:
            print(i + 1)
            answer += i + 1
            print(answer)

    print("#" + str(test_case) + " " + str(answer))
