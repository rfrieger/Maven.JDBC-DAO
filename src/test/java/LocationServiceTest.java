import models.Location;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.*;

public class LocationServiceTest {

    @Test
    public void getLocation() {
        LocationService locationService = new LocationService();
        Location location = locationService.getLocation(2);
        try {
            locationService.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String expected = location.getName();
        String actual = "Brauhaus Schmits";


        Assert.assertEquals(actual,expected);

    }

    @Test
    public void getAllLocations() {
        LocationService locationService = new LocationService();
        Set<Location> set = locationService.getAllLocations();

        try {
            locationService.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Integer expected = set.size();
        Integer actual = 5;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void insertLocation() {
        LocationService locationService = new LocationService();

        Location locations = new Location("Frankfurt Hall", "German Beer Garden", "Bayern Munich", "Philadelpahia");
        locationService.insertLocation(locations);

        Set<Location> set = locationService.getAllLocations();

        Integer expected = set.size();
        Integer actual = 6;

        Assert.assertEquals(actual,expected);

        locationService.deleteLocation(7);

        try {
            locationService.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateLocation() {
        LocationService locationService = new LocationService();

        Location locations = new Location("Frankfurt Hall", "German Beer Garden", "Bundesliga", "Philadelpahia");
        locations.setId(6);
        locationService.updateLocation(locations);

        String expected = locationService.getLocation(6).getTeam();
        String actual = "Bundesliga";


        Assert.assertEquals(actual,expected);

        try {
            locationService.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void deleteLocation() {
        LocationService locationService = new LocationService();

        Location locations = new Location("Frankfurt Hall", "German Beer Garden", "Bayern Munich", "Philadelpahia");

        locationService.insertLocation(locations);
        locationService.deleteLocation(7);

        Set<Location> set = locationService.getAllLocations();

        Integer expected = set.size();
        Integer actual = 6;

        Assert.assertEquals(actual,expected);

        try {
            locationService.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}