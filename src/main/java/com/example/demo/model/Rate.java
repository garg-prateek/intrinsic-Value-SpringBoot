package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rate {

	private double firstFiveYearGrowthRate;
	private double lastFiveYearGrowthRate;

	private double terminalGrowthRate;
	private double discountRate;

	public Rate() {
		
	}
	public void setFirstFiveYearGrowthRate(double firstFiveYearGrowthRate) {
		this.firstFiveYearGrowthRate = firstFiveYearGrowthRate;
	}

	public double getFirstFiveYearGrowthRate() {
		return firstFiveYearGrowthRate;
	}

	public double getLastFiveYearGrowthRate() {
		return lastFiveYearGrowthRate;
	}

	public void setLastFiveYearGrowthRate(double lastFiveYearGrowthRate) {
		this.lastFiveYearGrowthRate = lastFiveYearGrowthRate;
	}

	public void setTerminalGrowthRate(double terminalRate) {
		this.terminalGrowthRate = terminalRate;
	}

	public double getTerminalGrowthRate() {
		return terminalGrowthRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

}