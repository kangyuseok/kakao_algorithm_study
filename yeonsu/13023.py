def dfs(v, depth):
    if depth == 4:
        print(1)
        exit()
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(i, depth+1)
    visited[v] = False

N,M = map(int,input().split())

visited = [False] * N
graph = [[] for _ in range(N)]

for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N):
    dfs(i,0)
    visited[i] = False

print(0)