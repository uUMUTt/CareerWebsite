/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Document;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import util.DBConnection;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kopuk
 */
public class DocumentDAO extends DBConnection{

    
   
    public DocumentDAO() {
    }
    
    
    
    public List<Document> findAll(){
        
        List<Document> dlist = new ArrayList<>();
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                Document d = new Document();
                d.setId((int) rs.getInt("id"));
                d.setFilePath(rs.getString("path"));
                d.setFileName(rs.getString("name"));
                d.setFileType(rs.getString("type"));
                dlist.add(d);
            }
        } catch (SQLException e) {
        }
        return dlist;
    }
    
    public void insert(Document d) {
        System.out.println("**************"+d.getFilePath()+"********************");
        try {
            String query =  "insert into document (path, name, type) values ('"+d.getFilePath()+"', '"+d.getFileName()+"', '"+d.getFileType()+"')";
            Statement st = this.getConnection().createStatement();
            st.executeUpdate(query);
            
            /*PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();*/
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    
    
    
}
