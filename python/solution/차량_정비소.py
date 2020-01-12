import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())

for test_case in range(1, T + 1):
    N_접수처개수, M_정비처개수, K_총방문자수, A_이용접수처, B_이용정비처 = map(int, input().split())

    print(N_접수처개수, M_정비처개수, K_총방문자수, A_이용접수처, B_이용정비처)

    a_접수소요시간 = list(map(int, input().split()))
    b_정비소요시간 = list(map(int, input().split()))

    #최초 고객 리스트
    t_고객시간 = list(map(int, input().split()))

    print(a_접수소요시간)
    print(b_정비소요시간)
    print("t_고객시간",t_고객시간)

    #각 각 창구들은 남은 시간만을 기억
    a_접수처 = dict()
    for i in range(N_접수처개수):
        a_접수처[str(i)] = 0
    print("a_접수처",a_접수처)

    b_정비처 = dict()
    for i in range(M_정비처개수):
        b_정비처[str(i)] = 0
    print("b_정비처",b_정비처)

    #고객의 상태를 기억
    고객 = dict()
    #고객이 방문한 접수처의 이름을 기억
    고객접수처 = []
    #고객이 방문한 정비처의 이름을 기억
    고객정비처 = []
    for i in range(K_총방문자수):
        고객[str(i)] = "방문전"
        고객접수처.append(0)
        고객정비처.append(0)
    print("고객",고객)
    print("고객접수처",고객접수처)
    print("고객정비처",고객정비처)

    #완료 고객 리스트
    모두완료고객 = []

    #지갑 주인 목록
    answer = 0

    #진행시간
    cnt = 0

    #접수, 정비 가능 여부 확인을 위한 카운터
    접수가능 = N_접수처개수
    정비가능 = M_정비처개수

    print(접수가능, 정비가능)

    #완료 고객 리스트 크기가 최초 고객 리스트 크기와 같을 때까지 초단위 반복
    while(len(t_고객시간) is not len(모두완료고객)):

        print("시간 경과", cnt)
        #초가 바뀌면 시간이 0인 고객의 상태를 변화 시킴
        #진행중 상태로는 이후에 검사
        for i in range(len(t_고객시간)):
            
            if (t_고객시간[i] is 0) and (고객[str(i)] is "방문전"):
                고객[str(i)] = "접수대기"
            if (t_고객시간[i] is 0) and (고객[str(i)] is "접수중"):
                고객[str(i)] = "정비대기"
                if 접수가능 < N_접수처개수:
                    접수가능 += 1
            if (t_고객시간[i] is 0) and (고객[str(i)] is "정비중"):
                고객[str(i)] = "완료"
                if 정비가능 < M_정비처개수:
                    정비가능 += 1
                모두완료고객.append(str(i))
        print("고객", 고객)
        print("t_고객시간", t_고객시간)

        print("이제 접수를 받습니다.")
        #가능한 접수처가 있으면 접수대기 고객을 접수중으로 변화시킴
        for t in range(len(a_접수처)):
            #print(i, "번째 고객 입장")
            if (접수가능 > 0) and (a_접수처[str(t)] is 0):
                for i in range(len(t_고객시간)):
                    #print(t, "접수처입니다")
                    if  (고객[str(i)] is "접수대기") and (t_고객시간[i] is 0):
                        a_접수처[str(t)] = a_접수소요시간[t]
                        고객[str(i)] = "접수중"
                        t_고객시간[i] = a_접수소요시간[t]
                        고객접수처[i] = (t + 1)
                        접수가능 -= 1
                        print(t, "접수처에서", i, "가 방문함")
                        break
            #         elif (고객[str(i)] is "접수대기"):
            #             print(t, "접수처가", i, "접수받음")
            #         else:
            #             print(t, "접수처에 접수 대기중인 고객이 없음")
            # else:
            #     print("모든 접수처 가동중", i, "는 다음 접수처를 기다림")
        print("고객", 고객)
        print("t_고객시간", t_고객시간)
        print("a_접수처",a_접수처)

        #가능한 정비처가 있으면 정비대기 고객을 정비중으로 변화시킴
        for t in range(len(b_정비처)):
            #print(i, "번째 고객 입장")
            if (정비가능 > 0) and (b_정비처[str(t)] is 0):
                for i in range(len(t_고객시간)):
                    #print(t, "정비처입니다")
                    if  (t_고객시간[i] is 0) and (고객[str(i)] is "정비대기"):
                        b_정비처[str(t)] = b_정비소요시간[t]
                        고객[str(i)] = "정비중"
                        t_고객시간[i] = b_정비소요시간[t]
                        고객정비처[i] = (t + 1)
                        정비가능 -= 1
                        print(t, "정비처에서", i, "가 방문함")
                        break
                    #elif (고객[str(i)] is "접수대기"):
                        #print(t, "정비처가", i, "수리받음")
                    #else:
                        #print(t, "정비처에 정비 대기중인 고객이 없음")
            #else:
                #print("모든 정비처 가동중", i, "는 다음 정비처를 기다림")
        print("고객", 고객)
        print("t_고객시간", t_고객시간)
        print("b_정비처",b_정비처)

        #1초가 완료되면 대기 시간 감소
        for i in range(len(t_고객시간)):
            if t_고객시간[i] > 0:
                t_고객시간[i] -= 1
        print("t_고객시간", t_고객시간)

        for i in range(len(a_접수처)):
            if a_접수처[str(i)] > 0:
                a_접수처[str(i)] -= 1

        for i in range(len(b_정비처)):
            if b_정비처[str(i)] > 0:
                b_정비처[str(i)] -= 1

        cnt += 1
            
        print("모두완료고객",모두완료고객)
        print("고객접수처", 고객접수처)
        print("고객정비처", 고객정비처)

    #시뮬레이션 완료
    print("모두완료고객",모두완료고객)
    print("고객접수처", 고객접수처)
    print("고객정비처", 고객정비처)

    #특정 접수처를 모두 방문한 방문자를 정답에 추가
    for i in range(K_총방문자수):
        if 고객접수처[i] is A_이용접수처 and 고객정비처[i] is B_이용정비처:
            print(i+1)
            answer += i+1
            print(answer)

    if answer is 0:
        answer = -1

    print("#" + str(test_case) + " " + str(answer))
    print()