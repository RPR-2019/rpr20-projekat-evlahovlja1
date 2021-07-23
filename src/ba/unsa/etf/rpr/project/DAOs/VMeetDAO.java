package ba.unsa.etf.rpr.project.DAOs;

import ba.unsa.etf.rpr.project.dtos.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//https://stackoverflow.com/questions/10793915/how-to-create-a-dao-for-join-tables
//idem po principu single DAO za citavu aplikaciju
public class VMeetDAO {
    private static final String connString = "jdbc:sqlite:database.db";
    private static final String dumpFile = "dump.sql";
    private Connection connection;

    private static VMeetDAO instance = null;

    private ObservableList<User> users = FXCollections.observableArrayList();
    private SimpleObjectProperty<User> currentUser = new SimpleObjectProperty<>();

    private PreparedStatement
        getAllUsersStatement,
        addUserStatement;

    private void prepareStatements() throws SQLException {
        getAllUsersStatement = connection.prepareStatement("SELECT * FROM user");
        //On an INSERT, if the ROWID or INTEGER PRIMARY KEY column is not explicitly given a value, then it will be filled automatically with an unused integer, usually one more than the largest ROWID currently in use. This is true regardless of whether or not the AUTOINCREMENT keyword is used.
        addUserStatement = connection.prepareStatement("INSERT INTO user (" +
                "username, " +
                "firstname, " +
                "lastname, " +
                "gender, " +
                "dateOfBirth, " +
                "city, " +
                "student, " +
                "institution, " +
                "currentLanguage, " +
                "favoriteLanguage, " +
                "about" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?)");
    }
}
