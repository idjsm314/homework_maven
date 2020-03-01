package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.CoinModel;
import com.example.demo.model.DemoModel;

@Service
public class DemoService {

	public int solution(DemoModel demo) {
		int bill = demo.getBill();
		int coinCatLength = demo.getCoinCat();
		int [] D = new int [bill+1];

		CoinModel[] list = demo.getCoinModel();
		int[] pi = new int[coinCatLength+1];
		int[] ni = new int[coinCatLength+1];

		for (int i = 0; i < coinCatLength; i++) {
			pi[i] = list[i].getPi();
			ni[i] = list[i].getNi();
		}

		D[0] = 1;

		for (int i = 1; i <= coinCatLength; i++) {
			for (int j = bill; j >= 1; j--) {
				for (int k = 1; k <= ni[i]; k++) {
					if (j - (pi[i] * k) >= 0) {
						D[j] += D[j - (pi[i] * k)];
					}
				}
			}
			System.out.println(bill + " = " + pi[i] + " X " + ni[i]);
		}

		return D[bill];
	}
}
