package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.CoinModel;
import com.example.demo.model.DemoModel;

@Service
public class DemoService {

	public int solution(DemoModel demo) {
		// 데이터 정의 영역
		int bill = demo.getBill();
		int coinLen = demo.getCoinCat();
		int [] dArray = new int [bill+1];

		CoinModel[] list = demo.getCoinModel();
		int[] pi = new int[coinLen+1];
		int[] ni = new int[coinLen+1];

		for (int i = 0; i < coinLen; i++) {
			pi[i] = list[i].getPi();
			ni[i] = list[i].getNi();
		}

		// 알고리즘  영역
		dArray[0] = 1;

		// 동전  종류만큼 반복
		for (int i = 1; i <= coinLen; i++) {
			// 지폐 금액 만큼 반복
			for (int j = bill; j >= 1; j--) {
				// 해당 동전 갯수 만큼 반복
				for (int k = 1; k <= ni[i]; k++) {
					// 남은 금액에서 동전 만큼 뺸게 0보다 크다면
					if (j - (pi[i] * k) >= 0) {
						// 해당 배열은
						dArray[j] += dArray[j - (pi[i] * k)];
					}
				}
				System.out.println("dArray[" + i + "][" + j + "] : " + dArray[j]);
			}
		}

		int cnt = 0;
		for (int d : dArray) {
			if (d != 0) cnt++;
		}

		return cnt - 1;
	}
}
