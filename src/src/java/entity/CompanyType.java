
package entity;

/**
 *
 * @author Umut Karadas
 */
public class CompanyType {
    private int id;
    private String title;
    
    public CompanyType(){
        
    }

    public CompanyType(int id, String title) {
        this.id = id;
        this.title = title;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        final CompanyType other = (CompanyType) obj;
        return this.id == other.id;
    }
    
    
}
