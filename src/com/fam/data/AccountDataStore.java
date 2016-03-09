package com.fam.data;

import java.util.HashMap;

import com.fam.domain.AccountDetails;

/**
 * Loads dummy data for the web service.
 * @author forum
 *
 */
public class AccountDataStore {
	
	private static AccountDataStore instance = null;
	private static HashMap<Long, AccountDetails> userAccounts = new HashMap<Long,AccountDetails>(); 
	protected  AccountDataStore(){
		super();
	}

	public static AccountDataStore getInstance(){
		if(instance == null) {
	         instance = new AccountDataStore();
	      }
	      return instance;
	}
	
	public void loadData(){
		AccountDetails account1 = new AccountDetails();
		account1.setAccountId(1000001L);
		account1.setAddress("41 Regency Court");
		account1.setCurrentBalance(1000D);
		account1.setEmailId("abc@test.com");
		account1.setFirstName("Don");
		account1.setLastName("Draper");
		userAccounts.put(1000001L, account1);
		AccountDetails account2 = new AccountDetails();
		account2.setAccountId(1000002L);
		account2.setAddress("42 Regency Court");
		account2.setCurrentBalance(1500D);
		account2.setEmailId("def@test.com");
		account2.setFirstName("Betty");
		account2.setLastName("Draper");
		userAccounts.put(1000002L, account2);
		AccountDetails account3 = new AccountDetails();
		account3.setAccountId(1000003L);
		account3.setAddress("43 Regency Court");
		account3.setCurrentBalance(2000D);
		account3.setEmailId("ghi@test.com");
		account3.setFirstName("Alicia");
		account3.setLastName("Florrick");
		userAccounts.put(1000003L, account3);
		AccountDetails account4 = new AccountDetails();
		account4.setAccountId(1000004L);
		account4.setAddress("44 Regency Court");
		account4.setCurrentBalance(2000D);
		account4.setEmailId("jkl@test.com");
		account4.setFirstName("Peter");
		account4.setLastName("Florrick");
		userAccounts.put(1000004L, account4);
		AccountDetails account5 = new AccountDetails();
		account5.setAccountId(1000005L);
		account5.setAddress("45 Regency Court");
		account5.setCurrentBalance(2500D);
		account5.setEmailId("mno@test.com");
		account5.setFirstName("Luke");
		account5.setLastName("Skywalker");
		userAccounts.put(1000005L, account5);
		AccountDetails account6 = new AccountDetails();
		account6.setAccountId(1000006L);
		account6.setAddress("46 Regency Court");
		account6.setCurrentBalance(3000D);
		account6.setEmailId("pqr@test.com");
		account6.setFirstName("C3PO");
		account6.setLastName("Droid");
		userAccounts.put(1000006L, account6);
		AccountDetails account7 = new AccountDetails();
		account7.setAccountId(1000007L);
		account7.setAddress("47 Regency Court");
		account7.setCurrentBalance(3500D);
		account7.setEmailId("stu@test.com");
		account7.setFirstName("Darth");
		account7.setLastName("Vader");
		userAccounts.put(1000007L, account7);
		AccountDetails account8 = new AccountDetails();
		account8.setAccountId(1000008L);
		account8.setAddress("48 Regency Court");
		account8.setCurrentBalance(4000D);
		account8.setEmailId("vwx@test.com");
		account8.setFirstName("Han");
		account8.setLastName("Solo");
		userAccounts.put(1000008L, account8);
		AccountDetails account9 = new AccountDetails();
		account9.setAccountId(1000009L);
		account9.setAddress("49 Regency Court");
		account9.setCurrentBalance(4500D);
		account9.setEmailId("yza@test.com");
		account9.setFirstName("R2D2");
		account9.setLastName("Droid");
		userAccounts.put(1000009L, account9);
		AccountDetails account10 = new AccountDetails();
		account10.setAccountId(1000010L);
		account10.setAddress("50 Regency Court");
		account10.setCurrentBalance(5000D);
		account10.setEmailId("bcd@test.com");
		account10.setFirstName("Obi-Wan");
		account10.setLastName("Kenobi");
		userAccounts.put(1000010L, account10);
	}
	
	public static HashMap<Long, AccountDetails> getUserAccounts(){
		return userAccounts;
	}
}
