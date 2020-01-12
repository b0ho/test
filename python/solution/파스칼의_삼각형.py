import sys

sys.stdin = open("sample_input.txt", "r")
T = int(input())

for test_case in range(1, T + 1):
    print("#" + str(test_case))

    # 삼각형 크기
    n = int(input())

    # 초기 파스칼 삼각형
    arr = [[1]]
    print(1)
    
    # 삼각형 만들기 시작
    # 초기 삼각형은 제외
    for i in range(1, n):

        # print("i", i)
        # 새로운 변의 시작은 무조건 1
        if i is not 0:
            arr.append([1])

        # 첫번째 변 출력
        print(1, end=" ")

        # 새로운 변 만들기 시작
        for j in range(1, i):
            # print("j", j)
            arr[i] = arr[i] + [(arr[i - 1][j] + arr[i - 1][j - 1])]
            print(arr[i - 1][j] + arr[i - 1][j - 1], end=" ")
        
        # 새로운 변의 마지막은 무조건 1
        if i is not 0:
            arr[i]= arr[i]+[1]

        # 마지막 변 출력
        print(1)
    
    # 배열로 한번에 출력하는 방법
    # for i in arr:
    #     print(*i)



