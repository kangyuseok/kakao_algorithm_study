import sys
input = sys.stdin.readline

N = int(input().strip())
akbo = list(map(int, input().strip().split()))


mistake = [0] * N

# 실수 여부
for i in range(N - 1):
    if akbo[i + 1] < akbo[i]:
        mistake[i] = 1

# 누적 합 
prefix_sum = [0] * (N + 1)
for i in range(1, N + 1):
    prefix_sum[i] = prefix_sum[i - 1] + mistake[i - 1]

Q = int(input().strip())
for _ in range(Q):
    i, j = map(int, input().strip().split())
    print(prefix_sum[j - 1] - prefix_sum[i - 1])
