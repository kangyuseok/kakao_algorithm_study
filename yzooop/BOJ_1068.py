import sys

def dfs(node):
    graph[node] = -2
    for i in range(n):
        if node == graph[i]: 
            dfs(i)
            
n = int(sys.stdin.readline().strip())
graph = list(map(int, sys.stdin.readline().strip().split()))
erase = int(sys.stdin.readline().strip())

dfs(erase)

cnt = 0

for i in range(n):
    if graph[i] != -2 and i not in graph:
        cnt+=1

print(cnt)