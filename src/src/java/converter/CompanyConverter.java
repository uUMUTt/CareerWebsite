
package converter;

import dao.CompanyDAO;
import entity.Company;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.*;

/**
 *
 * @author Umut Karadas
 */
@FacesConverter("companyConverter")
public class CompanyConverter implements Converter{
    
    private CompanyDAO companyDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Company c = this.getCompanyDAO().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Company c = (Company)t;
        return String.valueOf(c.getId());
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

    

   
    
    
}
