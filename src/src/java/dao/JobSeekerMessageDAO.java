package dao;

import entity.JobSeekerMessage;
import java.sql.ResultSet;

/**
 *
 * @author Umut Karadas
 */
public class JobSeekerMessageDAO extends SuperDAO<JobSeekerMessage> {

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
        return "select * from JobseekerMessage where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(JobSeekerMessage t) {
        return "delete from JobseekerMessage where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(JobSeekerMessage t) {
        return "update JobseekerMessage set subject='" + t.getSubject() + "' , content='" + t.getText() + "' where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from JobseekerMessage";
    }

    @Override
    public String createQueryInsert(JobSeekerMessage t) {
        return "insert into JobSeekerMessage (from_p,to_p,subject,content) values ('" + t.getFrom() + "' , " + t.getTo() + "' , " + t.getSubject() + "' , " + t.getText() + "' , )";
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
