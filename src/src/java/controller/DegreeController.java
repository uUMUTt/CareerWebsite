package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import dao.DegreeDAO;
import entity.Degree;
import entity.Job;
import java.util.ArrayList;
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
    private int id;

    public DegreeController() {
        this.id = -1;
    }

    public void listAll() {
        this.id = -1;
    }

    public void readByID() {
        this.degrees = new ArrayList<>();
        this.degrees.add(this.getDegreeDAO().readByID(this.id));
    }

    public void create() {
        degreeDAO.insert(degree);
        degree = new Degree();
    }

    public void delete(Degree p) {
        degreeDAO.delete(p);
    }

    public String update() {
        degreeDAO.update(degree);
        degree = new Degree();
        return "degree";
    }
    
    public void clearForm() {
        this.degree = new Degree();
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
        if (this.id == -1) {
            this.degrees = this.getDegreeDAO().readAll();
            //this.id = -1;
        }
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
