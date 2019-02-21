tickets = [["ICN", "SFO"], ["ICN", "ATL"], [
    "SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]
isFirst = True


def solution(tickets):
    answer = [[]]

    recu(tickets, [], True)

    print(answer)

    return answer[0]


def recu(new_tickets, candi, isFirst):

    print("새로운 시작")

    if len(candi) == len(tickets):
        print("후보가 완성되면 정답에 추가하고 종료")
        answer.append(candi)
        candi.clear
        return 0

    print("첫번째 인가? ", isFirst)
    for i in range(len(new_tickets[0])-1):
        if (isFirst == False) and (new_tickets[i][1] == new_tickets[start][0]):
            print("현재의 목적지가 다음의 시작과 같다!")

            next_tickets = new_tickets[:]
            candi.append(next_tickets[i])
            del next_tickets[i]

            print(candi)

        if (isFirst == True) and (new_tickets[i][0] == "ICN"):
            print("ICN 시작 가능")
            isFirst = False

            next_tickets = new_tickets[:]
            candi.append(next_tickets[i])
            del next_tickets[i]

            print(candi)
            recu(next_tickets, candi, isFirst)

    return 0


solution(tickets)
