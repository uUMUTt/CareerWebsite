
package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Umut Karadas
 */
public abstract class SuperDAO<T> extends DBConnection {
    protected List<T> list;
    protected Connection DB;
    protected Statement st;
    
    public SuperDAO() {
        try {
            this.st = this.getDB().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SuperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(T t) {
        try {
            String query = createQueryInsert(t);
            int ret = st.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public List<T> readAll() {
        this.list = new ArrayList<>();
        try {
            String query = createQueryReadAll();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                T t = createEntity(rs);
                list.add(t);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }
    
    public T readByID(int id) {
        T t = null;
        try {
            String query = createQueryReadByID(id);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            t = createEntity(rs);
        } catch (SQLException e) {
            e.getMessage();
        }
        return t;
    }
    
    public void delete(T t) {
        try {
            String query = createQueryDelete(t);
            int ret = st.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public void update(T t) {
        try {
            String query = createQueryUpdate(t);
            int ret = st.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Connection getDB() {
        if(this.DB == null) {
            this.DB = this.getConnection();
        }
        return DB;
    }

    public void setDB(Connection DB) {
        this.DB = DB;
    }
    
    public abstract T createEntity(ResultSet rs);
    public abstract String createQueryReadByID(int id);
    public abstract String createQueryDelete(T t);
    public abstract String createQueryUpdate(T t);
    public abstract String createQueryReadAll();
    public abstract String createQueryInsert(T t);
    
    
}
