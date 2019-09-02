package data;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "field")
public class Field {

    public Field() {
    }

    public Field(UUID id, String name, int square, Date sowingDate, UUID farmId) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.sowingDate = sowingDate;
        this.farmId = farmId;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "field_name")
    private String name;

    @Column(name = "square")
    private int square;

    @Column(name = "sowing_date")
    @Temporal(value = TemporalType.DATE)
    private Date sowingDate;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    private UUID farmId;

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

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public Date getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(Date sowingDate) {
        this.sowingDate = sowingDate;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public UUID getFarmId() {
        return farmId;
    }

    public void setFarmId(UUID farmId) {
        this.farmId = farmId;
    }
}
