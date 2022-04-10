/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CompanyType;
import entity.User;
import java.sql.ResultSet;

/**
 *
 * @author kalix
 */
public class UserDAO extends SuperDAO<User>{
    
    public User findByID(int id) {
        User u = null;
        try {
            String query  = "select * from User where id='"+id+"'";
            ResultSet rs = this.st.executeQuery(query);
            while(rs.next()) {
                u = new User(rs.getInt("id"), rs.getString("mail"),rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return u;
    }
    
    
    //***********************************************************

    @Override
    public User createEntity(ResultSet rs) {
    }

    @Override
    public String createQueryReadByID(int id) {
    }

    @Override
    public String createQueryDelete(User t) {
    }

    @Override
    public String createQueryUpdate(User t) {
    }

    @Override
    public String createQueryReadAll() {
    }

    @Override
    public String createQueryInsert(User t) {
    }
    
}
