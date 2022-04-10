
package entity;

/**
 *
 * @author Umut Karadas
 */
public class Job {
    private int id;
    private Degree degree;
    private double salary;
    private int experienceYear;
    private String detail;  
    private String deadline;
    private String creationDate;
    
    public Job() {
        
    }

    public Job(int id, Degree degree, double salary, int experienceYear, String detail, String deadline, String creationDate) {
        this.id = id;
        this.degree = degree;
        this.salary = salary;
        this.experienceYear = experienceYear;
        this.detail = detail;
        this.deadline = deadline;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    
}
