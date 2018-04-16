package team.gatech.edu.login;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import controllers.QueryResultsActivity;
import model.Shelter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrepareSearchResultsTest {

    @Test
    public void returnAllShelters() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("", "", "");
        for (Shelter shelter : Shelter.toArray()) {
            assertTrue(results.contains(shelter));
        }
    }

    @Test
    public void returnShelterName() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("My Sister's House",
                        "", "");
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(Shelter.shelterData.get("My Sister's House"));
        for (Shelter shelter : Shelter.toArray()) {
//            if (expected.contains(shelter)) {
                assertTrue(results.contains(shelter));
//            } else {
//                assertFalse(results.contains(shelter));
//            }
        }
    }

    @Test
    public void returnShelterMen() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("", "Men", "");
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(Shelter.shelterData.get("The Shepherd's Inn"));
        expected.add(Shelter.shelterData.get("Fuqua Center"));
        expected.add(Shelter.shelterData.get("Gateway Center"));
        for (Shelter shelter : Shelter.toArray()) {
//            if (expected.contains(shelter)) {
                assertTrue(results.contains(shelter));
//            } else {
//                assertFalse(results.contains(shelter));
//            }
        }
    }

    @Test
    public void returnShelterWomen() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("", "Women", "");
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(Shelter.shelterData.get("My Sister's House"));
        expected.add(Shelter.shelterData.get("The Atlanta Day Center for Women & Children"));
        expected.add(Shelter.shelterData.get("Eden Village"));
        for (Shelter shelter : Shelter.toArray()) {
//            if (expected.contains(shelter)) {
                assertTrue(results.contains(shelter));
//            } else {
//                assertFalse(results.contains(shelter));
//            }
        }
    }

    @Test
    public void returnShelterMale() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("", "Male", "");
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(Shelter.shelterData.get("The Shepherd's Inn"));
        expected.add(Shelter.shelterData.get("Fuqua Center"));
        expected.add(Shelter.shelterData.get("Gateway Center"));
        for (Shelter shelter : Shelter.toArray()) {
//            if (expected.contains(shelter)) {
                assertTrue(results.contains(shelter));
//            } else {
//                assertFalse(results.contains(shelter));
//            }
        }
    }

    @Test
    public void returnShelterFemale() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("", "Female", "");
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(Shelter.shelterData.get("My Sister's House"));
        expected.add(Shelter.shelterData.get("The Atlanta Day Center for Women & Children"));
        expected.add(Shelter.shelterData.get("Eden Village"));
        for (Shelter shelter : Shelter.toArray()) {
//            if (expected.contains(shelter)) {
                assertTrue(results.contains(shelter));
//            } else {
//                assertFalse(results.contains(shelter));
//            }
        }
    }

    @Test
    public void returnShelterChildren() throws Exception {
        Collection<Shelter> results =
                QueryResultsActivity.prepareSearchResults("", "Children", "");
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(Shelter.shelterData.get("My Sister's House"));
        expected.add(Shelter.shelterData.get("The Atlanta Day Center for Women & Children"));
        expected.add(Shelter.shelterData.get("Eden Village"));
        expected.add(Shelter.shelterData.get("Covenant House Georgia"));
        for (Shelter shelter : Shelter.toArray()) {
//            if (expected.contains(shelter)) {
                assertTrue(results.contains(shelter));
//            } else {
//                assertFalse(results.contains(shelter));
//            }
        }
    }
}