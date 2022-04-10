package entity;

import java.util.Date;

/**
 *
 * @author Murat
 */
public class CompanyContactUsMessage extends Message {

    private Company from;

    public CompanyContactUsMessage() {
    }

    public CompanyContactUsMessage(Company from, int id, String subject, String text, Date date) {
        super(id, subject, text, date);
        this.from = from;
    }

    public Company getFrom() {
        return from;
    }

    public void setFrom(Company from) {
        this.from = from;
    }

}
