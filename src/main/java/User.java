import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String mail;

    public User(String username, String password, String mail) {
        this(username,password);
        this.mail = mail;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public boolean  isThisPasswordMine(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isThisUsernameMine(String username){
        if(this.username.equals(username)){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(username, user.username) && Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username + " mail " + mail + '\'';
    }
}
