package com.school.models;

import com.school.interfaces.SalaryCalculator;

public class PermanentTeacher extends Teacher implements SalaryCalculator{
	
	private boolean isSenior;	

	public PermanentTeacher(boolean isSenior) {		
		this.isSenior = isSenior;		
	}
	
	public boolean isSenior() {
		return isSenior;
	}

	public void setSenior(boolean isSenior) {
		this.isSenior = isSenior;
	}
	
	@Override
	public String display() {
		
		return   "\n(Permanent)"
				+ super.toString()
				+"\nSenior : "+this.isSenior
				+"\n== SALARY : "+this.calculate()+"₹ ==\n";
		
	}

	@Override
	public int calculate() {
		return 800 * super.extraHours;
	}

}
