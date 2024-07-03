# 1. 궁수 조합 mC3
# 2. 맨해튼 거리계산
# 3. 적 발견, 적과의 거리 계산
# 4. 적 아랫줄로 옮기기
# 5. 공격



import sys

def combination(arr, r):
    result = []
    if r == 0:
        return [[]]
    
    for i in range(len(arr)):
        for rest in combination(arr[i+1:], r-1):
            result.append([arr[i]] + rest)
    return result

def get_distance(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

def find_target(archers, n, m, d, arr):
    targets = set()  # 중복 방지
    for archer in archers: # 각 궁수에 대해
        target = None # 궁수가 조준할 목표 초기화

        for y in range(n):
            for x in range(m):
                if arr[y][x] == 1:  # 적 발견하면
                    distance = get_distance((y, x), (n, archer)) # 궁수랑 적이랑 거리 계산

                    if distance <= d: # 사격거리 이내면
                        # 가장 가까운 적 찾고, 거리 동일하면 왼쪽 우선
                        if target is None or distance < get_distance(target, (n, archer)) or (distance == get_distance(target, (n, archer)) and x < target[1]):
                            target = (y, x)

        if target: 
            targets.add(target) # 찾은 목표 추가
    return targets

def move(arr, n, m):
    new_arr = [[0] * m for _ in range(n)]
    for row in range(n-1):
        new_arr[row+1] = arr[row]
    return new_arr

def attack(archers, arr, n, m, d):
    kills = 0

    while any(1 in row for row in arr): # 배열에 적이 남아있는 동안
        targets = set() # 이번 턴에 공격할 목표들

        targets = find_target(archers, n, m, d, arr) # 궁수의 타겟을 찾음
        kills += len(targets) # 이번 턴에 제거할 적의 수 추가

        for row, col in targets:
            arr[row][col] = 0 # 적 제거
        
        arr = move(arr, n, m) # 한줄 내리고
    return kills

def main():
    n, m, d = map(int, sys.stdin.readline().strip().split())
    grid = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

    columns = list(range(m))
    archer_combination = combination(columns, 3)

    max_kills = 0

    for archers in archer_combination:
        copied_arr = [row[:] for row in grid]
        kills = attack(archers, copied_arr, n, m, d)
        if kills > max_kills:
            max_kills = kills
    print(max_kills)

if __name__ == "__main__":
    main()
