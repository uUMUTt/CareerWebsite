/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SystemGroup;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import util.DBConnection;

/**
 *
 * @author kalix
 */
public class SystemGroupDAO extends DBConnection {

    public SystemGroupDAO() {
    }

    public SystemGroup findSystemGroupById(long id) {
        SystemGroup systemGroup = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemgroup where id=" + id + "";
            ResultSet rs = st.executeQuery(query);
            rs.next();

            systemGroup = new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated"));

        } catch (Exception e) {
        }

        return systemGroup;
    }

    //PAGINATION
    public List<SystemGroup> readList(int page) {

        int numOfRowOnPage = 5;
        int offset = (page - 1) * numOfRowOnPage;

        List<SystemGroup> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemgroup limit " + numOfRowOnPage + " offset " + offset + "";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public List<SystemGroup> readList() {

        List<SystemGroup> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemgroup";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(SystemGroup systemGroup) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into systemgroup(gname,created) values ('" + systemGroup.getGroupName() + "' , '" + new Date(System.currentTimeMillis()) + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(SystemGroup systemGroup) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from systemgroup where id=" + systemGroup.getId() + " ";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(SystemGroup systemGroup) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update systemgroup set title='" + systemGroup.getGroupName() + "' where id=" + systemGroup.getId() + "";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
