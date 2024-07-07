import sys

def explode(arr, R, C):
    new_arr = [['O'] * C for _ in range(R)]

    for r in range(R):
        for c in range(C):
            if arr[r][c] == 'O':
                new_arr[r][c] = "."

                # 위
                if r > 0:
                    new_arr[r-1][c] = "."
                # 아래
                if r < R-1:
                    new_arr[r+1][c] = "."
                # 왼
                if c > 0:
                    new_arr[r][c-1] = "."
                # 오
                if c < C-1:
                    new_arr[r][c+1] = "."
    return new_arr


# 세,가,초
R, C, N = map(int, sys.stdin.readline().strip().split())

arr = [list(sys.stdin.readline().strip()) for _ in range(R)]

if N <= 1:
    result = arr
elif N % 2 == 0:
    result = [['O'] * C for _ in range(R)]
else: 
    first_explode = explode(arr, R, C)
    # 3, 7, 9, ...
    if N % 4 == 3:
        result = first_explode
    else :
        result = explode(first_explode, R, C)



for row in result:
    print(''.join(row))