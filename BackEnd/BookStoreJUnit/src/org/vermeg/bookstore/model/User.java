package org.vermeg.bookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
	
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id_User;
	
	@Column(name="name")
	String name;	
	
	@Column(name="familyName")
	String familyName ;
	
	@Column(name="date_naissance")
	Date date_naissance;

	public User(int id_User, String name, String familyName, Date date_naissance) {
		super();
		this.id_User = id_User;
 		this.name = name;
		this.familyName = familyName;
		this.date_naissance = date_naissance;
	}

	public User() {
	}

	public int getId_User() {
		return id_User;
	}

	public void setId_User(int id_User) {
		this.id_User = id_User;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	
	}