package data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "team_name")
    private String name;

    @Column(name = "technics")
    private int technics;

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

    public int getTechnics() {
        return technics;
    }

    public void setTechnics(int technics) {
        this.technics = technics;
    }
    //endregion
}
