import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private User user;
    @OneToMany()
    private List<Post> posts;
    @ManyToOne
    private Category category;
    @Column(unique = true)
    private String subject;

    public String getSubject() {
        return subject;
    }

    public Topic(User user, Category category, String subject) {
        this.user = user;
        this.category = category;
        this.subject = subject;
    }

    public Topic(){};

    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Topic topic = (Topic) obj;
        return Objects.equals(topic, topic.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }

    @Override
    public String toString() {
        return "Category { " +
                "#" + id +
                ",#" + user +
                ",#" + category +
                ",#" + posts +
                ",subject=' " + subject + '\'' +
                '}';
    }
}


