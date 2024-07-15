import sys

# 계단의 수 입력
h = int(sys.stdin.readline())

# 각 계단의 점수 입력. 편의상 첫 번째 요소는 0으로 시작 (계단 번호를 1부터 사용하기 위해)
stair = [0] + [int(sys.stdin.readline()) for i in range(1, h + 1)]

# 계단의 수가 2보다 작은 경우 예외 처리
if h < 2:
    print(stair[h])
else:
    # 동적 계획법을 위한 배열 초기화
    dp = [0] * (h + 1)
    
    # 첫 번째 계단 점수는 첫 번째 계단 자체의 점수
    dp[1] = stair[1]
    
    # 두 번째 계단까지의 최대 점수는 첫 번째 계단 점수와 두 번째 계단 점수를 더한 값
    dp[2] = dp[1] + stair[2]
    
    # 세 번째 계단부터는 규칙에 따라 최대 점수를 계산
    for i in range(3, h + 1):
        dp[i] = max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i]
    
    # 마지막 계단까지의 최대 점수를 출력
    print(dp[h])
