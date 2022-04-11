/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CompanyMessageDAO;
import entity.CompanyMessage;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umut Karadas
 */
@Named(value = "companyMessageController")
@SessionScoped
public class CompanyMessageController implements Serializable{

    
    private CompanyMessageDAO companyMessageDAO;
    private CompanyMessage companyMessage;
    private List<CompanyMessage> companyMessages;
    private int id;
    
    public CompanyMessageController() {
        this.id = -1;
    }

    public String listAll() {
        this.id = -1;
        return "companymessage";
    }
    
    public String create(){
        companyMessageDAO.insert(companyMessage);
        companyMessage = new CompanyMessage();
        return "companymessage";
    }
    
    public String delete(CompanyMessage cm) {
        companyMessageDAO.delete(cm);
        return "companymessage";
    }
    
    public String update() {
        companyMessageDAO.update(companyMessage);
        companyMessage = new CompanyMessage();
        return "companymessage";
    }
    
    public String readByID() {
        this.companyMessages = new ArrayList<>();
        this.companyMessages.add(this.getCompanyMessageDAO().readByID(this.id));
        return "companymessage";
    }
    
    public CompanyMessageDAO getCompanyMessageDAO() {
        if(this.companyMessageDAO == null) {
            this.companyMessageDAO = new CompanyMessageDAO();
        }
        return companyMessageDAO;
    }

    public void setCompanyMessageDAO(CompanyMessageDAO companyMessageDAO) {
        this.companyMessageDAO = companyMessageDAO;
    }

    public CompanyMessage getCompanyMessage() {
        if(this.companyMessage == null) {
            this.companyMessage = new CompanyMessage();
        }
        return companyMessage;
    }

    public void setCompanyMessage(CompanyMessage companyMessage) {
        this.companyMessage = companyMessage;
    }

    public List<CompanyMessage> getCompanyMessages() {
        if(this.id == -1){
           this.companyMessages = this.getCompanyMessageDAO().readAll(); 
        }
        return companyMessages;
    }

    public void setCompanyMessages(List<CompanyMessage> companyMessages) {
        this.companyMessages = companyMessages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
