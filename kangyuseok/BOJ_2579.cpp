#include<iostream>
#include<algorithm>
#include<climits>
#include<string>
#include<vector>
#include<queue>
#include<stack>
#include<deque>
#include<cmath>
#include<time.h>
#include<cstring>
#include<cmath>
#include<cstring>
using namespace std;
using ll = long long;
using ull = unsigned long long;
int dp[301][3];
int chair[301];
int n;
int cnt = 0;
int main() {
	ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
	cin >> n;
	for (int i = 1, c; i <= n; i++) {
		cin >> c;
		chair[i] = c;
	}
	dp[0][0] = 0;
	dp[1][1] = chair[1];
	for (int i = 2; i <= n; i++) {
		dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + chair[i];
		dp[i][2] = dp[i - 1][1] + chair[i];
	}
	

	cout << max(dp[n][1], dp[n][2]);

	return 0;
}
