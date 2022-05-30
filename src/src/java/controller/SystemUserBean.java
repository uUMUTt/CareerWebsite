/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SystemUserDAO;
import entity.SystemGroup;
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
    
    //PAGINATION ATTRIBUTES
    private int page = 1;
    private int pageCount;
    //*************************

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
    
    //FOR PAGINATION

    public void nextPage() {
        page++;
        if (page > pageCount) {
            page = pageCount;
        }
    }

    public void previousPage() {
        page--;
        if (page < 1) {
            page = 1;
        }
    }

    public int getPageCount() {
        int numOfRowOnPage = 5;
        List<SystemUser> list = this.getDao().readList();
        pageCount = (int) Math.ceil(list.size() / numOfRowOnPage);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    //********************************************

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
        //PAGINATION
        list = this.getDao().readList(page);
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
