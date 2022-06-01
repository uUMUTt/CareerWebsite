/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SystemUserDAO;
import entity.SystemUser;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author kalix
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    /**
     * Creates a new instance of SessionBean
     */
    private SystemUser user;
    private SystemUserDAO dao;
    private String email;
    private String password;

    public SessionBean() {
    }

    public String login() {
        SystemUser user = this.getDao().getUser(email, password);

        if (user != null) { //TRUE LOGIN
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user); //To put user attribute input in session
            return "/Panel/panel?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage("Email or password is incorrect", new FacesMessage("Email or password is incorrect"));
            return "/index?faces-redirect=true";
        }
    }
      
    public String clearForm() {
        email = "";
        password = "";
        user = new SystemUser();
        return "/index?faces-redirect=true";
    }

    public SystemUser getUser() {
        if (user == null) {
            user = new SystemUser();
        }
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public SystemUserDAO getDao() {
        if (dao == null) {
            dao = new SystemUserDAO();
        }
        return dao;
    }

    public void setDao(SystemUserDAO dao) {
        this.dao = dao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
