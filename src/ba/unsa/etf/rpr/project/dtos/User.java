package ba.unsa.etf.rpr.project.dtos;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private SimpleLongProperty id;
    private SimpleStringProperty username;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleObjectProperty<Character> gender;
    private SimpleObjectProperty<LocalDate> dateOfBirth;
    private SimpleStringProperty city;
    private SimpleBooleanProperty student;
    private SimpleStringProperty institution;
    private SimpleStringProperty currentLanguage;
    private SimpleStringProperty favoriteLanguage;
    private SimpleStringProperty about;

    public User() {
        this.id = new SimpleLongProperty();
        this.username = new SimpleStringProperty();
        this.firstname = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.gender = new SimpleObjectProperty<>();
        this.dateOfBirth = new SimpleObjectProperty<>();
        this.city = new SimpleStringProperty();
        this.student = new SimpleBooleanProperty();
        this.institution = new SimpleStringProperty();
        this.currentLanguage = new SimpleStringProperty();
        this.favoriteLanguage = new SimpleStringProperty();
        this.about = new SimpleStringProperty();
    }

    public User(Long id, String username, String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String languageToLearn, String about) {
        this.id = new SimpleLongProperty(id);
        this.username = new SimpleStringProperty(username);
        this.firstname = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.gender = new SimpleObjectProperty<>(gender);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.city = new SimpleStringProperty(city);
        this.student = new SimpleBooleanProperty(student);
        this.institution = new SimpleStringProperty(institution);
        this.favoriteLanguage = new SimpleStringProperty(favoriteLanguage);
        this.currentLanguage = new SimpleStringProperty(languageToLearn);
        this.about = new SimpleStringProperty(about);
    }

    public User(String username, String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String languageToLearn, String about) {
        this.username = new SimpleStringProperty(username);
        this.firstname = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.gender = new SimpleObjectProperty<>(gender);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.city = new SimpleStringProperty(city);
        this.student = new SimpleBooleanProperty(student);
        this.institution = new SimpleStringProperty(institution);
        this.favoriteLanguage = new SimpleStringProperty(favoriteLanguage);
        this.currentLanguage = new SimpleStringProperty(languageToLearn);
        this.about = new SimpleStringProperty(about);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public Character getGender() {
        return gender.get();
    }

    public SimpleObjectProperty<Character> genderProperty() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender.set(gender);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public boolean isStudent() {
        return student.get();
    }

    public SimpleBooleanProperty studentProperty() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student.set(student);
    }

    public String getInstitution() {
        return institution.get();
    }

    public SimpleStringProperty institutionProperty() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution.set(institution);
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage.get();
    }

    public SimpleStringProperty favoriteLanguageProperty() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage.set(favoriteLanguage);
    }

    public String getCurrentLanguage() {
        return currentLanguage.get();
    }

    public SimpleStringProperty currentLanguageProperty() {
        return currentLanguage;
    }

    public void setCurrentLanguage(String currentLanguage) {
        this.currentLanguage.set(currentLanguage);
    }

    public String getAbout() {
        return about.get();
    }

    public SimpleStringProperty aboutProperty() {
        return about;
    }

    public void setAbout(String about) {
        this.about.set(about);
    }

    public int getYears() {
        if (dateOfBirth == null) {
            throw new IllegalStateException("Date of birth not defined for user: " + this);
        }
        return Period.between(dateOfBirth.get(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
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
