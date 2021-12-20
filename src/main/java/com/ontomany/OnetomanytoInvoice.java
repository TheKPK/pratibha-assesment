package com.ontomany;

import com.country.Country;
import com.coustomer.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class OnetomanytoInvoice {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            emf = Persistence.createEntityManagerFactory("customerdata");
            entityManager = emf.createEntityManager();

            transaction = entityManager.getTransaction();

            // start transaction
            transaction.begin();

            Country country = entityManager.getReference(Country.class, 2);

//            int id = Integer.parseInt(String.valueOf(country));

            // entity
            Company company = new Company();
            company.setCompanyName("PWC");
            company.setRegno("UK");
            company.setContactNo("+44-408-575-1317");
            company.setCountry(country);

            Invoice invoice1 = new Invoice();
            invoice1.setAmount(12000);
            invoice1.setCompany(company);

            Invoice invoice2 = new Invoice();
            invoice2.setAmount(15000);
            invoice2.setCompany(company);

            List<Invoice> invoiceList = new ArrayList();
            invoiceList.add(invoice1);
            invoiceList.add(invoice2);

            company.setListInvoice(invoiceList);
            company.getListInvoice().add(invoice2);

            // save call
            entityManager.persist(company);
            System.out.println("Company details successfull....");

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
            if (transaction.isActive()) {
                transaction.commit();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
