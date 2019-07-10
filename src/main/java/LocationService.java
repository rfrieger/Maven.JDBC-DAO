import daos.Connections;
import daos.LocationDao;
import models.Location;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class LocationService implements LocationDao {
    public Connection connection = Connections.getConnection();

    public Location getLocation(Integer id) {
        //Connection connection = Connections.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery("SELECT * FROM locations.location where id=" + id);
            if(rs.next()){
             return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Location> getAllLocations() {
        //Connection connection = Connections.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery("SELECT * FROM locations.location");
            Set locations = new HashSet();

            while (rs.next()){
                Location location = extractUserFromResultSet(rs);
                locations.add(location);
            }

            return locations;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean insertLocation(Location location) {
        //Connection connection = Connections.getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO locations.location VALUES (NULL ,? ,? ,?, ?)");
            ps.setString(1, location.getName());
            ps.setString(2, location.getDescription());
            ps.setString(3, location.getTeam());
            ps.setString(4, location.getCity());

            int i = ps.executeUpdate();
             if( i == 1) {
                 return true;
             }
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
    }

    public Boolean updateLocation(Location location) {
        //Connection connection = Connections.getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE  locations.location SET name=?  ,description=? ,team=?, city=? where id = ?");
            ps.setInt(5, location.getId());
            ps.setString(1, location.getName());
            ps.setString(2, location.getDescription());
            ps.setString(3, location.getTeam());
            ps.setString(4, location.getCity());
            int i = ps.executeUpdate();
            if( i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Boolean deleteLocation(Integer id) {
        //Connection connection = Connections.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM locations.location WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    private Location extractUserFromResultSet(ResultSet rs) throws SQLException {
        Location location = new Location();

        location.setId( rs.getInt("id") );
        location.setName( rs.getString("name"));
        location.setDescription(rs.getString("description"));
        location.setTeam(rs.getString("team"));
        location.setCity(rs.getString("city"));
        return location;
    }
}
