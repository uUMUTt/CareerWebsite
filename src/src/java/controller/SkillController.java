package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import dao.SkillDAO;
import entity.Skill;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "skillController")
@SessionScoped
public class SkillController implements Serializable {

    private SkillDAO skillDAO;
    private Skill skill;
    private List<Skill> skills;
    private int id;

    public SkillController() {
        this.id = -1;
    }

    public void listAll() {
        this.id = -1;
    }

    public void readByID() {
        this.skills = new ArrayList<>();
        this.skills.add(this.getSkillDAO().readByID(this.id));
    }

    public void create() {
        skillDAO.insert(skill);
        skill = new Skill();
    }

    public void delete(Skill p) {
        skillDAO.delete(p);
    }

    public void update() {
        skillDAO.update(skill);
        skill = new Skill();
    }
    
    
    public void clearForm() {
        this.skill = new Skill();
    }


    public SkillDAO getSkillDAO() {
        if (this.skillDAO == null) {
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
        if (this.id == -1) {
            this.skills = this.getSkillDAO().readAll();
            //this.id = -1;
        }
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
