
package entity;

/**
 *
 * @author Murat
 */
public class Message {
    /* id SERIAL UNIQUE NOT NULL,
    subject VARCHAR,
    content TEXT NOT NULL,
    date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (id) */
    
    private int id;
    private String subject;
    private String text;
    private String date;

    public Message() {
    }

    public Message(int id, String subject, String text, String date) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
            
            
}
