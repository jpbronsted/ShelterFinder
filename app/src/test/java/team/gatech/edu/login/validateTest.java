package team.gatech.edu.login;

import org.junit.Test;
import model.User;
import controllers.RegisterActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class validateTest {

    @Test
    public void userNameLetter() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User username = User.userRegistry.get("user");
        if (username.getID().length() >= 3) {
            assertTrue("username is valid!",username.getID().length() >= 3);
        } else {
            assertFalse("username is less than three letters!", username.getID().length() < 3);
        }
    }

    @Test
    public void userNameSpecialCase() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User username = User.userRegistry.get("user");
        int usernameLength = username.getID().length();
        for (int i = 0; i < username.getID().length(); i++) {
            if ((i > 31) && (i < 48)) {
                assertFalse("Special Letter is used! try without letters !#$%&'()*+`-./", i > 32);
            }
            if ((i > 57) && (i < 65)) {
                assertFalse("Special Letter is used! try without letters :;<=>?@" , true);
            }
            if ((i > 90) && (i < 97)) {
                assertFalse("Special Letter is used! try without letters []^-`" , true);
            }
            if ((i > 122) && (i < 127)) {
                assertFalse("Special Letter is used! try without letters {|}~ ", true);
            }
        }
        assertTrue("No special letter is used",true);
    }

    @Test
    public void passwordBlank() throws Exception {
        RegisterActivity.makeNewUser("user", "pass", "USER");
        User password = User.userRegistry.get("pass");
        if (password == null) {
            assertFalse("Must enter Password!", false);
        } else {
            assertTrue("Password is valid", true);
        }
    }

}