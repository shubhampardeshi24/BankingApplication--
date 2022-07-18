package com.bankingapp.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Driver {
	public static void main(String[] args) {

		AccountServiceImpl service = new AccountServiceImpl();

		System.out.println("*******Welcome to the Banking application*******");

		Scanner scanner = new Scanner(System.in);

		boolean flag = true;
		while (flag) {

			System.out.println("1. Add Account");
			System.out.println("2. update Account");
			System.out.println("3. remove Account");
			System.out.println("4. view account details");
			System.out.println("5. View all the accounts");
			System.out.println("6. Account Statistics");
			System.out.println("7. Export all the account");
			System.out.println("10. Exit" + "\n");
			System.out.println("Please enter which operation you would like to perform????");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Please enter the account number:: ");
				int accountNo = scanner.nextInt();
				System.out.println("Please enter the account holders name");
				String accountHolder = scanner.next();
				System.out.println("Please enter account balance");
				double balance = scanner.nextDouble();
				System.out.println("Please enter the branch of the bank");
				String branch = scanner.next();
				System.out.println("Please enter the type of the account Current/Savings");
				String type = scanner.next();
				if (service.addAccount(new Account(accountNo, accountHolder, balance, branch, type))) {
					System.out.println("Account has been created Successfully");
				} else {
					System.out.println("Account already exist");
				}
			}
				break;

			case 2: {
				System.out.println("Please enter your Account number");
				System.out.println(service.updateAccount(scanner.nextInt()));
			}
				break;
			case 3: {
				System.out.println("Please enter account number to be removed");
				if(service.removeAccount(scanner.nextInt())) {
					System.out.println("your account has been removed successfully");
				}else {
					System.out.println("Something went wrong \n");
				}
			}
				break;
			case 4: {
				System.out.println("Please enter the account no. ");
				Account account = service.getAccount(scanner.nextInt());
				if (account != null) {
					System.out.println("Account number is ::" + account.getAccountNo());
					System.out.println("Account holders name:: " + account.getAccountHolder());
					System.out.println("Account balance is:: " + account.getBalance());
					System.out.println("Account branch is :: " + account.getBranch());
				} else {
					System.out.println("Please enter valid bank account number");
				}
			}
				break;

			case 5: {
				Set<Account> accounts = service.getAllAccount();
				System.out.println("AccountNo\t\tAccount Holder\t\tBalance\t\tBranch\t\tType");
				System.out.println("------------------------------------------");
				for (Account account : accounts) {
					System.out.println(account.getAccountNo() + "\t\t" + account.getAccountHolder() + "\t\t"
							+ account.getBalance() + "\t\t" + account.getBranch() + "\t\t" + account.getType());
				}
			}
			break;
			
			case 6:{
				flag = true;
				while(flag) {
					System.out.println("------------------------------------------------------------");
					System.out.println("1. Fetch the account more than balance more than 1 Lac");
					System.out.println("2. fetchByType");
					System.out.println("3. avgBalanceByType");
					System.out.println("4. SortBycharacterInName");
					System.out.println("5. go back to main menu");
					
					System.out.println("Please enter your choice");
					int selection = scanner.nextInt();
					
					switch(selection) {
					
					case 1:{
						List<Account> accounts = service.balanceMoreThan1Lac();
						System.out.println("AccountNo\tAccountHolder\tBalance\tbranch\ttype");
						System.out.println("-----------------------------------------------------------");
						System.out.println(accounts.size());
						for (Account account : accounts) {
							System.out.println(account.getAccountNo()+"\t\t"+account.getAccountHolder()+"\t\t"+account.getBalance()+"\t\t"+account.getBranch()+"\t\t"+account.getType());
						}
					}
					break;
					case 2:{
						System.out.println("Please enter the account type");
						List<Account> accounts = service.fetchByType(scanner.next());
						System.out.println("AccountNo\tAccountHolder\tBalance\tbranch\ttype");
						System.out.println("-----------------------------------------------------------");
						System.out.println(accounts.size());
						for (Account account : accounts) {
							System.out.println(account.getAccountNo()+"\t\t"+account.getAccountHolder()+"\t\t"+account.getBalance()+"\t\t"+account.getBranch()+"\t\t"+account.getType());
						}
					}
					break;
					case 3:{
						System.out.println("Please enter the account type");
						double avgBalance = service.avgBalanceByType(scanner.next());
						System.out.println("Average balance is :: " +avgBalance);
					}
					break;
					
					case 5:{
						flag = false;
					}
					}
				}
			}
			break;
			
			case 7:{
				List<Account> accounts = new ArrayList<Account>(service.getAllAccount());
				try {
					service.exportData(accounts);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("All Accounts has been exported Successfully");
			}
			break;
			case 10: {
				flag = false;
			}
				break;
			}
		}
	}
}
