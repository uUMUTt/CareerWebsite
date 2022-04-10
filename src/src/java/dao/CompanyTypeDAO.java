/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Company;
import entity.CompanyType;
import java.sql.ResultSet;

/**
 *
 * @author kalix
 */
public class CompanyTypeDAO extends SuperDAO<CompanyType> {

    public CompanyType findByID(int id) {
        CompanyType ct = null;
        try {
            String query = "select * from CompanyType where id='" + id + "'";
            ResultSet rs = this.st.executeQuery(query);
            while (rs.next()) {
                ct = new CompanyType(rs.getInt("id"), rs.getString("title"));
            }
        } catch (Exception e) {
        }
        return ct;
    }

    //***********************************************************
    @Override
    public CompanyType createEntity(ResultSet rs) {
        CompanyType ct = null;
        try {
            ct = new CompanyType(rs.getInt("id"), rs.getString("title"));
        } catch (Exception e) {
        }
        return ct;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from CompanyType where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(CompanyType t) {
        return "delete from CompanyType where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(CompanyType t) {
        return "update CompanyType set title='" + t.getTitle() +"'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from CompanyType";
    }

    @Override
    public String createQueryInsert(CompanyType t) {
        return "insert into CompanyType (title) values ('" + t.getTitle() + "')";
    }

}
