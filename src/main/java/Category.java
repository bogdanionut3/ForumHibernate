import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    @OneToMany
    private List<Topic> topics;
    @OneToOne
    private User user;
    @Column(nullable = false)
    private String subject;

    public Category(User user, String subject) {
        this.user = user;
        this.subject = subject;
    }

    public Category(Integer category_id) {
        this.category_id = category_id;
    }

    public Category() {
    }


    public String getSubject() {
        return subject;
    }

    public int getCategoryId(){
        return category_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Category cat = (Category) obj;
        return Objects.equals(subject, cat.subject);
    }

    @Override
    public String toString() {
        return "Category { " +
                "#" + category_id +
                ",#" + user +
                ",subject=' " + subject + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, topics, user, subject);
    }
}
