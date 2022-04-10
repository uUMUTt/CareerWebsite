
package dao;

import entity.Skill;
import java.sql.ResultSet;

public class SkillDAO extends SuperDAO<Skill>{
    public Skill findByID(int id) {
        Skill s = null;
        try {
            String query = "select * from Skill where id='" + id + "'";
            ResultSet rs = this.st.executeQuery(query);
            while (rs.next()) {
                s = new Skill(rs.getInt("id"), rs.getString("title"));
            }
        } catch (Exception e) {
        }
        return s;
    }

    //***********************************************************
    @Override
    public Skill createEntity(ResultSet rs) {
        Skill s = null;
        try {
            s = new Skill(rs.getInt("id"), rs.getString("title"));
        } catch (Exception e) {
        }
        return s;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from Skill where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(Skill t) {
        return "delete from Skill where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(Skill t) {
        return "update Skill set title='" + t.getTitle() +"'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from Skill";
    }

    @Override
    public String createQueryInsert(Skill t) {
        return "insert into Skill (title) values ('" + t.getTitle() + "')";
    }
}
