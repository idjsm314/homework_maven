package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<String> resultPage(DemoModel data) {
		System.out.println("Bill : " + data.getBill());
		System.out.println("CoinCat : " + data.getCoinCat());

		service.solution(data.getBill(), data.getCoinCat(), v, c);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
}
