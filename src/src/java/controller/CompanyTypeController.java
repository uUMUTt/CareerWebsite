
package controller;

import dao.CompanyTypeDAO;
import entity.CompanyType;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    
    public CompanyTypeController() {
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
        this.companyTypes = this.getCompanyTypeDAO().readAll();
        return companyTypes;
    }

    public void setCompanyTypes(List<CompanyType> companyTypes) {
        this.companyTypes = companyTypes;
    }
    
    
}
