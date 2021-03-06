package com.thmathieu.zproject.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import com.thmathieu.zproject.repository.IUserRepository;
import com.thmathieu.zproject.entity.User;
import com.thmathieu.zproject.dto.UserDto;

@RestController
public class UserService {
	
	@Autowired
	private IUserRepository iUserRepository ;
	
	/**
	 * Permet de mapper un UserEntity en un UserDto
	 * @param userEntity = user à mapper ;
	 * @return un userDto ;
	 */
	private UserDto mappingUserEntityToUserDto(User userEntity) {
		UserDto userDto = new UserDto() ;
		
		if(!userEntity.equals(null)) {
			userDto.setId(userEntity.getId());
			userDto.setMail(userEntity.getMail());
			userDto.setPassword(userEntity.getPassword());
		}
		
		return userDto ;
	}
	
	/**
	 * Permet de mapper une liste d'UserEntity en une liste d'User
	 * @param listUserEntity = liste à convertir ;
	 * @return une liste d'UserDto ;
	 */
	private List<UserDto> mappingUserEntityAll(List<User> listUserEntity) {
		List<UserDto> listUserDto = new ArrayList<UserDto>();
		
		if(!listUserEntity.isEmpty()) {
			for(int i = 0 ; i < listUserEntity.size() ; i++) {
				listUserDto.add(this.mappingUserEntityToUserDto(listUserEntity.get(i)));
			}
		}
		
		return listUserDto ;
	}
	
	/**
	 * Fonction permettant de récuperer toutes les personnes qui se sont inscrit sur le site
	 * @return une liste d'utilisateur ;
	 */
	@GetMapping(value = "/allUser")
	public ResponseEntity<List<UserDto>> getAllUser() {
		try {
			List<User> listUserEntity = this.iUserRepository.findAllUser();
			List<UserDto> listUserDto = this.mappingUserEntityAll(listUserEntity);
			
			return new ResponseEntity<>(listUserDto, HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null ;
	}
	
	@GetMapping(value = "/canConnect/{identifiant}/{password}")
	public ResponseEntity<Boolean> canConnect(@PathVariable(value = "identifiant", required = true)@NotNull String identifiant, 
											  @PathVariable(value = "password", required = true )@NotNull String password) {
		try {
			User userEntity = this.iUserRepository.findUserByIdentifiantAndPassword(identifiant, password);
			
			if(!userEntity.equals(null)) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ResponseEntity<>(false, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/canUser/{mail}")
	public ResponseEntity<Boolean> canSubscribe(@PathVariable(value = "mail", required = true)@NotNull String mail) {
		try {
			User userEntity = this.iUserRepository.findExistUser(mail) ;
			if(userEntity == null) {
				
			}
			
			if(userEntity.equals(null)) {
				return new ResponseEntity<>(true, HttpStatus.OK) ;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ResponseEntity<>(true, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/inscription/{identifiant}/{password}/{mail}")
	public ResponseEntity<Boolean> inscription(@PathVariable(value = "identifiant")String identifiant, 
											   @PathVariable(value = "password")String password,
											   @PathVariable(value = "mail")String mail) {
		try {
			if(!this.iUserRepository.findExistUser(mail).equals(null)) {
				return new ResponseEntity<>(false, HttpStatus.OK) ;
			}
			
			this.iUserRepository.insertUser(identifiant, password, mail);
			
			if(this.iUserRepository.findExistUser(mail).equals(null)) {
				return new ResponseEntity<>(false, HttpStatus.OK) ;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ResponseEntity<>(false, HttpStatus.OK) ;
	}
	
}
