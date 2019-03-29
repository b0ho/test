import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    arr = input()
    cand = []
    answer = 0
    leng = int(N / 4)

    #print("최초 후보", arr)

    for i in range(4):

        #후보에 추가
        #print(arr[0:leng])
        cand.append(arr[0:leng])

        #print(arr[leng:leng*2])
        cand.append(arr[leng:leng*2])

        #print(arr[leng*2:leng*3])
        cand.append(arr[leng*2:leng*3])
        
        #print(arr[leng*3:])
        cand.append(arr[leng*3:])

        #print("후보 추가 완료", cand)
        
        #회전
        #print(arr[1:])
        #print(arr[0:1])
        arr = arr[1:]+arr[0:1]
        #print("회전완료", arr)

    #중복 제거
    cand = list(set(cand))
    #print("중복 제거 완료", cand)

    #후보 정렬
    cand.sort()
    #print("정렬 완료", cand)

    #k번째 배열을 answer로
    answer = cand[K-1]

    print("#" + str(test_case) + " " + str(answer))
    #print()
