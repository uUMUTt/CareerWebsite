/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CompanyContactUsMessage;
import entity.JobSeekerContactUsMessage;
import jakarta.resource.cci.ResultSet;

/**
 *
 * @author ATG
 */
public class CompanyContactUsMessageDAO extends SuperDAO<CompanyContactUsMessage> {

    private CompanyDAO CompanyDAO;

    @Override
    public CompanyContactUsMessage createEntity(java.sql.ResultSet rs) {
        CompanyContactUsMessage jm = null;
        try {
            jm = new CompanyContactUsMessage(this.getCompanyDAO().findByID(rs.getInt("from_p")),
                    rs.getInt("id"), rs.getString("subject"), rs.getString("content"), rs.getString("date"));
        } catch (Exception e) {
        }
        return jm;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from CompanyContactUsMessage where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(CompanyContactUsMessage t) {
        return "delete from CompanyContactUsMessage where id='" + t.getId() + "'";

    }

    @Override
    public String createQueryUpdate(CompanyContactUsMessage t) {
        return "update CompanyContactUsMessage set subject='" + t.getSubject() + "' , content='" + t.getText() + "' where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from CompanyContactUsMessage";
    }

    @Override
    public String createQueryInsert(CompanyContactUsMessage t) {
        return "insert into CompanyContactUsMessage (from_p, subject, content) values ('" + t.getFrom() + "' , '" + t.getSubject() + "' , '" + t.getText() + "')";
    }

    public CompanyDAO getCompanyDAO() {
        return CompanyDAO;
    }

    public void setCompanyDAO(CompanyDAO CompanyDAO) {
        this.CompanyDAO = CompanyDAO;
    }

   
}
