package org.vermeg.bookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.vermeg.bookstore.model.Livre;
@Entity
@Table(name="CommandLine")
public class CommandLine {

	
	
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="num")
	String num;	
	
	@Column(name="date_commandeligne")
	String date_commandeligne ;
	
	@Column(name="qte")
	int qte;
	@Column(name="priceCommandLine")
	int priceCommandLine;

	
	public CommandLine(int id, String num, String date_commandeligne, int qte, int priceCommandLine) {
		super();
		this.id = id;
		this.num = num;
		this.date_commandeligne = date_commandeligne;
		this.qte = qte;
		this.priceCommandLine = priceCommandLine;
	}
	
	
	public CommandLine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id_User) {
		this.id = id_User;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDate_commandeligne() {
		return date_commandeligne;
	}
	public void setDate_commandeligne(String date_commandeligne) {
		this.date_commandeligne = date_commandeligne;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getPriceCommandLine() {
		return priceCommandLine;
	}
	public void setPriceCommandLine(int priceCommandLine) {
		this.priceCommandLine = priceCommandLine;
	}
	
	
	
}