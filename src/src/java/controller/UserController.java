package controller;

import dao.UserDAO;
import entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private UserDAO userDAO;
    private User user;
    private List<User> users;
    private int id;

    public UserController() {
        this.id = -1;
    }

    public void listAll() {
        this.id = -1;
    }

    public void readByID() {
        this.users = new ArrayList<>();
        this.users.add(this.getUserDAO().readByID(this.id));
    }

    public void create() {
        userDAO.insert(user);
        user = new User();
    }

    public String delete(User u) {
        userDAO.delete(u);
        return "user";
    }

    public void update() {
        userDAO.update(user);
        user = new User();
    }
    
    public void clearForm() {
        this.user = new User();
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
        if (this.id == -1) {
            this.users = this.getUserDAO().readAll();
            //this.id = -1;
        }
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
