
package entity;

/**
 *
 * @author Murat
 */
public class CompanyMessage extends Message{
    private Company from;
    private JobSeeker to;

    public CompanyMessage() {
    }

    public CompanyMessage(Company from, JobSeeker to) {
        this.from = from;
        this.to = to;
    }

    public Company getFrom() {
        return from;
    }

    public void setFrom(Company from) {
        this.from = from;
    }

    public JobSeeker getTo() {
        return to;
    }

    public void setTo(JobSeeker to) {
        this.to = to;
    }
    
    
}
