/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Company;
import entity.JobSeekerMessage;
import java.sql.ResultSet;

/**
 *
 * @author Umut Karadas
 */
public class JobSeekerMessageDAO extends SuperDAO<JobSeekerMessage>{
    
    private JobSeekerDAO JobSeekerDAO;
    private CompanyDAO CompanyDAO;

    @Override
    public JobSeekerMessage createEntity(ResultSet rs) {
        JobSeekerMessage jm = null;
        try {
            jm = new JobSeekerMessage(this.getJobSeekerDAO().findByID(rs.getInt("from_p")),
                    this.getCompanyDAO().findByID(rs.getInt("to_p")), rs.getInt("id"), rs.getString("subject"),
                    rs.getString("content"), rs.getDate("date"));
        } catch (Exception e) {
        }
        return jm;
    }

    @Override
    public String createQueryReadByID(int id) {
    }

    @Override
    public String createQueryDelete(JobSeekerMessage t) {
    }

    @Override
    public String createQueryUpdate(JobSeekerMessage t) {
    }

    @Override
    public String createQueryReadAll() {
    }

    @Override
    public String createQueryInsert(JobSeekerMessage t) {
    }

    public JobSeekerDAO getJobSeekerDAO() {
        return JobSeekerDAO;
    }

    public void setJobSeekerDAO(JobSeekerDAO JobSeekerDAO) {
        this.JobSeekerDAO = JobSeekerDAO;
    }

    public CompanyDAO getCompanyDAO() {
        return CompanyDAO;
    }

    public void setCompanyDAO(CompanyDAO CompanyDAO) {
        this.CompanyDAO = CompanyDAO;
    }
    
    
}
