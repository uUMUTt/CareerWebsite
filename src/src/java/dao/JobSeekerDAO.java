package dao;

import entity.JobSeeker;
import java.sql.ResultSet;

public class JobSeekerDAO extends SuperDAO<JobSeeker> {

    private DegreeDAO degreeDAO;
    private UserDAO userDAO;

    @Override
    public JobSeeker createEntity(ResultSet rs) {
        JobSeeker j = null;
        try {
            j = new JobSeeker(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("gender"),
                    rs.getString("birthdate"), rs.getString("address"), rs.getString("city"), rs.getString("mobile"),
                    this.getDegreeDAO().findByID(rs.getInt("id")),
                    rs.getString("passyear"), rs.getString("detail"), rs.getInt("experience"),
                    this.getUserDAO().findByID(rs.getInt("id")));
        } catch (Exception e) {
        }
        return j;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from JobSeeker where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(JobSeeker t) {
        return "delete from JobSeeker where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(JobSeeker t) {
        return "update JobSeeker set firstname='" + t.getFirstName() + "' , lastname='" + t.getLastName() + "' ,"
                + "gender='" + t.getGender() + "' , birthdate='" + t.getBirthDate() + "' ,"
                + "address='" + t.getAddress() + "' , city='" + t.getCity() + "' ,"
                + "mobile='" + t.getMobile() + "' , degreeid='" + t.getDegree().getId() + "' , detail='" + t.getDetail() + "' , "
                + "experience='" + t.getExperience() + "' , passyear='" + t.getPassYear() + "' ,"
                + "userid='" + t.getUser().getId() + "'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from JobSeeker";
    }

    @Override
    public String createQueryInsert(JobSeeker t) {
        return "insert into JobSeeker (firstname,lastname,gender,birthdate,address,city,mobile,degreeid,passyear,detail,experience,userid) "
                + "values ('" + t.getFirstName() + "' , '" + t.getLastName() + "' , '" + t.getGender() + "' , '" + t.getBirthDate() + "' , "
                + "'" + t.getAddress() + "' , '" + t.getCity() + "' ,'"
                + "" + t.getMobile() + "' , '" + t.getDegree().getId() + "' , '" + t.getPassYear() + "' , '" + t.getDetail() + "' ,"
                + " '" + t.getExperience() + "' , '" + t.getUser().getId() + "')";
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

    public UserDAO getUserDAO() {
        if (this.userDAO == null) {
            this.userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void setUserDAO(UserDAO UserDAO) {
        this.userDAO = UserDAO;
    }
}
