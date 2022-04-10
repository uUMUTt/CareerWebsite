package dao;

import entity.Degree;
import java.sql.ResultSet;
              

public class DegreeDAO extends SuperDAO<Degree>{
    
     public Degree findByID(int id) {
        Degree d = null;
        try {
            String query  = "select * from Degree where id='"+ id +"'";
            ResultSet rs = this.st.executeQuery(query);
            while(rs.next()) {
                d = new Degree(rs.getInt("id"), rs.getString("title"));
            }
        } catch (Exception e) {
        }
        return d;
    }

    //***********************************************************
    @Override
    public Degree createEntity(ResultSet rs) {
        Degree d = null;
        try {
            d = new Degree(rs.getInt("id"), rs.getString("title"));
        } catch (Exception e) {
        }
        return d;
    }

    @Override
    public String createQueryReadByID(int id) {
        return "select * from Degree where id='" + id + "'";
    }

    @Override
    public String createQueryDelete(Degree t) {
        return "delete from Degree where id='" + t.getId() + "'";
    }

    @Override
    public String createQueryUpdate(Degree t) {
        return "update Degree set title='" + t.getTitle() +"'";
    }

    @Override
    public String createQueryReadAll() {
        return "select * from Degree";
    }

    @Override
    public String createQueryInsert(Degree t) {
        return "insert into Degree (title) values ('" + t.getTitle() + "')";
    }
}
