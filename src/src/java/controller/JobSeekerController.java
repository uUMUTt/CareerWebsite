package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import dao.JobSeekerDAO;
import java.util.List;
import entity.JobSeeker;
import java.util.ArrayList;

/**
 *
 * @author kopuk
 */
@Named(value = "jobseekerController")
@SessionScoped
public class JobSeekerController implements Serializable {

    private JobSeeker jobSeeker;
    private JobSeekerDAO jobSeekerDAO;
    private List<JobSeeker> jobSeekers;
    private int id;

    public JobSeekerController() {
        this.id = -1;
    }

    public String listAll() {
        this.id = -1;
        return "jobseeker";
    }

    public String readByID() {
        this.jobSeekers = new ArrayList<>();
        this.jobSeekers.add(this.getJobSeekerDAO().readByID(this.id));
        return "jobseeker";
    }

    public String create() {
        jobSeekerDAO.insert(jobSeeker);
        jobSeeker = new JobSeeker();
        return "jobseeker";
    }

    public String delete(JobSeeker p) {
        jobSeekerDAO.delete(p);
        return "jobseeker";
    }

    public String update() {
        jobSeekerDAO.update(jobSeeker);
        jobSeeker = new JobSeeker();
        return "jobseeker";
    }

    public JobSeeker getJobSeeker() {
        if (this.jobSeeker == null) {
            this.jobSeeker = new JobSeeker();
        }
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public JobSeekerDAO getJobSeekerDAO() {
        if (this.jobSeekerDAO == null) {
            this.jobSeekerDAO = new JobSeekerDAO();
        }
        return jobSeekerDAO;
    }

    public void setJobSeekerDAO(JobSeekerDAO jobSeekerDAO) {
        this.jobSeekerDAO = jobSeekerDAO;
    }

    public List<JobSeeker> getJobSeekers() {
        if (this.id == -1) {
            this.jobSeekers = this.getJobSeekerDAO().readAll();
            //this.id = -1;
        }
        return jobSeekers;
    }

    public void setJobSeekers(List<JobSeeker> jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
