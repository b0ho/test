record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo",
          "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]


def solution(record):
    answer = []
    member = dict()

    for item in record:
        tmp = item.split()
        if tmp[0] == 'Enter':
            member.update({tmp[1]: tmp[2]})
            # print(member)
        if tmp[0] == 'Change':
            member[tmp[1]] = tmp[2]
            # print(member)

    for item in record:
        tmp = item.split()
        if tmp[0] == 'Enter':
            answer.append(member[tmp[1]]+"님이 들어왔습니다.")
            #print(member[tmp[1]]+"님이 들어왔습니다.")
        elif tmp[0] == 'Leave':
            answer.append(member[tmp[1]]+"님이 나갔습니다.")
            #print(member[tmp[1]]+"님이 나갔습니다.")

    # print(answer)
    return answer


solution(record)
