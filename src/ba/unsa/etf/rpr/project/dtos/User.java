package ba.unsa.etf.rpr.project.dtos;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private Long id;
    private String firstName;
    private String lastname;
    private char gender;
    private LocalDate dateOfBirth;
    private String city;
    private boolean student;
    private String institution;
    private String favoriteLanguage;
    private String languageToLearn;
    private String about;

    public User() {
    }

    public User(Long id, String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String languageToLearn, String about) {
        this.id = id;
        this.firstName = name;
        this.lastname = lastname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.student = student;
        this.institution = institution;
        this.favoriteLanguage = favoriteLanguage;
        this.languageToLearn = languageToLearn;
        this.about = about;
    }

    public User(String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String languageToLearn, String about) {
        this.firstName = name;
        this.lastname = lastname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.student = student;
        this.institution = institution;
        this.favoriteLanguage = favoriteLanguage;
        this.languageToLearn = languageToLearn;
        this.about = about;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getLanguageToLearn() {
        return languageToLearn;
    }

    public void setLanguageToLearn(String languageToLearn) {
        this.languageToLearn = languageToLearn;
    }

    public int getYears() {
        if (dateOfBirth == null) {
            throw new IllegalStateException("Date of birth not defined for user");
        }
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
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
