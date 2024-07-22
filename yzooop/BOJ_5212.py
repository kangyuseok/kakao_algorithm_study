R, C = map(int, input().split())
map_original = [input() for _ in range(R)]

# 변할 지도
map_future = [['.'] * C for _ in range(R)]

# 50년 후의 지도
for r in range(R):
    for c in range(C):
        if map_original[r][c] == 'X':
            sea_count = 0
            # 상하좌우
            if r == 0 or map_original[r-1][c] == '.':
                sea_count += 1
            if r == R-1 or map_original[r+1][c] == '.':
                sea_count += 1
            if c == 0 or map_original[r][c-1] == '.':
                sea_count += 1
            if c == C-1 or map_original[r][c+1] == '.':
                sea_count += 1
            # 주변 바다가 3개 이상이면 잠김!
            if sea_count < 3:
                map_future[r][c] = 'X'

#최소 직사각형 범위
min_r, max_r = R, 0 # 세
min_c, max_c = C, 0 # 가
for r in range(R):
    for c in range(C):
        if map_future[r][c] == 'X':
            if r < min_r: min_r = r
            if r > max_r: max_r = r
            if c < min_c: min_c = c
            if c > max_c: max_c = c


for r in range(min_r, max_r + 1):
    print(''.join(map_future[r][min_c:max_c + 1]))
