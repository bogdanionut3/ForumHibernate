import javax.persistence.*;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Topic topic;
    @Column()
    private String text;
    @Column()
    private String title;

    public Post(){}

    public Post(Integer id, User user, Topic topic, String text, String title) {
        this.id = id;
        this.user = user;
        this.topic = topic;
        this.text = text;
        this.title = title;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Post post = (Post)obj;
        return Objects.equals(post, post.title)&&Objects.equals(post,post.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Category { " +
                "#" + id +
                ",#" + user +
                ",#" + topic +
                ",text" + text +
                ",subject=' " + title + '\'' +
                '}';
    }
}
