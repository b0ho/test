

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
    print(len(computers))
    print("새로운 시작")
    for i in range(len(computers)-1):
        print(computers)
        for j in range(len(computers[i])):
            print("원소 비교")

            if (computers[i][j] == 1) and (computers[start][j] == 1):
                print("1 발견")
                comb(computers, i)
                recu(computers, i)
                return 0

        print("안겹침 - 다음 케이스로")

    print("최종 종료")
    return computers


def comb(computers, position):
    print("병합 시작")
    print(position)
    for j in range(len(computers[position])):

        print(computers[position])

        if (computers[position][j]) == 1:
            del computers[position+1][j]
            computers[position+1].insert(j, 1)

    del computers[position]

    print("병합 종료")
    print(computers)

    return computers


solution(n, computers)
