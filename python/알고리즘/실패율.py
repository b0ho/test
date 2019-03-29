# N = 4
# stages = [4, 4, 4, 4, 4]
N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]


def solution(N, stages):
    answer = []
    failure = []

    sum = len(stages)

    for num in range(1, N+1):
        failure.append(stages.count(num)/sum)
        #print(stages.count(num), "/", sum)
        sum -= stages.count(num)

        # print("s")

    # print(failure)

    for num in range(len(failure)):
        max = 0
        pos = 0
        for i in failure:
            if i > max:
                max = i
                pos = failure.index(i)

        # print(max)

        if max == 0:
            if failure[-1] == 0 and num == len(failure)-1:
                pos = num
                # print("마지막")
            else:
                pos = num-1
                #print("최댓값 0")

        # print(pos)
        print(num, len(failure)-1, pos)

        answer.append(pos+1)
        # print(answer)

        del failure[pos]
        # print(failure)

        failure.insert(pos, -1)
        # print(failure)

    # print(answer)
    return answer


solution(N, stages)
