import sys
sys.stdin = open("sample_input.txt", "r")

# 가능성
answer = 0


# 갈림길
def rec(col, row):
    # print("새로운 시작")
    # for i in miro:
    #     print(i)
    # print(col, row)
    # print(miro[col+1][row], miro[col-1][row], miro[col][row+1], miro[col][row-1])

    # 목적지일떄 종료
    if miro[col + 1][row] == "3" or miro[col - 1][row] == "3" or miro[col][row + 1] == "3" or miro[col][row - 1] == "3":
        #print("완료")
        global answer
        answer = 1
        return 0

    # 진행가능을 확인
    if miro[col + 1][row] == "0":
        miro[col][row] = "1"
        rec(col + 1, row)
    if miro[col - 1][row] == "0":
        miro[col][row] = "1"
        rec(col - 1, row)
    if miro[col][row + 1] == "0":
        miro[col][row] = "1"
        rec(col, row + 1)
    if miro[col][row - 1] == "0":
        miro[col][row] = "1"
        rec(col, row - 1)


for test_case in range(1, 11):
    N = int(input())
    length = 16
    
    #2차원 배열 받기 정수는 맨앞의 x 대신 int(x)로
    miro = [[x for x in input()]for y in range(length)]

    answer = 0
    # 미로찾기 시작
    rec(1, 1)

    print("#" + str(N) + " " + str(answer))

