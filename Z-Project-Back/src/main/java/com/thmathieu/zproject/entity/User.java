package com.thmathieu.zproject.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User", schema = "public")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name  = "identifiant")
	private String identifiant;
	
	@Column(name  = "password")
	private String password;

	@Column(name  = "mail")
	private String mail;
	
	/**
	 * @param identifiant
	 * @param password
	 * @param mail
	 */
	public User(String identifiant, String password, String mail) {
		this.identifiant = identifiant;
		this.password = password;
		this.mail = mail;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return identifiant;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.identifiant = id;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
