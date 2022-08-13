package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CapitalExpenditure {
	private double twoYearBeforeCapitalExpenditure;
	private double lastYearCapitalExpenditure;
	private double presentYearCapitalExpenditure;

	public CapitalExpenditure() {

	}

	public double getTwoYearBeforeCapitalExpenditure() {
		return twoYearBeforeCapitalExpenditure;
	}

	public void setTwoYearBeforeCapitalExpenditure(double twoYearBeforeCapitalExpenditure) {
		this.twoYearBeforeCapitalExpenditure = twoYearBeforeCapitalExpenditure;
	}

	public double getLastYearCapitalExpenditure() {
		return lastYearCapitalExpenditure;
	}

	public void setLastYearCapitalExpenditure(double lastYearCapitalExpenditure) {
		this.lastYearCapitalExpenditure = lastYearCapitalExpenditure;
	}

	public double getPresentYearCapitalExpenditure() {
		return presentYearCapitalExpenditure;
	}

	public void setPresentYearCapitalExpenditure(double presentYearCapitalExpenditure) {
		this.presentYearCapitalExpenditure = presentYearCapitalExpenditure;
	}

}
