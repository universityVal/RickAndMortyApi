package android.dev.alex.rickandmortyapi.model;

import java.lang.reflect.Array;

public class Location {

    Integer id;
    String name;
    String type;
    String demension;
    String URl;
    String created;
    Array residents;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDemension() {
        return demension;
    }

    public String getURl() {
        return URl;
    }

    public String getCreated() {
        return created;
    }

    public Array getResidents() {
        return residents;
    }

    public Location(Integer id, String name, String type, String demension, String URl, String created, Array residents) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.demension = demension;
        this.URl = URl;
        this.created = created;
        this.residents = residents;
    }
}
