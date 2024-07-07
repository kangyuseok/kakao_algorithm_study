import sys

def dfs(node, depth):
    if depth >= 4:
        print(1)
        sys.exit(0)  # 프로그램 종료
    
    v[node] = 1  # 현재 노드 방문

    for next in adj[node]:  # 인접 노드 순회
        if v[next] == 0:  # 방문 안했으면
            if dfs(next, depth + 1):  # 방문하고 깊이 증가
                return True
            
    v[node] = 0 
    return False

# 입력 처리
N, M = map(int, sys.stdin.readline().strip().split())
adj = [[] for _ in range(N)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().strip().split())
    adj[a].append(b)
    adj[b].append(a)

v = [0] * N 

for i in range(N):
    if dfs(i, 0):
        print(1)
        sys.exit(0)  # 프로그램 종료

print(0)
