
package dao;

import entity.CompanyType;
import entity.User;
import java.sql.ResultSet;


public class UserDAO extends SuperDAO<User> {

    public User findByID(int id) {
        User u = null;
        try {
            String query = "select * from p_user where id='" + id + "'";
            ResultSet rs = this.st.executeQuery(query);
            while (rs.next()) {
                u = new User(rs.getInt("id"), rs.getString("mail"), rs.getString("password"));
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
            u = new User(rs.getInt("id"), rs.getString("mail"), rs.getString("password"));
        } catch (Exception e) {
        }
        return u;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from p_user where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(User t) {
        return "delete from p_user where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(User t) {
        return "update p_user set mail='" + t.getMail() + "' , password='" + t.getPassword() + "' where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from p_user";
    }

    @Override
    public String createQueryInsert(User t) {

        return "insert into p_user (mail,password) " + " values ('" + t.getMail()+ "' , '" + t.getPassword()+ "')";

       
    }

}
