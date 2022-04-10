package controller;

import dao.JobDAO;
import entity.Job;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Umut Karadas
 */
@Named(value = "jobController")
@SessionScoped
public class JobController implements Serializable {

    private JobDAO jobDAO;
    private Job job;
    private List<Job> jobs;

    public JobController() {
    }
    
     public String create(){
        jobDAO.insert(job);
        job = new Job();
        return "job";
    }
    
    public String delete(Job p) {
        jobDAO.delete(p);
        return "job";
    }
    
    public String update() {
        jobDAO.update(job);
        job = new Job();
        return "job";
    }
    
    public JobDAO getJobDAO() {
        if (this.jobDAO == null) {
            this.jobDAO = new JobDAO();
        }
        return jobDAO;
    }

    public void setJobDAO(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    public Job getJob() {
        if (this.job == null) {
            this.job = new Job();
        }
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Job> getJobs() {
        this.jobs = this.getJobDAO().readAll();
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}
