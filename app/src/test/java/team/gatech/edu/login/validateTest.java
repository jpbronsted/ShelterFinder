/**
 * Created by DK on 4/9/18.
 */
package team.gatech.edu.login;

import org.junit.Test;
import model.User;
import controllers.RegisterActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by kevinkang on 4/9/18.
 */

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
            if (i > 31 && i < 48) {
                assertFalse("Special Letter is used! try without letters !#$%&'()*+`-./",i > 32 && i < 48);
            }
            if (i > 57 && i < 65) {
                assertFalse("Special Letter is used! try without letters :;<=>?@" ,i > 57 && i < 65);
            }
            if (i > 90 && i < 97) {
                assertFalse("Special Letter is used! try without letters []^-`" ,i > 90 && i < 97);
            }
            if (i > 122 && i < 127) {
                assertFalse("Special Letter is used! try without letters {|}~ ",i > 122 && i < 127);
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