package dao;

import entity.Job;
import java.sql.ResultSet;

public class JobDAO extends SuperDAO<Job> {

    private DegreeDAO degreeDAO;

    @Override
    public Job createEntity(ResultSet rs) {
        Job Jb = null;
        try {
            Jb = new Job(rs.getInt("id"), this.getDegreeDAO().findByID(rs.getInt("id")), rs.getDouble("salary"),
                    rs.getInt("experience"), rs.getString("detail"), rs.getString("deadline"), rs.getString("creationdate"));

        } catch (Exception e) {
        }
        return Jb;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from Job where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(Job t) {
        return "delete from Job where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(Job t) {
        return "update Job set degreeid='" + t.getDegree().getId() + "' , salary='" + t.getSalary() + "' , experience='" + t.getExperience() + "' ,"
                + " detail='" + t.getDetail() + "' , deadline='" + t.getDeadline() + "' where id='" + t.getId() + "' ";

    }

    @Override
    public String createQueryReadAll() {
        return "select * from Job";
    }

    @Override
    public String createQueryInsert(Job t) {
        return "insert into Job (degreeid,salary,experience,detail,deadline) "
                + "values ('" + t.getDegree() + "' , '" + t.getSalary() + "' , '" + t.getExperience() + "' , '" + t.getDetail() + "' , "
                + "'" + t.getDeadline() + "' )";
    }

    public DegreeDAO getDegreeDAO() {
        if (this.degreeDAO == null) {
            this.degreeDAO = new DegreeDAO();
        }
        return degreeDAO;
    }

    public void setDegreeDAO(DegreeDAO DegreeDAO) {
        this.degreeDAO = DegreeDAO;
    }

}
