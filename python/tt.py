begin = 'hit'
target = 'cog'
words = ['hot', 'dot', 'dog', 'lot', 'log', 'cog']
answer = 0


def change(begin, target, words, cnt):
    global answer
    if begin == target:
        answer = cnt
    else:
        for single_word in range(len(words)):
            change_cnt = 0
            for i in range(len(begin)):
                if begin[i] is words[single_word][i]:
                    change_cnt += 1
            if change_cnt == len(begin) - 1:
                else_words = words[:single_word] + words[single_word+1:]
                # print(else_words)
                change(words[single_word], target, else_words, cnt+1)


def solution(begin, target, words):
    if target not in words:
        return 0
    change(begin, target, words, 0)
    print(answer)
    return answer


solution(begin, target, words)
