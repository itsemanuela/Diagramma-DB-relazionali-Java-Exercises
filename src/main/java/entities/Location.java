package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "location")

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeLocation;
    private String city;


    public Location() {}

    public Location(  String nomeLocation, String city) {

        this.nomeLocation = nomeLocation;
        this.city = city;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeLocation() {
        return nomeLocation;
    }
    public void setNomeLocation(String nomeLocation) {
        this.nomeLocation = nomeLocation;
    }

}
