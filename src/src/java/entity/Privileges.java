/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author kalix
 */
public class Privileges {

    private long id;
    private SystemGroup systemGroup;
    private String mname;
    private boolean icreate;
    private boolean iread;
    private boolean iupdate;
    private boolean idelete;
    private boolean ilist;
    private boolean irshow;

    public Privileges(long id, SystemGroup systemGroup, String mname, boolean icreate, boolean iread, boolean iupdate, boolean idelete, boolean ilist, boolean irshow) {
        this.id = id;
        this.systemGroup = systemGroup;
        this.mname = mname;
        this.icreate = icreate;
        this.iread = iread;
        this.iupdate = iupdate;
        this.idelete = idelete;
        this.ilist = ilist;
        this.irshow = irshow;
    }

    public Privileges() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SystemGroup getSystemGroup() {
        return systemGroup;
    }

    public void setSystemGroup(SystemGroup systemGroup) {
        this.systemGroup = systemGroup;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public boolean isIcreate() {
        return icreate;
    }

    public void setIcreate(boolean icreate) {
        this.icreate = icreate;
    }

    public boolean isIread() {
        return iread;
    }

    public void setIread(boolean iread) {
        this.iread = iread;
    }

    public boolean isIupdate() {
        return iupdate;
    }

    public void setIupdate(boolean iupdate) {
        this.iupdate = iupdate;
    }

    public boolean isIdelete() {
        return idelete;
    }

    public void setIdelete(boolean idelete) {
        this.idelete = idelete;
    }

    public boolean isIlist() {
        return ilist;
    }

    public void setIlist(boolean ilist) {
        this.ilist = ilist;
    }

    public boolean isIrshow() {
        return irshow;
    }

    public void setIrshow(boolean irshow) {
        this.irshow = irshow;
    }

}
