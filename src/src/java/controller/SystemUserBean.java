/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SystemUserDAO;
import entity.SystemUser;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kalix
 */
@Named(value = "systemUserBean")
@SessionScoped
public class SystemUserBean implements Serializable {

    /**
     * Creates a new instance of SystemUserBean
     */
    private SystemUser entity;
    private List<SystemUser> list;
    private SystemUserDAO dao;

    public SystemUserBean() {
    }

    public void clearForm() {
        entity = new SystemUser();
    }
    
    public void create() {
        this.getDao().create(entity);
        entity = new SystemUser();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new SystemUser();
    }

    public void delete() {
        this.getDao().delete(entity);
        entity = new SystemUser();
    }

    public SystemUser getEntity() {
        if (entity == null) {
            entity = new SystemUser();
        }
        return entity;
    }

    public void setEntity(SystemUser entity) {
        this.entity = entity;
    }

    public List<SystemUser> getList() {
        list = this.getDao().readList();
        return list;
    }

    public void setList(List<SystemUser> list) {
        this.list = list;
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

}
