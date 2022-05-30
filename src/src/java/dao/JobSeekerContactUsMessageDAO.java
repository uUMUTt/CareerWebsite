/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.JobSeekerContactUsMessage;
import entity.JobSeekerMessage;
import java.sql.ResultSet;

/**
 *
 * @author ATG
 */
public class JobSeekerContactUsMessageDAO extends SuperDAO<JobSeekerContactUsMessage> {

    private JobSeekerDAO JobSeekerDAO;

    @Override
    public JobSeekerContactUsMessage createEntity(ResultSet rs) {
        JobSeekerContactUsMessage jm = null;
        try {
            jm = new JobSeekerContactUsMessage(this.getJobSeekerDAO().findByID(rs.getInt("from_p")),
                    rs.getInt("id"), rs.getString("subject"), rs.getString("content"), rs.getString("date"));
        } catch (Exception e) {
        }
        return jm;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from JobSeekerContactUsMessage where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(JobSeekerContactUsMessage t) {
        return "delete from JobSeekerContactUsMessage where id='" + t.getId() + "'";

    }

    @Override
    public String createQueryUpdate(JobSeekerContactUsMessage t) {
        return "update JobSeekerContactUsMessage set subject='" + t.getSubject() + "' , content='" + t.getText() + "' where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from JobSeekerContactUsMessage";
    }

    @Override
    public String createQueryInsert(JobSeekerContactUsMessage t) {
        return "insert into JobSeekerContactUsMessage (from_p, subject, content) values ('" + t.getFrom() + "' , '" + t.getSubject() + "' , '" + t.getText() + "')";
    }

    public JobSeekerDAO getJobSeekerDAO() {
        return JobSeekerDAO;
    }

    public void setJobSeekerDAO(JobSeekerDAO JobSeekerDAO) {
        this.JobSeekerDAO = JobSeekerDAO;
    }

}
