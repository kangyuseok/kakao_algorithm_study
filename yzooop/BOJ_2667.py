import sys

# 시작위치 받아서, 해당 위치에 연결된 1의 개수를 리턴
def bfs(sy, sx):
    q = []
    q.append((sy, sx))
    v[sy][sx] = 1
    cnt = 1

    while q:
        cy, cx = q.pop(0)

        for dy, dx in ((1, 0), (-1, 0), (0, -1), (0, 1)):
            ny, nx = cy + dy, cx + dx

            # 4방향, 범위내, 미방분, 1이면 q삽입
            if 0<=ny<N and 0<=nx<N and v[ny][nx] == 0 and arr[ny][nx] == 1:
                q.append((ny, nx))
                v[ny][nx] = 1
                cnt += 1
    return cnt


N = int(sys.stdin.readline().strip())

arr = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]
v = [[0] * N for _ in range(N)]
ans = []

for y in range(N):
    for x in range(N):

        # 방문하지 않았던 아파트 발견시 bfs
        if arr[y][x] == 1 and v[y][x] == 0:
            ans.append(bfs(y,x))

ans.sort()
print(len(ans), *ans, sep='\n')