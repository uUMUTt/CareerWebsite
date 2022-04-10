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
        User u = null;
        try {
            u = new User(rs.getInt("id"), rs.getString("mail"), rs.getNString("password"));
        } catch (Exception e) {
        }
        return u;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from User where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(User t) {
        return "delete from User where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(User t) {
        return "update User set mail='" + t.getMail() + "' , password='" + t.getPassword() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from Company";
    }

    @Override
    public String createQueryInsert(User t) {
        return "insert into CompanyType (title) values ('" + t.getMail()+ "' , '" + t.getPassword()+ "')";
    }
    
}
