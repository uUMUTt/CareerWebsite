package entity;

import java.util.Date;

/**
 *
 * @author Murat
 */
public class CompanyMessage extends Message {

    private Company from;
    private JobSeeker to;

    public CompanyMessage() {
    }

    public CompanyMessage(Company from, JobSeeker to, int id, String subject, String text, String date) {
        super(id, subject, text, date);
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
