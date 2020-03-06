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
@Table( name= "Transaction")
public class Transaction implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="TRANS_ID")
private int id; // Clé primaire
@Column(name="TRANS_NAME")
private double amount;
// Constructeur et accesseurs (getters) et mutateurs (setters)
}
