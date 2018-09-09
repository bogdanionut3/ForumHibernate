import javax.persistence.*;
import java.util.List;
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private User user;
    @OneToMany()
    private List<Post> posts;
    @Column(unique = true)
    private Category category;
    @Column(unique = true)
    private String subject;

    public String getSubject(){
        return subject;
    }
}
