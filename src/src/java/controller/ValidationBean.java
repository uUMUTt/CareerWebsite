/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;

/**
 *
 * @author kalix
 */
@Named(value = "validationBean")
@SessionScoped
public class ValidationBean implements Serializable {

    /**
     * Creates a new instance of ValidationBean
     */
    private String userName;
    private String password;

    public ValidationBean() {
    }

    public void register() {
        System.out.println("-------------------REGISTERED---------------------");
    }

    // BEAN VALIDATION
    public boolean validatePassword(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
        String s = (String) obj;

        if (s.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Password field cannot be empty"));
        } else {
            if (s.length() < 3) {
                throw new ValidatorException(new FacesMessage("Password length cannot be lower than 3"));
            }
        }

        return true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
