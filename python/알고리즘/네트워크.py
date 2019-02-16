def solution(n, computers):

    answer = 0

    answer = rec(computers, 0)

    return answer


def rec(computers, position):
   for i in range(len(computers)):

        for j in range(len(computers[i])-i):

            if(computers[i][j] == 1):

                rec(computers, i)

        del computers[i]

    return len(computers)


n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]


solution(n, computers)
