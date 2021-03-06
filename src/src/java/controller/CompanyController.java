
package controller;

import dao.CompanyDAO;
import entity.Company;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
    private int id;
    
    public CompanyController() {
        this.id = -1;
    }
    
    
    public void listAll() {
        this.id = -1;
    }
    
    public void create(){
        companyDAO.insert(company);
        company = new Company();
    }
    
    public void delete(Company p) {
        companyDAO.delete(p);
    }
    
    public void update() {
        companyDAO.update(company);
        company = new Company();
    }
    
    public void clearForm() {
        this.company = new Company();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void readByID() {
        this.companies = new ArrayList<>();
        this.companies.add(this.getCompanyDAO().readByID(this.id));
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
        if(this.id == -1){
           this.companies = this.getCompanyDAO().readAll(); 
        }
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
    
    
    
}
