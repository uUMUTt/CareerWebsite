
package controller;

import dao.JobSeekerMessageDAO;
import entity.JobSeekerMessage;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umut Karadas
 */
@Named(value = "jobSeekerMessageController")
@SessionScoped
public class JobSeekerMessageController implements Serializable {

    
    private JobSeekerMessageDAO jobSeekerMessageDAO;
    private JobSeekerMessage jobSeekerMessage;
    private List<JobSeekerMessage> jobSeekerMessages;
    private int id;
    
    public JobSeekerMessageController() {
        this.id = -1;
    }

    public String listAll() {
        this.id = -1;
        return "jobseekermessage";
    }
    
    public String create(){
        jobSeekerMessageDAO.insert(jobSeekerMessage);
        jobSeekerMessage = new JobSeekerMessage();
        return "jobseekermessage";
    }
    
    public String delete(JobSeekerMessage jm) {
        jobSeekerMessageDAO.delete(jm);
        return "jobseekermessage";
    }
    
    public String update() {
        jobSeekerMessageDAO.update(jobSeekerMessage);
        jobSeekerMessage = new JobSeekerMessage();
        return "jobseekermessage";
    }
    
    public String readByID() {
        this.jobSeekerMessages = new ArrayList<>();
        this.jobSeekerMessages.add(this.getJobSeekerMessageDAO().readByID(this.id));
        return "jobseekermessage";
    }

    public JobSeekerMessageDAO getJobSeekerMessageDAO() {
        if(this.jobSeekerMessageDAO == null) {
            this.jobSeekerMessageDAO = new JobSeekerMessageDAO();
        }
        return jobSeekerMessageDAO;
    }

    public void setJobSeekerMessageDAO(JobSeekerMessageDAO jobSeekerMessageDAO) {
        this.jobSeekerMessageDAO = jobSeekerMessageDAO;
    }

    public JobSeekerMessage getJobSeekerMessage() {
        if(this.jobSeekerMessage == null){
            this.jobSeekerMessage = new JobSeekerMessage();
        }
        return jobSeekerMessage;
    }

    public void setJobSeekerMessage(JobSeekerMessage jobSeekerMessage) {
        this.jobSeekerMessage = jobSeekerMessage;
    }

    public List<JobSeekerMessage> getJobSeekerMessages() {
        if(this.id == -1){
           this.jobSeekerMessages = this.getJobSeekerMessageDAO().readAll(); 
        }
        return jobSeekerMessages;
    }

    public void setJobSeekerMessages(List<JobSeekerMessage> jobSeekerMessages) {
        this.jobSeekerMessages = jobSeekerMessages;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
