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
@Table( name= "Feedback")
public class Feedback implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="FEED_ID")
private int id; // Clé primaire
@Column(name="FEED_MESS")
private String message;
@Column(name="FEED_SCO")
private int score;
// Constructeur et accesseurs (getters) et mutateurs (setters)
}
