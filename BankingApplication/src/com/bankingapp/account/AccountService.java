package com.bankingapp.account;

import java.util.Collection;

public interface AccountService {
	boolean addAccount(Account account);
	String updateAccount(int accountNo);
	boolean removeAccount(int accountNo);
	Account getAccount(int accountNo);
	Collection<Account> getAllAccount();
}
