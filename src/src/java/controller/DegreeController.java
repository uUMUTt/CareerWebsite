
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import dao.DegreeDAO;
import entity.Degree;
import entity.Job;
import java.util.List;

/**
 *
 * @author kopuk
 */
@Named(value = "degreeController")
@SessionScoped
public class DegreeController implements Serializable {

    private DegreeDAO degreeDAO;
    private Degree degree;
    private List<Degree> degrees;
    
    
    public DegreeController() {
    }
    
    public String create(){
        degreeDAO.insert(degree);
        degree = new Degree();
        return "degree";
    }
    
    public String delete(Degree p) {
        degreeDAO.delete(p);
        return "degree";
    }
    
    public String update() {
        degreeDAO.update(degree);
        degree = new Degree();
        return "degree";
    }

    public DegreeDAO getDegreeDAO() {
        if (this.degreeDAO == null) {
            this.degreeDAO = new DegreeDAO();
        }
        return degreeDAO;
    }

    public void setDegreeDAO(DegreeDAO degreeDAO) {
        this.degreeDAO = degreeDAO;
    }

    public Degree getDegree() {
        if (this.degree == null) {
            this.degree = new Degree();
        }
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<Degree> getDegrees() {
        this.degrees = this.getDegreeDAO().readAll();
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }
    
    
    
}
