package controller;

import dao.JobDAO;
import entity.Job;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
    private int id;

    public JobController() {
        this.id = -1;
    }

    public void listAll() {
        this.id = -1;
    }

    public void readByID() {
        this.jobs = new ArrayList<>();
        this.jobs.add(this.getJobDAO().readByID(this.id));
    }
    
    public void create() {
        jobDAO.insert(job);
        job = new Job();
    }

    public void delete(Job p) {
        jobDAO.delete(p);
    }

    public void update() {
        jobDAO.update(job);
        job = new Job();
    }
    
    public void clearForm() {
        this.job = new Job();
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
        if (this.id == -1) {
            this.jobs = this.getJobDAO().readAll();
            //this.id = -1;
        }
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
