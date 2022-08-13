package com.example.demo.controller;

import com.example.demo.model.OutputVariable;
import com.example.demo.service.CashFlow;

public class Controller {

//	public static void main(String[] args) {

	CashFlow cashFlow = new CashFlow();
//		RateInput rateInput = new RateInput();
//		FreeCashFlowCalculation fcfc = new FreeCashFlowCalculation();
	OutputVariable output = cashFlow.averageCashFlow();

	
//		rateInput.input();
//		
//		
////		
//		fcfc.FCF();

//		rateInput.terminalRate();
//		rateInput.discountRate();
//		rateInput.firstFiveYearGrowthRate();
//		rateInput.lastFiveYearGrowthRate();

//	}

}
