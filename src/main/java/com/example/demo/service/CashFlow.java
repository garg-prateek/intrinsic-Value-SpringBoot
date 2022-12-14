package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.CapitalExpenditure;
import com.example.demo.model.ImportantVariables;
import com.example.demo.model.OperatingCash;
import com.example.demo.model.OutputVariable;
import com.example.demo.model.Rate;

@Component
public class CashFlow {

	CapitalExpenditure ce = new CapitalExpenditure();
	OperatingCash oc = new OperatingCash();
	ImportantVariables iv = new ImportantVariables();
	Rate rate = new Rate();

	Scanner sc = new Scanner(System.in);

	@Autowired
	public OutputVariable averageCashFlow() {

		OutputVariable ov = new OutputVariable();
		System.out.println("-----All in crores-----");
		System.out.println(
				"All You should have is the 'BALANCE SHEET' of company, which can be downloaded from the company's website");

		System.out.println("Enter two year before operating Cash");
		oc.setTwoYearBeforeOperatingCash(sc.nextDouble());
		// System.out.println("The Two year before operating cash is: " +
		// oc.getTwoYearBeforeOperatingCash());

		System.out.println("Enter last year operating Cash");
		oc.setLastYearOperatingCash(sc.nextDouble());
		// System.out.println("The last year operating cash is: " +
		// oc.getLastYeareOperatingCash());

		System.out.println("Enter current year operating Cash");
		oc.setPresentYeareOperatingCash(sc.nextDouble());
		// System.out.println("The current year operating cash is: " +
		// oc.getPresentYearOperatingCash());

		System.out.println("Enter two year before Capital Expenditure");
		ce.setTwoYearBeforeCapitalExpenditure(sc.nextDouble());
		// System.out.println("The Two year before operating cash is: " +
		// ce.getTwoYearBeforeCapitalExpenditure());

		System.out.println("Enter last year Capital Expenditure");
		ce.setLastYearCapitalExpenditure(sc.nextDouble());
		// System.out.println("The last year operating cash is: " +
		// ce.getLastYearCapitalExpenditure());

		System.out.println("Enter current year Capital Expenditure");
		ce.setPresentYearCapitalExpenditure(sc.nextDouble());
		// System.out.println("The Current year operating cash is: " +
		// ce.getPresentYearCapitalExpenditure());

		iv.setAverageNetCashFlow((((oc.getTwoYearBeforeOperatingCash() - ce.getTwoYearBeforeCapitalExpenditure())
				+ (oc.getLastYeareOperatingCash() - ce.getLastYearCapitalExpenditure())
				+ (oc.getPresentYearOperatingCash() - ce.getPresentYearCapitalExpenditure())) / 3));

		System.out.println("The Net Average Cash Flow is: " + iv.getAverageNetCashFlow());

		System.out.println("Please Enter All Values Of Rate In Percentage");

		System.out.println("Enter the terminal rate");
		rate.setTerminalGrowthRate(sc.nextDouble());

		System.out.println("Enter the discount Rate");
		rate.setDiscountRate(sc.nextDouble());

		System.out.println("Enter first five year growth rate of Free Cash Flow");
		rate.setFirstFiveYearGrowthRate(sc.nextDouble());

		System.out.println("Enter last five year growth rate of Free Cash Flow");
		rate.setLastFiveYearGrowthRate(sc.nextDouble());

		System.out.println("The future cash flow is as follows: ");

		List<Double> list = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			double firstFiveYear = iv.getAverageNetCashFlow()
					* Math.pow((1 + (rate.getFirstFiveYearGrowthRate() / 100)), i);
			// System.out.println("The future cash flow for " + i + "th year is " +
			// firstFiveYear);
			list.add(firstFiveYear);
		}

		double fifthCash = iv.getAverageNetCashFlow() * Math.pow((1 + (rate.getFirstFiveYearGrowthRate() / 100)), 5);
//
		for (int i = 6; i <= 10; i++) {
			double lastFiveYear = fifthCash * Math.pow((1 + (rate.getLastFiveYearGrowthRate() / 100)), i - 5);
			// System.out.println("The future cash flow for " + i + "th year is " + sum1);
			list.add((i - 1), lastFiveYear);
		}

		System.out.println(list);
		double tenthCash = fifthCash * Math.pow((1 + (rate.getLastFiveYearGrowthRate() / 100)), 5);
//
		double terminalValue = tenthCash * (1 + (rate.getTerminalGrowthRate() / 100))
				/ ((rate.getDiscountRate() - rate.getTerminalGrowthRate()) / 100);
		System.out.println("The terminal value is: " + terminalValue);
//
//		 calculation of npv of future cash flow
		double sumNpv = 0;
		for (int i = 1; i <= 10; i++) {
			double npv = list.get(i - 1) / Math.pow(1 + (rate.getDiscountRate() / 100), i);
			System.out.println("the npv of each till " + i + " is: " + npv);

			sumNpv = npv + sumNpv;
			System.out.println("NPV of future cash flow: " + sumNpv);
		}
		double terminalNpv = terminalValue / Math.pow(1 + (rate.getDiscountRate() / 100), 10);
		// System.out.println("The net present value of terminal value is: " +
		// terminalNpv);
		double shareholderCash = terminalNpv + sumNpv;
		System.out.println(
				"Standing today and looking into future ,the expected total free cash flow to be generated by company is: "
						+ shareholderCash);

//		totalPVOfFCF = shareholderCash - netDebt;
//		System.out.println("The total present value of Free Cash flow is: " + totalPVOfFCF);
//
		System.out.println("Enter Total Outstanding Shares Of company ");
		iv.setTotalShares(sc.nextDouble());

		System.out.println("Enter Debt OF company ");
		iv.setNetDebt(sc.nextDouble());

		System.out.println("Enter Total Cash & Cash Equivalents Of company ");
		iv.setCashAndCashEquivalents(sc.nextDouble());

		System.out.println("Enter Total Bank Balance Of company ");
		iv.setBankBalance(sc.nextDouble());

		ov.setIntrinsicValue(
				((shareholderCash - (iv.getNetDebt() - (iv.getCashAndCashEquivalents() + iv.getBankBalance())))
						/ iv.getTotalShares()));
//
		System.out.println("The Intrinsic value of share is: " + ov.getIntrinsicValue());
//
//		System.out.println("Assuming 10 % error for upper and lower band, the intrinsic value will be: ");
		ov.setIntrinsicValueLower(ov.getIntrinsicValue() * 0.9);
		ov.setIntrinsicValueUpper(ov.getIntrinsicValue() * 1.1);
//
		System.out.println("The stock is fairly value between " + ov.getIntrinsicValueLower() + " and "
				+ ov.getIntrinsicValueUpper());
		ov.setConservativeIntrinsicValue(ov.getIntrinsicValueLower() * 0.7);
		System.out.println(
				"Taking 30% as margin of safety to be on conservative side: " + ov.getConservativeIntrinsicValue());

		return ov;
	}

}