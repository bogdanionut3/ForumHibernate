import java.util.List;

public interface ForumCapable {
    public boolean login (String username, String password);
    public void logout();
    public void exitCategory();
    public void register (String username, String password, String mail);
    public void insertCategory(String subject);
    public List<Object> getAllCategories();
    public boolean enterCategory(Integer category_id);
    public void insertTopic(String subject);
    public List<Object> getAllTopics();
   /* public void cleanupEntireDb();*/

}
