
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import entity.CompanyContactUsMessage;
import dao.CompanyContactUsMessageDAO;
import java.util.List;
import java.util.ArrayList;


@Named(value = "companyContactUsMessageController")
@SessionScoped
public class CompanyContactUsMessageController implements Serializable {

    private CompanyContactUsMessage companyContactUsMessage;
    private CompanyContactUsMessageDAO companyContactUsMessageDAO;
    private List<CompanyContactUsMessage> companyContactUsMessages;
    private int id;
    
    public CompanyContactUsMessageController() {
        this.id = -1;
    }
    
     public String listAll() {
        this.id = -1;
        return "company_contactus_message";
    }

    public String readByID() {
        this.companyContactUsMessages = new ArrayList<>();
        this.companyContactUsMessages.add(this.getCompanyContactUsMessageDAO().readByID(this.id));
        return "company_contactus_message";
    }

    public String create() {
        companyContactUsMessageDAO.insert(companyContactUsMessage);
        companyContactUsMessage = new CompanyContactUsMessage();
        return "company_contactus_message";
    }

    public String delete(CompanyContactUsMessage p) {
        companyContactUsMessageDAO.delete(p);
        return "company_contactus_message";
    }

    public String update() {
        companyContactUsMessageDAO.update(companyContactUsMessage);
        companyContactUsMessage = new CompanyContactUsMessage();
        return "company_contactus_message";
    }

    public CompanyContactUsMessage getCompanyContactUsMessage() {
        if (this.companyContactUsMessage == null) {
            this.companyContactUsMessage = new  CompanyContactUsMessage();
        }
        return companyContactUsMessage;
    }

    public void setCompanyContactUsMessage(CompanyContactUsMessage companyContactUsMessage) {
        this.companyContactUsMessage = companyContactUsMessage;
    }

    public CompanyContactUsMessageDAO getCompanyContactUsMessageDAO() {
        if (this.companyContactUsMessageDAO == null) {
            this.companyContactUsMessageDAO = new CompanyContactUsMessageDAO();
        }
        return companyContactUsMessageDAO;
    }

    public void setCompanyContactUsMessageDAO(CompanyContactUsMessageDAO companyContactUsMessageDAO) {
        this.companyContactUsMessageDAO = companyContactUsMessageDAO;
    }

    public List<CompanyContactUsMessage> getCompanyContactUsMessages() {
        if (this.id == -1) {
            this.companyContactUsMessages = this.getCompanyContactUsMessageDAO().readAll();
        }
        return companyContactUsMessages;
    }

    public void setCompanyContactUsMessages(List<CompanyContactUsMessage> companyContactUsMessages) {
        this.companyContactUsMessages = companyContactUsMessages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
