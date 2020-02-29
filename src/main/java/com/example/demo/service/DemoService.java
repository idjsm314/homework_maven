package com.example.demo.service;

public class DemoService {

	public void solution(int m, int n, int v, int c) {
		Coin[] coins = new Coin[10001];
		int[][] dp = new int[10001][101];

		for (int i = 1; i <= n; i++) coins[i] = new Coin(v, c);

		for (int i = 1; i <= n; i++) {
			v = coins[i].value;
			c = coins[i].count;
			dp[0][i - 1] = 1;

			for (int j = 1; j <= c; j++) {
				for (int k = v * j; k <= m; k++) dp[k][i] += dp[k - (v * j)][i - 1];
			}

			for (int j = 1; j <= m; j++) dp[j][i] += dp[j][i - 1];
		}
	}

	class Coin {

		int value = 0;
		int count = 0;

		Coin(int value, int count) {
			this.value = value;
			this.count = count;
		}

	}
}
