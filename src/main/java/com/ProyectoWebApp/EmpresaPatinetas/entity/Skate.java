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
     * Get of the Id attribute
     * @return getters ans setters
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set Id of Skate
     * @param id, Skate identification
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get of the brand attribute
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set brand attribute
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get of the Skate year
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set Skate year
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Get of the Skate name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set of the Skate name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get of the Skate Description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set Skate Description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get Skate Category
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set Skate category
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Get of the reservations associated to an skate
     * @return a list of reservatios
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Set Reservations associated to an skate
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Get Messages associated to an skate
     * @returna a list of messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Set messages associated to an skate
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
