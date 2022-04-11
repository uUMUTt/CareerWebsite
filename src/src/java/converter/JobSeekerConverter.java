
package converter;

import dao.JobSeekerDAO;
import entity.JobSeeker;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.*;

/**
 *
 * @author Umut Karadas
 */
@FacesConverter("jobSeekerConverter")
public class JobSeekerConverter implements Converter{
    
    private JobSeekerDAO jobSeekerDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        JobSeeker js = this.getJobSeekerDAO().findByID(id);
        return js;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        JobSeeker js = (JobSeeker)t;
        return String.valueOf(js.getId());
    }

    public JobSeekerDAO getJobSeekerDAO() {
        if(this.jobSeekerDAO == null) {
            this.jobSeekerDAO = new JobSeekerDAO();
        }
        return jobSeekerDAO;
    }

    public void setJobSeekerDAO(JobSeekerDAO jobSeekerDAO) {
        this.jobSeekerDAO = jobSeekerDAO;
    }

   
    
    
}
