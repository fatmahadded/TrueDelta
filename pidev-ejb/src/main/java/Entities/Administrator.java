package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name= "Administrator")
public class Administrator implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="ADMIN_ID")
private int id; // Clé primaire
@Column(name="ADMIN_USERNAME")
private String username;
@Column(name="ADMIN_PASSWORD")
private String password;

// Constructeur et accesseurs (getters) et mutateurs (setters)
}
