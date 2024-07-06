import sys

def dfs(node, depth):
    if depth >= 4:
        return True
    
    v[node] = 1 # 현재 노드 방문

    for next in adj[node]: # 인접 노드 순회
        if v[next] == 0:  # 방문 안했으면
            if dfs(next, depth + 1): # 방문하되, 깊이 들어가면 true
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
    v = [0] * N  # 방문 여부를 저장하는 배열
    if dfs(i, 0):
        print(1)
        sys.exit(0)  # 프로그램 종료

print(0)
