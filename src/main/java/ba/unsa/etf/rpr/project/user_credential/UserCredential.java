package ba.unsa.etf.rpr.project.user_credential;

import javax.persistence.*;


/*
UserCredential will have the same primary key as the user
in `users` table so there is no need for foreign key on that table

That manual constraint will be forced when user registers via frontend
at the same time these two tables will be populated with data from new user
 */
@Table(name = "`userCredentials`")
@Entity
public class UserCredential {
    @Id
    @SequenceGenerator(
            name = "userCredSeq",
            sequenceName = "userCredSeq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userCredSeq"
    )
    private Long id;
    private String username;
    private String password;

    public UserCredential() {
    }

    public UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredential(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
