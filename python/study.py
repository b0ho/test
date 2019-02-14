begin = 'hit'
target = 'cog'
words = ['hot', 'dot', 'dog', 'lot', 'log', 'cog']
answers = []
tmp_list = []


def solution(begin, target, words):

    answer = 0

    # 배열에 답이 없는 경우 바로 종료
    isit = False
    for i in words:
        if target == i:
            isit = True
    if isit == False:
        return answer

    # 변환 시작
    tmp = []
    change(begin, target, words, answer, tmp)

    # print(tmp_list)

    print(answers)
    answer = min(answers)
    # print(answer)

    return answer


def change(begin, target, words, cnt, tmp):
    flags = False
    # 변환이 완료 될 경우 종료
    if begin == target:
        # print('성공')

        # 최종 변환 횟수를 정답 배열에 저장
        answers.append(cnt)
        print(tmp)
        tmp_list.append(tmp)

        return 0

    # 배열이 남아있지 않으면 종료 == 변환 가능한 경우가 없음 리턴 0
    elif words[0] == None:
        # print("불가능")
        return 0

    else:
        # words에 남은 만큼 반복
        for single_word in range(len(words)):

            # 일치하는 알파벳 개수
            compare_cnt = 0
            # 각 단어의 첫번째 알파벳부터 비교
            for i in range(len(begin)):

                # 같으면 비교 카운터 증가
                if begin[i] is words[single_word][i]:
                    compare_cnt += 1

            # 만약 단어 길이 -1만큼 같다면? 변환 후 다시 검색
            if compare_cnt == len(begin) - 1:

                # 비교중인 단어를 제외한 나머지를 새로운 배열로 생성
                # 새로운 배열은 진입 성공했던 단어들이 이미 제외 되어있음
                else_words = words[:single_word] + words[single_word+1:]

                # 변환 된 단어 배열로 다시 검색
                # 진입에 성공한 single_wold로 begin을 교체하고 배열에서 제외하여 검색
                # 카운터 증가

                flags = True
                change(words[single_word], target, else_words,
                       cnt+1, tmp)
                if flags == True:
                    tmp.append(begin)
            else:
                flags = False

        # 변환 불가능한 경우 다음 단어를 검색
        # print('종료')
        return 0


solution(begin, target, words)
