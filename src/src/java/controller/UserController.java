
package controller;

import dao.UserDAO;
import entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private UserDAO userDAO;
    private User user;
    private List<User> users;
    
    public UserController() {
    }
    
    public String create(){
        userDAO.insert(user);
        user = new User();
        return "user";
    }
    
    public String delete(User u) {
        userDAO.delete(u);
        return "user";
    }
    
    public String update() {
        userDAO.update(user);
        user = new User();
        return "user";
    }

    public UserDAO getUserDAO() {
        if (this.userDAO == null) {
            this.userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        this.users = this.getUserDAO().readAll();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
}
