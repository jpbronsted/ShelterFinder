package team.gatech.edu.login;

import org.junit.Test;

import model.AccountType;
import model.User;
import controllers.RegisterActivity;

import static org.junit.Assert.*;


/**
 * Test for makeNewUser()
 */
public class makeNewUserTest {

    /**
     * checks user's id
     * @throws Exception test
     */
    @Test
    public void checkUserID() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User a = User.userRegistry.get("user");
        assertEquals(a.getID(), "user");
    }

    /**
     * checks user's password
     * @throws Exception test
     */
    @Test
    public void checkUserPass() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User a = User.userRegistry.get("user");
        assertEquals(a.getPassword(), "pass");
    }

    /**
     * check user type USER
     * @throws Exception test
     */
    @Test
    public void checkTypeUser() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User a = User.userRegistry.get("user");
        assertEquals(a.getType(), AccountType.USER);
    }

    /**
     * check user type ADMIN
     * @throws Exception test
     */
    @Test
    public void checkTypeAdmin() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "ADMIN");
        User a = User.userRegistry.get("user");
        assertEquals(a.getType(), AccountType.ADMIN);
    }

    /**
     * check default user type
     * @throws Exception test
     */
    @Test
    public void checkDefault() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "ABC");
        User a = User.userRegistry.get("user");
        assertEquals(a.getType(), null);
    }
}
