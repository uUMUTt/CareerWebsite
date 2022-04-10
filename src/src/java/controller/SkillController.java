
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import dao.SkillDAO;
import entity.Skill;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "skillController")
@SessionScoped
public class SkillController implements Serializable{

    private SkillDAO skillDAO;
    private Skill skill;
    private List<Skill> skills;
    
    public SkillController() {
    }
    
    public String create(){
        skillDAO.insert(skill);
        skill = new Skill();
        return "skill";
    }
    
    
    public String delete(Skill p) {
        skillDAO.delete(p);
        return "skill";
    }
    
    public String update() {
        skillDAO.update(skill);
        skill = new Skill();
        return "skill";
    }

    public SkillDAO getSkillDAO() {
        if (this.skillDAO ==null) {
            this.skillDAO = new SkillDAO();
        }
        return skillDAO;
    }

    public void setSkillDAO(SkillDAO skillDAO) {
        this.skillDAO = skillDAO;
    }

    public Skill getSkill() {
        if (this.skill == null) {
            this.skill = new Skill();
        }
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<Skill> getSkills() {
        this.skills = this.getSkillDAO().readAll();
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    
    
    
}
