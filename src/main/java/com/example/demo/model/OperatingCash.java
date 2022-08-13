package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatingCash {
	private double twoYearBeforeOperatingCash;
	private double lastYearOperatingCash;
	private double presentYearOperatingCash;


	public OperatingCash() {

	}

	public double getTwoYearBeforeOperatingCash() {
		return twoYearBeforeOperatingCash;
	}

	public void setTwoYearBeforeOperatingCash(double twoYearBeforeOperatingCash) {
		this.twoYearBeforeOperatingCash = twoYearBeforeOperatingCash;
	}

	public double getLastYeareOperatingCash() {
		return lastYearOperatingCash;
	}

	public void setLastYearOperatingCash(double lastYearBeforeOperatingCash) {
		this.lastYearOperatingCash = lastYearBeforeOperatingCash;
	}

	public double getPresentYearOperatingCash() {
		return presentYearOperatingCash;
	}

	public void setPresentYeareOperatingCash(double presentYearBeforeOperatingCash) {
		this.presentYearOperatingCash = presentYearBeforeOperatingCash;
	}

}
