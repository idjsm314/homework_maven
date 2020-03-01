package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.CoinModel;
import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	DemoService service;

	@RequestMapping(value="/solution", method=RequestMethod.GET)
	public String solutionPage() {
		System.out.println();
		return "solution";
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
	public ResponseEntity<Integer> resultPage(@RequestBody DemoModel data) {

		System.out.println("지폐 : " + data.getBill());
		System.out.println("동전 가지 수 : " + data.getCoinCat());
		for (CoinModel c : data.getCoinModel()) {
			System.out.println("동전 금액 : " + c.getPi() + ", 해당 동전 보유수 : " + c.getNi());
		}

		int result = service.solution(data);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
