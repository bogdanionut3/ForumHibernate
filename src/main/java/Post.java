import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private User user;
    @Column()
    private Topic topic;
    @Column()
    private String text;
    @Column()
    private String title;

    public Post(Integer id, User user, Topic topic, String text, String title) {
        this.id = id;
        this.user = user;
        this.topic = topic;
        this.text = text;
        this.title = title;
    }
}
