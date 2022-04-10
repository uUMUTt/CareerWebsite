/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ATG
 */
public class Company {
    private int id;
    private String companyName;
    private String address; 
    private String city;
    private String contactPersonName;
    private String contactPersonLastname;
    private String mobile;
    private CompanyType company;
    private String detail;
    private User user;

    public Company() {
        
    }
    
    public Company(int id, String companyName, String address, String city, String contactPersonName, String contactPersonLastname, String mobile, CompanyType company, String detail, User user) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.contactPersonName = contactPersonName;
        this.contactPersonLastname = contactPersonLastname;
        this.mobile = mobile;
        this.company = company;
        this.detail = detail;
        this.user = user;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonLastname() {
        return contactPersonLastname;
    }

    public void setContactPersonLastname(String contactPersonLastname) {
        this.contactPersonLastname = contactPersonLastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public CompanyType getCompany() {
        return company;
    }

    public void setCompany(CompanyType company) {
        this.company = company;
    }

    

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    
    
}
