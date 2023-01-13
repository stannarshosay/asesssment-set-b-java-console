package com.school.models;

import com.school.interfaces.SalaryCalculator;

public class ContractualTeacher extends Teacher implements SalaryCalculator{
	
	private int durationInYears;

	public ContractualTeacher(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}
	
	@Override
	public String display() {
		
		return   "\n(Contractual)"
				+ super.toString()
				+"\nContract Duration(Years) : "+this.durationInYears
				+"\n== SALARY : "+this.calculate()+"₹ ==\n";
		
	}

	@Override
	public int calculate() {
		return 300 * super.extraHours;
	}

}
