

n = 3
computers = [[1, 0, 0, 0, 1], [0, 1, 0, 0, 0], [
    0, 0, 1, 0, 0], [0, 0, 0, 1, 0], [0, 0, 0, 0, 1]]


def solution(n, computers):

    answer = 1

    recu(computers, 0)
    answer = (len(computers))
    print(answer)
/    return answer


def recu(computers, start):
    change = False
    print("새로운 시작")
    print("기준점: ", start)
    for i in range(len(computers)):
        print("비교 ", start, " 와 ", i)
        print(computers)
        for j in range(len(computers[i])):
            print("원소 비교")

            if i == start:
                break
            if (computers[i][j] == 1) and (computers[start][j] == 1):
                print("1 발견")
                comb(computers, i, start)
                recu(computers, 0)
                return 0

        print("안겹침 - 비교 대상 변경")

    print("병합이 없었음 : 기준점 변경")
    if (change == False) and (start < len(computers)-1):
        print(start)
        recu(computers, start+1)

    print("최종 종료")
    return computers


def comb(computers, position, start):
    print("병합 시작")
    print(position)
    for j in range(len(computers[position])):

        if (computers[position][j]) == 1:
            del computers[start][j]
            computers[start].insert(j, 1)

    del computers[position]

    print("병합 종료")
    print(computers)

    return True


solution(n, computers)
