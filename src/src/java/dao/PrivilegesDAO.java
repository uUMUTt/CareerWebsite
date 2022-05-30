/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Privileges;
import entity.SystemGroup;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import util.DBConnection;

/**
 *
 * @author kalix
 */
public class PrivilegesDAO extends DBConnection {

    private SystemGroupDAO systemGroupDAO;

    public Privileges getGroupPrivileges(SystemGroup systemGroup, String module) {
        Privileges privilege = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from privileges where pgroup_id=" + systemGroup.getId() + " and mname='" + module + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            privilege = new Privileges(
                    rs.getLong("id"),
                    this.getSystemGroupDAO().findSystemGroupById(rs.getLong("id")),
                    rs.getString("mname"),
                    rs.getBoolean("icreate"),
                    rs.getBoolean("iread"),
                    rs.getBoolean("iupdate"),
                    rs.getBoolean("idelete"),
                    rs.getBoolean("ilist"),
                    rs.getBoolean("irshow")
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return privilege;
    }

    public List<Privileges> readList() {
        List<Privileges> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from privileges order by id asc";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Privileges(
                        rs.getLong("id"),
                        this.getSystemGroupDAO().findSystemGroupById(rs.getLong("pgroup_id")),
                        rs.getString("mname"),
                        rs.getBoolean("icreate"),
                        rs.getBoolean("iread"),
                        rs.getBoolean("iupdate"),
                        rs.getBoolean("idelete"),
                        rs.getBoolean("ilist"),
                        rs.getBoolean("irshow")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public List<Privileges> readList(int page) {
        List<Privileges> list = new ArrayList<>();
        
        int numOfRowOnPage = 5;
        int offset = (page - 1) * numOfRowOnPage;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from privileges limit " + numOfRowOnPage + " offset " + offset + "";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Privileges(
                        rs.getLong("id"),
                        this.getSystemGroupDAO().findSystemGroupById(rs.getLong("pgroup_id")),
                        rs.getString("mname"),
                        rs.getBoolean("icreate"),
                        rs.getBoolean("iread"),
                        rs.getBoolean("iupdate"),
                        rs.getBoolean("idelete"),
                        rs.getBoolean("ilist"),
                        rs.getBoolean("irshow")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(Privileges privileges) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into privileges(mname,pgroup_id,icreate,iread,iupdate,idelete,ilist,irshow) values ('" + privileges.getMname() + "' , " + privileges.getSystemGroup().getId() + " , " + privileges.isIcreate() + " , " + privileges.isIread() + ", " + privileges.isIupdate() + " , " + privileges.isIdelete() + ", " + privileges.isIlist() + ", " + privileges.isIrshow() + ")";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Privileges privileges) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from privileges where id=" + privileges.getId() + " ";
            int r = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Privileges privileges) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update privileges set mname='" + privileges.getMname() + "'  where id=" + privileges.getId() + "";
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
