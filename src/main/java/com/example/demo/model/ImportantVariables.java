package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportantVariables {

	private double averageNetCashFlow;
	private double netDebt;
	private double cashAndCashEquivalents;
	private double bankBalance;
	private double totalShares;

	public ImportantVariables() {

	}

	public double getAverageNetCashFlow() {
		return averageNetCashFlow;
	}

	public void setAverageNetCashFlow(double averageNetCashFlow) {
		this.averageNetCashFlow = averageNetCashFlow;
	}

	public double getNetDebt() {
		return netDebt;
	}

	public void setNetDebt(double netDebt) {
		this.netDebt = netDebt;
	}

	public double getCashAndCashEquivalents() {
		return cashAndCashEquivalents;
	}

	public void setCashAndCashEquivalents(double cashAndCashEquivalents) {
		this.cashAndCashEquivalents = cashAndCashEquivalents;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public double getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(double totalShares) {
		this.totalShares = totalShares;
	}

}
