package ba.unsa.etf.rpr.project.dtos;

import java.time.LocalDate;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private char gender;
    private LocalDate dateOfBirth;
    private Integer age;
    private String city;
    private boolean student;
    private String institution;
    private String favoriteLanguage;
    private String about;

    public User() {
    }

    public User(Long id, String name, String lastname, char gender, LocalDate dateOfBirth, Integer age, String city, boolean student, String institution, String favoriteLanguage, String about) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
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
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getJsonFormat() {
        return String.format("{\"name\":\"%s\", \"lastname\":\"%s\", \"gender\":\"%s\", \"dateOfBirth\":\"%s\", " +
                        "\"city\":\"%s\", \"student\":\"%s\", " +
                        "\"institution\":\"%s\", \"favoriteLanguage\":\"%s\", \"about\":\"%s\"}",
                name,
                lastname,
                gender,
                dateOfBirth.toString(),
                city,
                student,
                institution,
                favoriteLanguage,
                about
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", student=" + student +
                ", institution='" + institution + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
