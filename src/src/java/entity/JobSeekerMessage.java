
package entity;

import java.util.Date;

/**
 *
 * @author Murat
 */
public class JobSeekerMessage extends Message{
    private JobSeeker from;
    private Company to;

    public JobSeekerMessage() {
    }

    public JobSeekerMessage(JobSeeker from, Company to, int id, String subject, String text, String date) {
        super(id, subject, text, date);
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
