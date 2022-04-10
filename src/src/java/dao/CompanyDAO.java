package dao;

import entity.Company;
import java.sql.ResultSet;

/**
 *
 * @author Umut Karadas
 */
public class CompanyDAO extends SuperDAO<Company> {
    
    private CompanyTypeDAO companyTypeDAO;
    private UserDAO userDAO;
    
    public Company findByID(int id) {
        Company c = null;
        try {
            String query = "select * from company where id='" + id + "'";
            ResultSet rs = this.st.executeQuery(query);
            while (rs.next()) {
                c = new Company(rs.getInt("id"), rs.getString("companyname"), rs.getString("address"), rs.getString("city"), rs.getString("contactpersonname"),
                        rs.getString("contactpersonlastname"), rs.getString("mobile"), this.getCompanyTypeDAO().findByID(rs.getInt("companytypeid")),
                        rs.getString("detail"), this.getUserDAO().findByID(rs.getInt("userid")));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    @Override
    public Company createEntity(ResultSet rs) {
        Company c = null;
        try {
            c = new Company(rs.getInt("id"), rs.getString("companyname"), rs.getString("address"), rs.getString("city"),
                    rs.getString("contactpersonname"), rs.getString("contactpersonlastname"),
                    rs.getString("mobile"), this.getCompanyTypeDAO().findByID(rs.getInt("companytypeid")),
                    rs.getString("detail"),
                    this.getUserDAO().findByID(rs.getInt("userid")));
        } catch (Exception e) {
        }
        return c;
    }
    
    @Override
    public String createQueryReadByID(int id) {
        return "select * from Company where id='" + id + "'";
    }
    
    @Override
    public String createQueryDelete(Company t) {
        return "delete from Company where id='" + t.getId() + "'";
    }
    
    @Override
    public String createQueryUpdate(Company t) {
        return "update Company set companyname='" + t.getCompanyName() + "' , address='" + t.getAddress() + "' , city='" + t.getCity() + "' ,"
                + "contactpersonname='" + t.getContactPersonName() + "' , "
                + " contactpersonlastname='" + t.getContactPersonLastname() + "' ,"
                + "mobile='" + t.getMobile() + "' , companytypeid='" + t.getCompanyType().getId() + "' , "
                + "detail='" + t.getDetail() + "' , "
                + "userid='" + t.getUser().getId() + "' where id='" + t.getId() + "'";
    }
    
    @Override
    public String createQueryReadAll() {
        return "select * from Company";
    }
    
    @Override
    public String createQueryInsert(Company t) {
        return "insert into Company (companyname,address,city,contactpersonname,contactpersonlastname,mobile,companytypeid,detail,userid) "
                + "values ('" + t.getCompanyName() + "' , '" + t.getAddress() + "' , '" + t.getCity() + "' ,'"
                + "" + t.getContactPersonName() + "' ,'" + t.getContactPersonLastname() + "' ,'" + t.getMobile() + "' , '" + t.getCompanyType().getId() + "'"
                + ", '" + t.getDetail() + "' , '" + t.getUser().getId() + "')";
    }
    
    public CompanyTypeDAO getCompanyTypeDAO() {
        if (this.companyTypeDAO == null) {
            this.companyTypeDAO = new CompanyTypeDAO();
        }
        return companyTypeDAO;
    }
    
    public void setCompanyTypeDAO(CompanyTypeDAO CompanyTypeDAO) {
        this.companyTypeDAO = CompanyTypeDAO;
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
