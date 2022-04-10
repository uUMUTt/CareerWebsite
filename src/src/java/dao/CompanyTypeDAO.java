/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CompanyType;
import java.sql.ResultSet;

/**
 *
 * @author kalix
 */
public class CompanyTypeDAO extends SuperDAO<CompanyType>{
    
    public CompanyType findByID(int id) {
        CompanyType ct = null;
        try {
            String query  = "select * from CompanyType where id='"+id+"'";
            ResultSet rs = this.st.executeQuery(query);
            while(rs.next()) {
                ct = new CompanyType(rs.getInt("id"), rs.getString("title"));
            }
        } catch (Exception e) {
        }
        return ct;
    }
    
    
    
    
    //***********************************************************

    @Override
    public CompanyType createEntity(ResultSet rs) {
    }

    @Override
    public String createQueryReadByID(int id) {
    }

    @Override
    public String createQueryDelete(CompanyType t) {
    }

    @Override
    public String createQueryUpdate(CompanyType t) {
    }

    @Override
    public String createQueryReadAll() {
    }

    @Override
    public String createQueryInsert(CompanyType t) {
    }
    
}
