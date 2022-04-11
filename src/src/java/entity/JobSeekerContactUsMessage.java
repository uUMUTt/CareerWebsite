
package entity;

import java.util.Date;

/**
 *
 * @author Murat
 */
public class JobSeekerContactUsMessage extends Message{
    
    private JobSeeker from;
    
    
    public JobSeekerContactUsMessage() {
    }

    public JobSeekerContactUsMessage(JobSeeker from, int id, String subject, String text, String date) {
        super(id, subject, text, date);
        this.from = from;
    }
    

    public JobSeeker getFrom() {
        return from;
    }

    public void setFrom(JobSeeker from) {
        this.from = from;
    }

    
    
    
    
}
