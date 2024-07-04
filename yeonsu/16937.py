H,W = map(int, input().split())
N = int(input())
sticker = []

for _ in range(N): # N만큼 스티커에 map으로 정수로 변환 후 sticker에 추가
    R,C = map(int,input().split())
    sticker.append([R,C])

# 넓이의 최댓값
max_n = 0

# 두 개의 스티커를 고르는 모든 경우의 수
# 회전할 수 있는 경우의 수는 총 4개
    # 두 스티커 모두 회전하지 않는 경우
    # 첫 번째 스티커만 회전하는 경우
    # 두 번째 스티커만 회전하는 경우
    # 두 스티커 모두 회전하는 경우
# 4개의 경우의 수 안에서도 위 아래로 붙이는 경우와 옆으로 붙이는 경우를 고려해야 함.
for i in range(N):
    R1 = sticker[i][0]
    C1 = sticker[i][1]
    print(f'R1 : {R1}, C1 : {C1}')
    for j in range(i+1, N):
        R2 = sticker[j][0]
        C2 = sticker[j][1]
        print(f'R2 : {R2}, C2: {C2}')

        if (R1+R2 <= H and max(C1,C2) <= W) or (max(R1, R2) <= H and C1+C2 <= W):
            max_n = max(max_n, R1*C1+R2*C2)
            print(f'max : {max_n}')
        elif (R1+C2 <= H and max(C1,R2) <= W) or (max(R1,C2) <= H and C1+R2 <= W):
            max_n = max(max_n, R1*C1+R2*C2)
            print(f'max : {max_n}')
        elif (C1+R2 <= H and max(R1,C2) <= W) or (max(C1,R2) <= H and R1+C2 <= W):
            max_n = max(max_n, R1*C1+R2*C2)
            print(f'max : {max_n}')
        elif (C1+C2 <= H and max(R1,R2) <= W) or (max(C1,C2) <= H and R1+R2 <= W):
            max_n = max(max_n, R1*C1+R2*C2)
            print(f'max : {max_n}')

print(max_n)