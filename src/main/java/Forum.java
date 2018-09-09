import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private HibernateForum hibernate;
    private User userLogedIn = null;
    private Category currentCategory = null;

    public Forum(User userLogedIn, Category currentCategory) {
        this.userLogedIn = userLogedIn;
        this.currentCategory = currentCategory;
    }
    public Forum(){

    }

    public String whoIsLoggedIn() {
        return userLogedIn != null ? userLogedIn.getUsername() : "";
    }

    public String wichCategory() {
        return currentCategory != null ? currentCategory.getSubject() : "";
    }

    public boolean login(String username, String password) {
        boolean loginSuccesfull = false;
        User user = new User(username,password);
        if (user != null && user.isThisPasswordMine(password)) {
            userLogedIn = user;
            loginSuccesfull = true;
        }
        return loginSuccesfull;
    }


    public void logout() {
        userLogedIn = null;
    }

    public void exitCategory() {
        currentCategory = null;
    }


    public void register(String username, String password, String mail) {
        hibernate.insert(username);
        hibernate.insert(password);
        hibernate.insert(mail);
    }


    public void insertCategory(String subject) {
        hibernate.insert(subject);
    }

   /* @Override
    public List<Category> getAllCategories() {
        Category category = new Category();
        hibernate.getAll(category);
    }*/

    public boolean enterCategory(Integer category_id) {
        boolean enterSuccesfuly = false;
        Category category = new Category(category_id);
        if (category == null) {
            return false;
        } else {
            currentCategory = category;
            enterSuccesfuly = true;
        }
        return enterSuccesfuly;
    }

  /*  @Override
    public void cleanupEntireDb() {
       hibernate.
    }*/
}
