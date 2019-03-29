num = int(input())

num_arr = list(map(int, list(str(num))))

sum = 0
for i in num_arr:
    sum += i

print(sum)
