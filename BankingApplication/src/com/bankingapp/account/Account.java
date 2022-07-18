package com.bankingapp.account;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountNo;
	private String accountHolder;
	private double balance;
	private String branch;
	private String type;
	
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountHolder=" + accountHolder + ", balance=" + balance
				+ ", branch=" + branch + ", type=" + type + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public Account() {
		
	}

	public Account(int accountNo, String accountHolder, double balance, String branch, String type) {
		super();
		this.accountNo = accountNo;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.branch = branch;
		this.type = type;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}	
}
