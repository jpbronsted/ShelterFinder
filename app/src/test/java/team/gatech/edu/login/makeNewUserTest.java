package team.gatech.edu.login;

import org.junit.Test;

import model.AccountType;
import model.User;
import controllers.RegisterActivity;

import static org.junit.Assert.*;



/**
 * Created by DK on 4/9/18.
 */

public class makeNewUserTest {

    @Test
    public void checkUserID() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User a = User.userRegistry.get("user");
        assertEquals(a.getID(), "user");
    }

    @Test
    public void checkUserPass() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User a = User.userRegistry.get("user");
        assertEquals(a.getPassword(), "pass");
    }

    @Test
    public void checkTypeUser() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User a = User.userRegistry.get("user");
        assertEquals(a.getType(), AccountType.USER);
    }

    @Test
    public void checkTypeAdmin() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "ADMIN");
        User a = User.userRegistry.get("user");
        assertEquals(a.getType(), AccountType.ADMIN);
    }

    @Test
    public void checkDefault() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "ABC");
        User a = User.userRegistry.get("user");
        assertEquals(a.getType(), null);
    }
}
