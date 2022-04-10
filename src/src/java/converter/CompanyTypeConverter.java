/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CompanyTypeDAO;
import entity.CompanyType;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.*;

/**
 *
 * @author Umut Karadas
 */
@FacesConverter("companyTypeConverter")
public class CompanyTypeConverter implements Converter{
    
    private CompanyTypeDAO companyTypeDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        CompanyType ct = this.getCompanyTypeDAO().findByID(id);
        return ct;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        CompanyType ct = (CompanyType)t;
        return String.valueOf(ct.getId());
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

   
    
    
    
}
