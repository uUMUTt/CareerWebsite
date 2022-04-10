/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CompanyTypeDAO;
import dao.UserDAO;
import entity.CompanyType;
import entity.User;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.*;

/**
 *
 * @author Umut Karadas
 */
@FacesConverter("userConverter")
public class UserConverter implements Converter{
    
    private UserDAO userDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        User u = this.getUserDAO().findByID(id);
        return u;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        User u = (User)t;
        return String.valueOf(u.getId());
    }

    public UserDAO getUserDAO() {
        if(this.userDAO == null) {
            this.userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    

   
    
    
    
}
