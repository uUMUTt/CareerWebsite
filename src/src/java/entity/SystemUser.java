/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author kalix
 */
public class SystemUser implements Serializable{
    
    private long id;
    private String email;
    private String password;
    private SystemGroup systemGroup;

    public SystemUser(long id, String email, String password, SystemGroup systemGroup) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.systemGroup = systemGroup;
    }

    public SystemUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemGroup getSystemGroup() {
        return systemGroup;
    }

    public void setSystemGroup(SystemGroup systemGroup) {
        this.systemGroup = systemGroup;
    }
    
    
}
