/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SystemGroup;
import entity.SystemUser;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import util.DBConnection;

/**
 *
 * @author kalix
 */
public class SystemUserDAO extends DBConnection {

    private SystemGroupDAO systemGroupDAO;

    //FOR VALIDATION
    public SystemUser getUser(String email, String password) {
        SystemUser user = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemuser where email='" + email + "' and password='" + password + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();

            SystemGroup sg = this.getSystemGroupDAO().findSystemGroupById(rs.getLong("ugroup_id"));
            user = new SystemUser(rs.getLong("id"), rs.getString("email"), rs.getString("password"), sg);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public List<SystemUser> readList() {
        List<SystemUser> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemuser order by id asc";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                SystemGroup sg = this.getSystemGroupDAO().findSystemGroupById(rs.getLong("id"));
                list.add(new SystemUser(rs.getLong("id"), rs.getString("email"), rs.getString("password"), sg));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(SystemUser systemUser) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into systemuser(email,password,ugroup_id) values ('" + systemUser.getEmail() + "' , '" + systemUser.getPassword() + "' , " + systemUser.getSystemGroup().getId() + " )";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(SystemUser systemUser) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from systemuser where id=" + systemUser.getId() + " ";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(SystemUser systemUser) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update systemuser set email='" + systemUser.getEmail() + "' , password='" + systemUser.getPassword() + "' , ugroup_id=" + systemUser.getSystemGroup().getId() + " where id=" + systemUser.getId() + "";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public SystemGroupDAO getSystemGroupDAO() {
        if (systemGroupDAO == null) {
            systemGroupDAO = new SystemGroupDAO();
        }
        return systemGroupDAO;
    }

    public void setSystemGroupDAO(SystemGroupDAO systemGroupDAO) {
        this.systemGroupDAO = systemGroupDAO;
    }

}
