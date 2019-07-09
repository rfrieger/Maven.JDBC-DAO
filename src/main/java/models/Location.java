package models;

public class Location {
    Integer id = null;
    String name;
    String description;
    String team;
    String city;

    public Location() {
    }

    ;

    public Location( String name,  String description, String team, String city) {
        this.name = name;
        this.description = description;
        this.team = team;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", team='" + team + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}