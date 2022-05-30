/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SystemGroupDAO;
import entity.SystemGroup;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author kalix
 */
@FacesConverter("systemGroupConverter")
public class SystemGroupConverter implements Converter{
    
    private SystemGroupDAO SystemGroupDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        long id = Long.valueOf(string);
        SystemGroup systemGroup = this.getSystemGroupDAO().findSystemGroupById(id);
        return systemGroup;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        SystemGroup systemGroup = (SystemGroup) t;
        String id = String.valueOf(systemGroup.getId());
        return id;
    }

    public SystemGroupDAO getSystemGroupDAO() {
        if(SystemGroupDAO == null) {
            SystemGroupDAO = new SystemGroupDAO();
        }
        return SystemGroupDAO;
    }

    public void setSystemGroupDAO(SystemGroupDAO SystemGroupDAO) {
        this.SystemGroupDAO = SystemGroupDAO;
    }
    
    
    
}
