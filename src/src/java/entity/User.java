
package entity;

/**
 *
 * @author Umut Karadas
 */

//P_User TABLE
//Tabloda name ozelligi caldirilacak
public class User {
    
    private int id;
    private String mail;
    private String password;

    public User() {
        
    }
    
    public User(int id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return this.id == other.id;
    }
    
    
    
}
