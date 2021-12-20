package com.coustomer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerSave {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager etManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("customerdata");
			etManager = emf.createEntityManager();
			transaction = etManager.getTransaction();
//			start Transaction
			transaction.begin();

//			Customer creation and saving 
			Customer cust = new Customer();
			String custName = "pratibha";
			String contNumber = "p492925536";
			int age=30;
			// cust.setID(id);
			cust.setAge(age);
			cust.setCustName(custName);
			cust.setContactNo(contNumber);
			etManager.persist(cust);
			transaction.commit();
			etManager.close();

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			if (transaction.isActive()) {
				transaction.commit();
			}
			if (etManager != null) {
				etManager.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

}
