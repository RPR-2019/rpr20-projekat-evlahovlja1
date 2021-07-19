package ba.unsa.etf.rpr.project.dtos;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private SimpleLongProperty id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastname;
    private SimpleObjectProperty<Character> gender;
    private SimpleObjectProperty<LocalDate> dateOfBirth;
    private SimpleStringProperty city;
    private SimpleBooleanProperty student;
    private SimpleStringProperty institution;
    private SimpleStringProperty favoriteLanguage;
    private SimpleStringProperty languageToLearn;
    private SimpleStringProperty about;

    public User() {
    }

    public User(Long id, String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String languageToLearn, String about) {
        this.id.set(id);
        this.firstName.set(name);
        this.lastname.set(lastname);
        this.gender.set(gender);
        this.dateOfBirth.set(dateOfBirth);
        this.city.set(city);
        this.student.set(student);
        this.institution.set(institution);
        this.favoriteLanguage.set(favoriteLanguage);
        this.languageToLearn.set(languageToLearn);
        this.about.set(about);
    }

    public User(String name, String lastname, char gender, LocalDate dateOfBirth, String city, boolean student, String institution, String favoriteLanguage, String languageToLearn, String about) {
        this.firstName.set(name);
        this.lastname.set(lastname);
        this.gender.set(gender);
        this.dateOfBirth.set(dateOfBirth);
        this.city.set(city);
        this.student.set(student);
        this.institution.set(institution);
        this.favoriteLanguage.set(favoriteLanguage);
        this.languageToLearn.set(languageToLearn);
        this.about.set(about);
    }

    public Long getId() {
        return id.get();
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public char getGender() {
        return gender.get();
    }

    public void setGender(char gender) {
        this.gender.set(gender);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public boolean isStudent() {
        return student.get();
    }

    public void setStudent(boolean student) {
        this.student.set(student);
    }

    public String getInstitution() {
        return institution.get();
    }

    public void setInstitution(String institution) {
        this.institution.set(institution);
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage.get();
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage.set(favoriteLanguage);
    }

    public String getAbout() {
        return about.get();
    }

    public void setAbout(String about) {
        this.about.set(about);
    }

    public String getLanguageToLearn() {
        return languageToLearn.get();
    }

    public void setLanguageToLearn(String languageToLearn) {

        this.languageToLearn.set(languageToLearn);
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public SimpleObjectProperty<Character> genderProperty() {
        return gender;
    }

    public SimpleObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public SimpleBooleanProperty studentProperty() {
        return student;
    }

    public SimpleStringProperty institutionProperty() {
        return institution;
    }

    public SimpleStringProperty favoriteLanguageProperty() {
        return favoriteLanguage;
    }

    public SimpleStringProperty languageToLearnProperty() {
        return languageToLearn;
    }

    public SimpleStringProperty aboutProperty() {
        return about;
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
