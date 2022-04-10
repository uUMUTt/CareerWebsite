
package controller;

import dao.CompanyDAO;
import entity.Company;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Umut Karadas
 */
@Named(value = "companyController")
@SessionScoped
public class CompanyController implements Serializable {

    private CompanyDAO companyDAO;
    private Company company;
    private List<Company> companies;
    
    public CompanyController() {
    }
    
    public String create(){
        companyDAO.insert(company);
        company = new Company();
        return "company";
    }
    
    public String delete(Company p) {
        companyDAO.delete(p);
        return "company";
    }
    
    public String update() {
        companyDAO.update(company);
        company = new Company();
        return "company";
    }

    public CompanyDAO getCompanyDAO() {
        if(this.companyDAO == null) {
            this.companyDAO = new CompanyDAO();
        }
        return companyDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public Company getCompany() {
        if(this.company == null) {
            this.company = new Company();
        }
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Company> getCompanies() {
        this.companies = this.getCompanyDAO().readAll();
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
    
    
    
}
