
package entity;

/**
 *
 * @author Murat
 */
public class JobSeekerMessage extends Message{
    private JobSeeker from;
    private Company to;

    public JobSeekerMessage() {
    }

    public JobSeekerMessage(JobSeeker from, Company to) {
        this.from = from;
        this.to = to;
    }

    public JobSeeker getFrom() {
        return from;
    }

    public void setFrom(JobSeeker from) {
        this.from = from;
    }

    public Company getTo() {
        return to;
    }

    public void setTo(Company to) {
        this.to = to;
    }
    
    
}
