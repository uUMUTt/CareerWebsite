/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PrivilegesDAO;
import entity.Privileges;
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
@Named(value = "privilegesBean")
@SessionScoped
public class PrivilegesBean implements Serializable {

    /**
     * Creates a new instance of PrivilegesBean
     */
    private Privileges entity;
    private List<Privileges> list;
    private PrivilegesDAO dao;
    
    //PAGINATION ATTRIBUTES
    private int page = 1;
    private int pageCount;
    //*************************

    public PrivilegesBean() {
    }

    public Privileges getPrivileges(SystemGroup systemGroup, String module) {
        return this.getDao().getGroupPrivileges(systemGroup, module);
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
        double numOfRowOnPage = 5;
        List<Privileges> list = this.getDao().readList();
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

    public void clearForm() {
        entity = new Privileges();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Privileges();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Privileges();
    }

    public void delete() {
        this.getDao().delete(entity);
        entity = new Privileges();
    }

    public Privileges getEntity() {
        if (entity == null) {
            entity = new Privileges();
        }
        return entity;
    }

    public void setEntity(Privileges entity) {
        this.entity = entity;
    }

    public List<Privileges> getList() {
        list = this.getDao().readList(page);
        return list;
    }

    public void setList(List<Privileges> list) {
        this.list = list;
    }

    public PrivilegesDAO getDao() {
        if (dao == null) {
            dao = new PrivilegesDAO();
        }
        return dao;
    }

    public void setDao(PrivilegesDAO dao) {
        this.dao = dao;
    }

}
