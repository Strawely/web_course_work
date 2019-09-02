package data;

import javax.persistence.*;
import java.util.UUID;

public class Farm {

    public Farm(){}

    public Farm(UUID id, String name, String owner, double xCoord, double yCoord) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    private UUID id;

    private String name;

    private String owner;

    private double xCoord;

    private double yCoord;

    //region Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }
    //endregion
}
