/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.DegreeDAO;
import entity.Degree;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.*;

/**
 *
 * @author Umut Karadas
 */
@FacesConverter("jobConverter")
public class JobConverter implements Converter{
    
    private DegreeDAO degreeDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Degree d = this.getDegreeDAO().findByID(id);
        return d;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Degree d = (Degree)t;
        return String.valueOf(d.getId());
    }

    public DegreeDAO getDegreeDAO() {
        if(this.getDegreeDAO() == null) {
            this.degreeDAO = new DegreeDAO();
        }
        return degreeDAO;
    }

    public void setDegreeDAO(DegreeDAO degreeDAO) {
        this.degreeDAO = degreeDAO;
    }
    
    
}
