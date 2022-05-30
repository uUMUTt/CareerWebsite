package dao;

import entity.CompanyMessage;
import entity.JobSeekerMessage;
import java.sql.ResultSet;

/**
 *
 * @author Umut Karadas
 */
public class CompanyMessageDAO extends SuperDAO<CompanyMessage> {

    private JobSeekerDAO JobSeekerDAO;
    private CompanyDAO CompanyDAO;

    @Override
    public CompanyMessage createEntity(ResultSet rs) {
        CompanyMessage cm = null;
        try {
            cm = new CompanyMessage(this.getCompanyDAO().findByID(rs.getInt("to_p")),
                    this.getJobSeekerDAO().findByID(rs.getInt("from_p")), rs.getInt("id"), rs.getString("subject"),
                    rs.getString("content"), rs.getString("date"));
        } catch (Exception e) {
        }
        return cm;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from CompanyMessage where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(CompanyMessage t) {
        return "delete from CompanyMessage where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(CompanyMessage t) {
        return "update CompanyMessage set subject='" + t.getSubject() + "' , content='" + t.getText() + "' where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from CompanyMessage";
    }

    @Override
    public String createQueryInsert(CompanyMessage t) {
        return "insert into CompanyMessage (from_p,to_p,subject,content) values ('" + t.getFrom() + "' , '" + t.getTo() + "' ,"
                + " '" + t.getSubject() + "' , '" + t.getText() + "' )";
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
