
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import entity.JobSeekerContactUsMessage;
import dao.JobSeekerContactUsMessageDAO;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author kopuk
 */
@Named(value = "jobSeekerContactUsMessageController")
@SessionScoped
public class JobSeekerContactUsMessageController implements Serializable {

    private JobSeekerContactUsMessage jobSeekerContactUsMessage;
    private JobSeekerContactUsMessageDAO jobSeekerContactUsMessageDAO;
    private List<JobSeekerContactUsMessage> jobSeekerContactUsMessages;
    private int id;
    
    public JobSeekerContactUsMessageController() {
        this.id = -1;
    }
    public String listAll() {
        this.id = -1;
        return "jobseeker_contactus_message";
    }

    public String readByID() {
        this.jobSeekerContactUsMessages = new ArrayList<>();
        this.jobSeekerContactUsMessages.add(this.getJobSeekerContactUsMessageDAO().readByID(this.id));
        return "jobseeker_contactus_message";
    }

    public String create() {
        jobSeekerContactUsMessageDAO.insert(jobSeekerContactUsMessage);
        jobSeekerContactUsMessage = new JobSeekerContactUsMessage();
        return "jobseeker_contactus_message";
    }

    public String delete(JobSeekerContactUsMessage p) {
        jobSeekerContactUsMessageDAO.delete(p);
        return "jobseeker_contactus_message";
    }

    public String update() {
        jobSeekerContactUsMessageDAO.update(jobSeekerContactUsMessage);
        jobSeekerContactUsMessage = new JobSeekerContactUsMessage();
        return "jobseeker_contactus_message";
    }

    public JobSeekerContactUsMessage getJobSeekerContactUsMessage() {
        if (this.jobSeekerContactUsMessage == null) {
            this.jobSeekerContactUsMessage = new JobSeekerContactUsMessage();
        }
        return jobSeekerContactUsMessage;
    }

    public void setJobSeekerContactUsMessage(JobSeekerContactUsMessage jobSeekerContactUsMessage) {
        this.jobSeekerContactUsMessage = jobSeekerContactUsMessage;
    }

    public JobSeekerContactUsMessageDAO getJobSeekerContactUsMessageDAO() {
        if (this.jobSeekerContactUsMessageDAO == null) {
            this.jobSeekerContactUsMessageDAO = new JobSeekerContactUsMessageDAO();
        }
        return jobSeekerContactUsMessageDAO;
    }

    public void setJobSeekerContactUsMessageDAO(JobSeekerContactUsMessageDAO jobSeekerContactUsMessageDAO) {
        this.jobSeekerContactUsMessageDAO = jobSeekerContactUsMessageDAO;
    }

    public List<JobSeekerContactUsMessage> getJobSeekerContactUsMessages() {
        if (this.id == -1) {
            this.jobSeekerContactUsMessages = this.getJobSeekerContactUsMessageDAO().readAll();
        }
        return jobSeekerContactUsMessages;
    }

    public void setJobSeekerContactUsMessages(List<JobSeekerContactUsMessage> jobSeekerContactUsMessages) {
        this.jobSeekerContactUsMessages = jobSeekerContactUsMessages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
