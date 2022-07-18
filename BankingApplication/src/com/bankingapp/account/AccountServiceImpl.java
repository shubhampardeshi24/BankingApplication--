package com.bankingapp.account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {

	Set<Account> acc = new HashSet<Account>();
	Scanner scanner = new Scanner(System.in);

	@Override
	public boolean addAccount(Account account) {
		if (acc.size() == 0) {
			acc.add(account);
			return true;
		} else {
			for (Account accounts : acc) {
				if (accounts.getAccountNo() == account.getAccountNo()) {
					return false;
				} else {
					acc.add(account);
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public String updateAccount(int accountNo) {
		for (Account account : acc) {
			System.out.println("inside for each");
			if (account.getAccountNo() == accountNo) {
				System.out.println("Inside if statement");
				System.out.println("Please select which details you want to update");
				System.out.println("1. name" + "2. branch");
				int ch = scanner.nextInt();
				if (ch == 1) {
					System.out.println("Please enter name to be updated");
					account.setAccountHolder(scanner.next());
					return "Name has been updated successfully";
				} else if (ch == 2) {
					System.out.println("Please enter the branch to be updated");
					account.setBranch(scanner.next());
					return "Branch has been updated successfully";
				}
			} else {
				return "Account does not exist, Please create the account";
			}
		}
		return null;
	}

	@Override
	public boolean removeAccount(int accountNo) {

		for (Account account : acc) {
			if (account.getAccountNo() == accountNo) {
				acc.remove(account);
				return true;
			}
		}
		return false;
	}

	@Override
	public Account getAccount(int accountNo) {
		for (Account account : acc) {
			if (accountNo == account.getAccountNo()) {
				return account;
			}
		}
		return null;
	}

	@Override
	public Set<Account> getAllAccount() {
		return acc;
	}

	public List<Account> balanceMoreThan1Lac() {

		List<Account> accountsMoreThan1Lac = new ArrayList<Account>();
		System.out.println(acc.size());
		for (Account account : acc) {
			if (account.getBalance() >= 100) {
				accountsMoreThan1Lac.add(account);
			}
		}
		return accountsMoreThan1Lac;
	}

	public List<Account> fetchByType(String type) {
		if (type.equalsIgnoreCase("current")) {
			List<Account> accountsByType = acc.stream().filter(account -> account.getType().equalsIgnoreCase("current"))
					.collect(Collectors.toList());
			return accountsByType;
		} else if (type.equalsIgnoreCase("savings")) {
			List<Account> accountsByType = acc.stream().filter(account -> account.getType().equalsIgnoreCase("savings"))
					.collect(Collectors.toList());
			return accountsByType;
		}
		return null;
	}

	public double avgBalanceByType(String type) {
		List<Account> account = fetchByType(type);
		double addition = 0;
		int count = 0;
		for (Account acc : account) {
			while (count != account.size()) {
				addition += acc.getBalance();
				count++;
			}
		}
		return addition / count;
	}

	public void SortBycharacterInName() {

	}

	public void exportData(List<Account> accounts) throws IOException {
		FileWriter writer = new FileWriter("F:\\bankingdata.txt");
		writer.write("AccountNo\tAccount Holer\tBalance\tBranch\tType\t\n");
		writer.write("---------------------------------------------------\n");
		for (Account account : accounts) {
			writer.write(account.getAccountNo() + "\t\t" + account.getAccountHolder() + "\t\t" + account.getBalance()
					+ "\t\t" + account.getBranch() + "\t\t" + account.getType());
			writer.write("\n");
		}
		writer.close();
	}

}
