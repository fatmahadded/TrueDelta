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
@Table( name= "Messages")
public class Messages implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="MESS_ID")
private int id; // Clé primaire
@Column(name="MESS_MESSAGE")

private String message ; 
@Column(name="MESS_DATE")
private Date date;
// Constructeur et accesseurs (getters) et mutateurs (setters)
}
