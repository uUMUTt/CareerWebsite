
package entity;

/**
 *
 * @author Murat
 */
public class CompanyContactUsMessage extends Message{
    private Company from;

    public CompanyContactUsMessage() {
    }

    public CompanyContactUsMessage(Company from) {
        this.from = from;
    }

    public Company getFrom() {
        return from;
    }

    public void setFrom(Company from) {
        this.from = from;
    }
    
}
