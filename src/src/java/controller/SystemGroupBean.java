/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SystemGroupDAO;
import entity.SystemGroup;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kalix
 */
@Named(value = "systemGroupBean")
@SessionScoped
public class SystemGroupBean implements Serializable {

    /**
     * Creates a new instance of SystemGroupBean
     */
    private SystemGroup entity;
    private List<SystemGroup> list;
    private SystemGroupDAO dao;

    //PAGINATION ATTRIBUTES
    private int page = 1;
    private int pageCount;

    public SystemGroupBean() {
    }

    public void clearForm() {
        entity = new SystemGroup();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new SystemGroup();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new SystemGroup();
    }

    public void delete() {
        this.getDao().delete(entity);
        entity = new SystemGroup();
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
        List<SystemGroup> list = this.getDao().readList();
        pageCount = (int) Math.ceil(list.size() / numOfRowOnPage);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public SystemGroup getEntity() {
        if (entity == null) {
            entity = new SystemGroup();
        }
        return entity;
    }

    public void setEntity(SystemGroup entity) {
        this.entity = entity;
    }

    public List<SystemGroup> getList() {
        list = this.getDao().readList(page);
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }

    public SystemGroupDAO getDao() {
        if (dao == null) {
            dao = new SystemGroupDAO();
        }
        return dao;
    }

    public void setDao(SystemGroupDAO dao) {
        this.dao = dao;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
