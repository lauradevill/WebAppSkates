package com.ProyectoWebApp.EmpresaPatinetas.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
/**
 * This class defines the entity-table admin
 * @author: Laura De Villeros
 */
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;

    @Column(length=250)
    private String nameAdmin;

    @Column(length=45)
    private String emailAdmin;

    @Column(length=45)
    private String passwordAdmin;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
}
