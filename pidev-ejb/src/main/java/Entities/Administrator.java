package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name= "Administrator")
public class Administrator implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdAdmin")
private int id; // Clé primaire
@Column(name="UsernameAdmin")
private String username;
@Column(name="PasswordAdmin")
private String password;

@OneToMany(cascade = CascadeType.ALL, mappedBy="administrators")
private Set<Conflict> Conflict;
 
public Administrator() {} 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Set<Conflict> getConflict() {
	return Conflict;
}
public void setConflict(Set<Conflict> conflict) {
	Conflict = conflict;
}




}
