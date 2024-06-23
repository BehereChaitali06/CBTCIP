package com.chaitali.basic.presentation;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.AtmCard;
import com.chaitali.basic.entity.Bank;
import com.chaitali.basic.entity.Customer;

public class BankDummyData {

	public static void main(String[] args) {
		
		Bank bank1 = new Bank();
		Bank bank2 = new Bank();
		//Bank bank3 = new Bank();
		
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
		Customer customer4 = new Customer();
		Customer customer5 = new Customer();
		Customer customer6 = new Customer();
		Customer customer7 = new Customer();
		Customer customer8 = new Customer();
		Customer customer9 = new Customer();
		Customer customer10 = new Customer();
		
		AtmCard atmCard1 = new AtmCard();
		AtmCard atmCard2 = new AtmCard();
		AtmCard atmCard3 = new AtmCard();
		AtmCard atmCard4 = new AtmCard();
		AtmCard atmCard5 = new AtmCard();
		AtmCard atmCard6 = new AtmCard();
		AtmCard atmCard7 = new AtmCard();
		AtmCard atmCard8 = new AtmCard();
		AtmCard atmCard9 = new AtmCard();
		AtmCard atmCard10 = new AtmCard();
		
		Account account1 = new Account();
		Account account2 = new Account();
		Account account3 = new Account();
		Account account4 = new Account();
		Account account5 = new Account();
		Account account6 = new Account();
		Account account7 = new Account();
		Account account8 = new Account();
		Account account9 = new Account();
		Account account10 = new Account();
		
		List<Account> lisAccount1 = List.of(account1,account2,account5,account7,account9);
		List<Account> lisAccount2 = List.of(account3,account4,account6,account8,account10);
		//List<Account> lisAccount3 = List.of(account6,account7);
		
		List<Customer> listCustomer1 = List.of(customer1,customer2,customer5,customer7,customer9);
		List<Customer> listCustomer2 = List.of(customer3,customer4,customer6,customer8,customer10);
		//List<Customer> listCustomer3 = List.of(customer6,customer7);
		
		bank1.setIfscCode("ICIC0001096");
		bank1.setBankName("ICICI Bank");
		bank1.setBranchCode("001096");
		bank1.setCustomer(listCustomer1);

		bank2.setIfscCode("HDFC0001784");
		bank2.setBankName("HDFC Bank");
		bank2.setBranchCode("001784 ");
		bank2.setCustomer(listCustomer2);
		
		/*bank3.setIfscCode("SBIN0020885");
		bank3.setBankName("SBI Bank");
		bank3.setBranchCode("006756 ");
		bank3.setCustomer(listCustomer3);*/
		
		customer1.setCustomerId(581692841);
		customer1.setCustomerName("Yog Behere");
		customer1.setAddress("Pune 411038");
		customer1.setCustomerContact("9766220440");
		customer1.setDateOfBirth("02/05/1994");
		customer1.setGender('M');
		customer1.setEmailId("yogbehere94@gmail.com");
		customer1.setPanNumber("BCZPC0097H");
		customer1.setAadharNumber("772273260188");
		customer1.setBank(bank1);
		customer1.setAccount(lisAccount1); 
		
		
		customer2.setCustomerId(872953219);
		customer2.setCustomerName("Jay Mandal");
		customer2.setAddress("Dhule 424001");
		customer2.setCustomerContact("9766103403");
		customer2.setDateOfBirth("17/05/1992");
		customer2.setGender('M');
		customer2.setEmailId("jaiprakash07@gmail.com");
		customer2.setPanNumber("PCQER5729P");
		customer2.setAadharNumber("944832007122");
		customer2.setBank(bank1);
		customer2.setAccount(lisAccount2);
		
		customer3.setCustomerId(732891806);
		customer3.setCustomerName("Yog Behere");
		customer3.setAddress("Pune 411038");
		customer3.setCustomerContact("9766220440");
		customer3.setDateOfBirth("02/05/1994");
		customer3.setGender('M');
		customer3.setEmailId("yogbehere94@gmail.com");
		customer3.setPanNumber("BCZPC0097H");
		customer3.setAadharNumber("772273260188");
		customer3.setBank(bank2);
		customer3.setAccount(lisAccount1);
		
		
		customer4.setCustomerId(248129624);
		customer4.setCustomerName("Jay Mandal");
		customer4.setAddress("Dhule 424001");
		customer4.setCustomerContact("9766103403");
		customer4.setDateOfBirth("17/05/1992");
		customer4.setGender('M');
		customer4.setEmailId("jaiprakash07@gmail.com");
		customer4.setPanNumber("PCQER5729P");
		customer4.setAadharNumber("944832007122");
		customer4.setBank(bank2);
		customer4.setAccount(lisAccount2);
		
		customer5.setCustomerId(174249777);
		customer5.setCustomerName("Gayatri Patil");
		customer5.setAddress("Shirpur");
		customer5.setCustomerContact("9922867903");
		customer5.setDateOfBirth("24/12/1999");
		customer5.setGender('F');
		customer5.setEmailId("gayatripatil241@gmail.com");
		customer5.setPanNumber("CKJPJ2395E");
		customer5.setAadharNumber("571233742026");
		customer5.setBank(bank1);
		customer5.setAccount(lisAccount1);

		customer6.setCustomerId(113223377);
		customer6.setCustomerName("Vijaya Badgujar");
		customer6.setAddress("Mumbai");
		customer6.setCustomerContact("9067718645");
		customer6.setDateOfBirth("11/10/2000");
		customer6.setGender('F');
		customer6.setEmailId("vijaya@gmail.com");
		customer6.setPanNumber("DH54642366");
		customer6.setAadharNumber("949014671599");
		customer6.setBank(bank2);
		customer6.setAccount(lisAccount2);
		
		customer7.setCustomerId(593018730);
		customer7.setCustomerName("Vaishnavi Patil");
		customer7.setAddress("Mahavir Colony Jalgaon");
		customer7.setCustomerContact("9730710368");
		customer7.setDateOfBirth("08/02/2002");
		customer7.setGender('F');
		customer7.setEmailId("patilvaishnavi7@gmail.com");
		customer7.setPanNumber("KLAPK7085N");
		customer7.setAadharNumber("645921345471");
		customer7.setBank(bank1);
		customer7.setAccount(lisAccount1);
		
		customer8.setCustomerId(593018765);
		customer8.setCustomerName("Vaishnavi Patil");
		customer8.setAddress("Mahavir Colony Jalgaon");
		customer8.setCustomerContact("9730710368");
		customer8.setDateOfBirth("08/02/2002");
		customer8.setGender('F');
		customer8.setEmailId("patilvaishnavi7@gmail.com");
		customer8.setPanNumber("KLAPK7085N");
		customer8.setAadharNumber("645921345471");
		customer8.setBank(bank2);
		customer8.setAccount(lisAccount2);
		
		customer9.setCustomerId(859327106);
		customer9.setCustomerName("Chaitali Behere");
		customer9.setAddress("Shindkheda 425406");
		customer9.setCustomerContact("9021814242");
		customer9.setDateOfBirth("20/07/2001");
		customer9.setGender('F');
		customer9.setEmailId("beherechaitali@gmail.com");
		customer9.setPanNumber("BOVPC2055P");
		customer9.setAadharNumber("512144832009");
		customer9.setBank(bank1);
		customer9.setAccount(lisAccount1);
		
		customer10.setCustomerId(784759873);
		customer10.setCustomerName("Chaitali Behere");
		customer10.setAddress("Shindkheda 425406");
		customer10.setCustomerContact("9021814242");
		customer10.setDateOfBirth("20/07/2001");
		customer10.setGender('F');
		customer10.setEmailId("beherechaitali@gmail.com");
		customer10.setPanNumber("BOVPC2055P");
		customer10.setAadharNumber("512144832009");
		customer10.setBank(bank2);
		customer10.setAccount(lisAccount2);
		
		atmCard1.setCardNo("4035620367319009");
		atmCard1.setCardPin("2435");
		atmCard1.setCardStatus("Active");
		atmCard1.setCardType("Visa");
		atmCard1.setCvvNo("236");
		atmCard1.setIssueDate(LocalDate.now());
		atmCard1.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard1.setAccount(account1);
		
		atmCard2.setCardNo("7951926185390520");
		atmCard2.setCardPin("4592");
		atmCard2.setCardStatus("Active");
		atmCard2.setCardType("Visa");
		atmCard2.setCvvNo("569");
		atmCard2.setIssueDate(LocalDate.now());
		atmCard2.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard2.setAccount(account2);
		
		atmCard3.setCardNo("9372106293517280");
		atmCard3.setCardPin("8193");
		atmCard3.setCardStatus("Active");
		atmCard3.setCardType("Visa");
		atmCard3.setCvvNo("885");
		atmCard3.setIssueDate(LocalDate.now());
		atmCard3.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard3.setAccount(account3);
		
		atmCard4.setCardNo("3555602363918219");
		atmCard4.setCardPin("4578");
		atmCard4.setCardStatus("Active");
		atmCard4.setCardType("Visa");
		atmCard4.setCvvNo("974");
		atmCard4.setIssueDate(LocalDate.now());
		atmCard4.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard4.setAccount(account4);
				
		atmCard5.setCardNo("5419190535912508");
		atmCard5.setCardPin("7645");
		atmCard5.setCardStatus("Active");
		atmCard5.setCardType("Visa");
		atmCard5.setCvvNo("330");
		atmCard5.setIssueDate(LocalDate.now());
		atmCard5.setExpiryDate(LocalDate.of(2026, 07, 06));
		atmCard5.setAccount(account5);
		
		atmCard6.setCardNo("4539890694174101");
		atmCard6.setCardPin("2354");
		atmCard6.setCardStatus("Active");
		atmCard6.setCardType("Visa");
		atmCard6.setCvvNo("890");
		atmCard6.setIssueDate(LocalDate.now());
		atmCard6.setExpiryDate(LocalDate.of(2025, 11, 21));
		atmCard6.setAccount(account6);
		
		atmCard7.setCardNo("8174060132287837");
		atmCard7.setCardPin("2083");
		atmCard7.setCardStatus("Active");
		atmCard7.setCardType("Debit");
		atmCard7.setCvvNo("372");
		atmCard7.setIssueDate(LocalDate.now());
		atmCard7.setExpiryDate(LocalDate.of(2027, 07, 01));
		atmCard7.setAccount(account7);
		
		atmCard8.setCardNo("7319009403562036");
		atmCard8.setCardPin("6754");
		atmCard8.setCardStatus("Active");
		atmCard8.setCardType("Debit");
		atmCard8.setCvvNo("786");
		atmCard8.setIssueDate(LocalDate.now());
		atmCard8.setExpiryDate(LocalDate.of(2028, 01, 12));
		atmCard8.setAccount(account8);
		
		atmCard9.setCardNo("3905207951926185");
		atmCard9.setCardPin("7521");
		atmCard9.setCardStatus("Active");
		atmCard9.setCardType("Visa");
		atmCard9.setCvvNo("806");
		atmCard9.setIssueDate(LocalDate.now());
		atmCard9.setExpiryDate(LocalDate.of(2024, 11, 20));
		atmCard9.setAccount(account9);
		
		atmCard10.setCardNo("8520795193905261");
		atmCard10.setCardPin("5291");
		atmCard10.setCardStatus("Active");
		atmCard10.setCardType("Visa");
		atmCard10.setCvvNo("521");
		atmCard10.setIssueDate(LocalDate.now());
		atmCard10.setExpiryDate(LocalDate.of(2024, 07, 10));
		atmCard10.setAccount(account10);
		
		account1.setAccountNo("10960100562");
		account1.setAccountOpeningDate(LocalDate.now().toString());
		account1.setAccountStatus("Active");
		account1.setAccountType("Saving");
		account1.setBalance(45000);
		account1.setCustomer(customer1);
		account1.setAtmCard(atmCard1);
		account1.setTransaction(null);
		
		account2.setAccountNo("50100920319407");
		account2.setAccountOpeningDate(LocalDate.now().toString());
		account2.setAccountStatus("Active");
		account2.setAccountType("Current");
		account2.setBalance(65000);
		account2.setCustomer(customer2);
		account2.setAtmCard(atmCard2);
		account2.setTransaction(null);
		
		account3.setAccountNo("10960659059");
		account3.setAccountOpeningDate(LocalDate.now().toString());
		account3.setAccountStatus("Active");
		account3.setAccountType("Saving");
		account3.setBalance(39000);
		account3.setCustomer(customer1);
		account3.setAtmCard(atmCard3);
		account3.setTransaction(null);
		
		account4.setAccountNo("50100386357831");
		account4.setAccountOpeningDate(LocalDate.now().toString());
		account4.setAccountStatus("Active");
		account4.setAccountType("Current");
		account4.setBalance(79000);
		account4.setCustomer(customer2);
		account4.setAtmCard(atmCard4);
		account4.setTransaction(null);
		
		account5.setAccountNo("50100441134660");
		account5.setAccountOpeningDate(LocalDate.now().toString());
		account5.setAccountStatus("Active");
		account5.setAccountType("Saving");
		account5.setBalance(3000);
		account5.setCustomer(customer5);
		account5.setAtmCard(atmCard5);
		account5.setTransaction(null);
		
		account6.setAccountNo("62123456769");
		account6.setAccountOpeningDate(LocalDate.now().toString());
		account6.setAccountStatus("Active");
		account6.setAccountType("Current");
		account6.setBalance(15000);
		account6.setCustomer(customer6);
		account6.setAtmCard(atmCard6);
		account6.setTransaction(null);
		
		account7.setAccountNo("46605010044113");
		account7.setAccountOpeningDate(LocalDate.now().toString());
		account7.setAccountStatus("Active");
		account7.setAccountType("Saving");
		account7.setBalance(2000);
		account7.setCustomer(customer6);
		account7.setAtmCard(atmCard7);
		account7.setTransaction(null);
		 
		account8.setAccountNo("45676962123");
		account8.setAccountOpeningDate(LocalDate.now().toString());
		account8.setAccountStatus("Active");
		account8.setAccountType("Current");
		account8.setBalance(39000);
		account8.setCustomer(customer5);
		account8.setAtmCard(atmCard8);
		account8.setTransaction(null);
		
		account9.setAccountNo("41134660501004");
		account9.setAccountOpeningDate(LocalDate.now().toString());
		account9.setAccountStatus("Active");
		account9.setAccountType("Saving");
		account9.setBalance(25000);
		account9.setCustomer(customer6);
		account9.setAtmCard(atmCard9);
		account9.setTransaction(null);
		
		account10.setAccountNo("20602372134");
		account10.setAccountOpeningDate(LocalDate.now().toString());
		account10.setAccountStatus("Active");
		account10.setAccountType("Saving");
		account10.setBalance(4000);
		account10.setCustomer(customer6);
		account10.setAtmCard(atmCard10);
		account10.setTransaction(null);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raj");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
			entityManager.persist(bank1);
			entityManager.persist(bank2);
			//entityManager.persist(bank3);
		entityTransaction.commit();
		
		System.out.println("Object Saved Successfully !!!!");
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}

}