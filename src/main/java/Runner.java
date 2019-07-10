import models.Location;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        LocationService locationService = new LocationService();

        Location locations = new Location("Frankfurt Hall", "German Beer Garden", "Bayern Munich", "Philadelpahia");

        Location location = locationService.getLocation(1);
        System.out.println(location.toString());


        Set<Location> locationList = locationService.getAllLocations();
        for(Location l : locationList) {
            System.out.println(l.toString());
       }

        locationService.insertLocation(locations);

    }
}
