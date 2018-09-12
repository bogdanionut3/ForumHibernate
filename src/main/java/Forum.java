import java.util.List;

public class Forum implements ForumCapable {
    private HibernateForum hibernate;
    private User userLogedIn = null;
    private Category currentCategory = null;
    private Post post = null;


    public Forum(User userLogedIn, Category currentCategory, Post post) {

        this.userLogedIn = userLogedIn;
        this.currentCategory = currentCategory;
        this.post = post;
        hibernate = new HibernateForum();

    }

    public Forum() {

    }

    public String whoIsLoggedIn() {
        return userLogedIn != null ? userLogedIn.getUsername() : "";
    }

    public String wichCategory() {
        return currentCategory != null ? currentCategory.getSubject() : "";
    }

    @Override
    public boolean login(String username, String password) {
        boolean loginSuccesfull = false;
        List<Object> obj = hibernate.getAll(User.class);
        for (int i = 0; i < obj.size(); i++) {
            User user = (User) (obj.get(i));
            if (user.isThisUsernameMine(username) &&
                    user.isThisPasswordMine(password) && username != null) {
                {
                    loginSuccesfull = true;
                }
            }
        }
        return loginSuccesfull;
    }

    @Override
    public void logout() {
        userLogedIn = null;
    }

    @Override
    public void exitCategory() {
        currentCategory = null;
    }

    @Override
    public void register(String username, String password, String mail) {
        User user = new User(username, password, mail);
        hibernate.insert(user);
    }

    @Override
    public void insertCategory(String subject) {
        Category category = new Category(userLogedIn, subject);
        hibernate.insert(category);
    }

    @Override
    public void insertTopic(String subject) {
        Topic topic = new Topic(userLogedIn, currentCategory, subject);
        hibernate.insert(topic);
    }

    public boolean enterTopic(Integer id){
        boolean enterSuccesfull = false;
        List<Object> obj = hibernate.getAll(Topic.class);
        for (int i = 0; i < obj.size(); i++) {
            Topic topic = (Topic)(obj.get(i));
            if (topic != null && topic.getId() == id) {
                enterSuccesfull = true;
            } else {
                System.out.println("invalid Topic");
            }
        }
        return enterSuccesfull;
    }

    @Override
    public List<Object> getAllTopics() {
        List<Object> topics = hibernate.getAll(Topic.class);
        return topics;
    }


    @Override
    public List<Object> getAllCategories() {
        List<Object> categories = hibernate.getAll(Category.class);
        return categories;
    }

    @Override
    public boolean enterCategory(Integer category_id) {
        boolean enterSuccesfull = false;
        List<Object> obj = hibernate.getAll(Category.class);
        for (int i = 0; i < obj.size(); i++) {
            Category category = (Category) (obj.get(i));
            if (category != null && category.getCategoryId() == category_id) {
                enterSuccesfull = true;
            } else {
                System.out.println("invalid Category");
            }
        }
        return enterSuccesfull;
    }

   /* @Override
    public void cleanupEntireDb() {
        hibernate.
    }*/
}
