package com.ProyectoWebApp.EmpresaPatinetas.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="skate")
/**
 * This class defines the entity-table skate
 * @author: Laura De Villeros
 */
public class Skate implements Serializable {

    /**
     * Attribute id, Skate identification
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Attribute name of the skate
     */
    @Column(length=45)
    private String name;

    /**
     * Attribute brand of the skate
     */
    @Column(length=45)
    private String brand;

    /**
     * Attribute year of the skate
     */
    private Integer year;

    /**
     * Attribute description of the skate
     */
    @Column(length=250)
    private String description;

    /**
     * Relations with other entities
     */
    @ManyToOne
    @JoinColumn(name ="categoryId")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "skate")
    @JsonIgnoreProperties({"skate","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "skate")
    @JsonIgnoreProperties("skate")
    private List<Reservation> reservations;

    /**
     * Getters and setters of the atributes
     * @return getters ans setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
