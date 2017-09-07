package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    //TODO add a method or methods to return a single user based on search criteria

    public List<User> searchUsers(String searchType, String searchTerm) {
        String queryString = "";
        if (searchType.equals("allUsers")) {
            queryString = viewAll();
        } else {
            queryString = viewByLastName(searchTerm);
        }

        return doSearch(queryString);
    }


    public String viewAll() {
        return "SELECT * FROM users";
    }


    public String viewByLastName(String lastName) {
        return "SELECT * FROM users WHERE last_name LIKE '%" + lastName + "%'";
    }

    public List<User> doSearch(String sql) {

        logger.info("The sql statement was : " + sql);
        logger.error("(error) The sql statement was : " + sql);

        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        //String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return users;
    }


    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        // TODO map the remaining fields
        user.setUserid(results.getString("id"));
        user.setFirstName(results.getString("first_name"));
        user.setDateOfBirth(results.getString("date_of_birth"));
        return user;
    }

}