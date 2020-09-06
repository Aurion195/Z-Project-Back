package com.thmathieu.zproject.dto;
public class UserDto {
	private String id;
	private String password;
	private String mail;
	
	/**
	 * Constructeur de l'utilisateur
	 * @param id = identifiant ;
	 * @param password = mot de passe;
	 * @param mail = mail;
	 */
	public UserDto(String id, String password, String mail) {
		this.id = id;
		this.password = password;
		this.mail = mail;
	}
	
	public UserDto() {};
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
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
		this.id = id;
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
