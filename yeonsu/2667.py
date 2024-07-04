N = int(input())

# 입력받은 자료들을 N만큼 2차원 배열로 만들어줌
array = [list(map(int, input().strip())) for _ in range(N)]

# 
M = []

# 방향 배열: 상, 하, 좌, 우
dx = [-1, 1, 0, 0]  # 행의 변화량
dy = [0, 0, -1, 1]  # 열의 변화량

def dfs(x,y):
    # 범위에 있는지 확인
    if x < 0 or x >= N or y < 0 or y >= N:
        #벗어났다면 false
        return False

    # 만약 x,y의 좌표에 값이 1이라면
    if array[x][y] == 1:
        # 전역 count
        global count
        # count를 1 증가
        count += 1
        # 그 좌표에 0으로 넣어줌으로써 방문했다는 표시
        array[x][y] = 0
        # 상하좌우 인접한 곳 탐색(단지) 4인 이유는 4방향을 탐색하기 위함
        for i in range(4):
            # 새로운 위치를 계산하고 dfs를 다시 호출해서 새로운 위치에서 다시 담색
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx,ny)
        # 현 위치에서 연결된 모든 집을 탐색했으므로 True
        return True
    return False

count = 0 # 단지 안에 집 개수
result = 0 # 단지 개수

# 모든 위치를 순회
for i in range(N):
    for j in range(N):
        # dfs가 true를 반환하면 새로운 단지를 발견했으므로 
        # count를 append해주고 0으로 초기화, 단지의 개수를 하나씩 증가시킴 ~
        if dfs(i,j):
            M.append(count)
            result += 1
            count = 0

# 가장 적게 있는 단지의 집 개수부터
M.sort()
# 단지 개수 출력
print(result)
# 단지 안 집의 수 출력
for i in range(len(M)):
    print(M[i])