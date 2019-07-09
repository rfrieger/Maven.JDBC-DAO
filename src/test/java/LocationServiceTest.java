import models.Location;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class LocationServiceTest {

    @Test
    public void getLocation() {
        LocationService locationService = new LocationService();
        Location location = locationService.getLocation(2);

        String expected = location.getName();
        String actual = "Brauhaus Schmits";

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void getAllLocations() {
        LocationService locationService = new LocationService();
        Set<Location> set = locationService.getAllLocations();

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
    }

    @Test
    public void updateLocation() {
        LocationService locationService = new LocationService();

        Location locations = new Location("Frankfurt Hall", "German Beer Garden", "Bundesliga", "Philadelpahia");

        locationService.updateLocation(locations);

        String expected = locationService.getLocation(6).getTeam();
        String actual = "Bundesliga";

        Assert.assertEquals(actual,expected);


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
    }
}