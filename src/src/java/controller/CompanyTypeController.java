
package controller;

import dao.CompanyTypeDAO;
import entity.CompanyType;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umut Karadas
 */
@Named(value = "companyTypeController")
@SessionScoped
public class CompanyTypeController implements Serializable {

    private CompanyTypeDAO companyTypeDAO;
    private CompanyType companyType;
    private List<CompanyType> companyTypes;
    private int id;
    
    public CompanyTypeController() {
        this.id = -1;
    }
    
    public String listAll() {
        this.id = -1;
        return "company_type";
    }
    
    public String readByID() {
        this.companyTypes = new ArrayList<>();
        this.companyTypes.add(this.getCompanyTypeDAO().readByID(this.id));
        return "company_type";
    }
    
    public String create(){
        companyTypeDAO.insert(companyType);
        companyType = new CompanyType();
        return "company_type";
    }
    
    public String delete(CompanyType p) {
        companyTypeDAO.delete(p);
        return "company_type";
    }
    
    public String update() {
        companyTypeDAO.update(companyType);
        companyType = new CompanyType();
        return "company_type";
    }

    public CompanyTypeDAO getCompanyTypeDAO() {
        if(this.companyTypeDAO == null) {
            this.companyTypeDAO = new CompanyTypeDAO();
        }
        return companyTypeDAO;
    }

    public void setCompanyTypeDAO(CompanyTypeDAO companyTypeDAO) {
        this.companyTypeDAO = companyTypeDAO;
    }

    public CompanyType getCompanyType() {
        if(this.companyType == null) {
            this.companyType = new CompanyType();
        }
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public List<CompanyType> getCompanyTypes() {
         if(this.id == -1){
           this.companyTypes = this.getCompanyTypeDAO().readAll(); 
        }
        return companyTypes;
    }

    public void setCompanyTypes(List<CompanyType> companyTypes) {
        this.companyTypes = companyTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
