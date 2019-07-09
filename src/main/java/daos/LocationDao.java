package daos;

import models.Location;

import java.util.Set;

public interface LocationDao {
    Location getLocation(Integer id);
    Set<Location> getAllLocations();
    Boolean insertLocation(Location location);
    Boolean updateLocation(Location location);
    Boolean deleteLocation(Integer id);
}
