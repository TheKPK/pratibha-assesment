package com.coustomer;


import com.ontomany.Invoice;

import javax.persistence.*;
import java.util.List;
//import javax.persistence.OneToMany;


@Entity
@Table(name = "Customer")

public class Customer {

//@Id
////@GeneratedValue(strategy=GenerationType.AUTO);
//@Column(name="custId",unique=true);

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "cname")
    private String customerName;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name="age")
    private int age;


//	writing setters and getters for the data

//	for id	
    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    //	for customerName
    public String getCustName(String customerName) {
        return customerName;
    }

    public void setCustName(String customerName) {
        this.customerName = customerName;

    }

    //	for contact number
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
