package ba.unsa.etf.rpr.project.user;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Table(name = "`users`")
@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "userSeq",
            sequenceName = "userSeq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSeq"
    )
    private Long id;
    private String name;
    private String lastname;
    private char gender;
    private LocalDate dateOfBirth;
    @Transient
    private Integer age;
    private String city;
    private boolean student;
    private String institution;
    private String favoriteLanguage;
    private String about;

    public User() {
    }

    public User(String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String about) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.student = student;
        this.institution = institution;
        this.favoriteLanguage = favoriteLanguage;
        this.about = about;
    }

    public User(Long id, String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String about) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.student = student;
        this.institution = institution;
        this.favoriteLanguage = favoriteLanguage;
        this.about = about;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Math.abs(Period.between(LocalDate.now(), dateOfBirth).getYears());
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", city='" + city + '\'' +
                ", student=" + student +
                ", institution='" + institution + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
