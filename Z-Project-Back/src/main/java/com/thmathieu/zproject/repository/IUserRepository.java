package com.thmathieu.zproject.repository;
import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.* ;

import com.thmathieu.zproject.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
	
	/**
	 * Permet de rechercher sur la table User toutes les données stockées
	 * @return une liste d'User ;
	 */
	@Query(value = "Select * from \"User\"", nativeQuery = true)
	List<User> findAllUser();

	/**
	 * Fonction permettant de vérifier si un utilisateur peut se connecter ou non
	 * @param identifiant = identifiant saisie ;
	 * @param password = mot de passe saisie ;
	 * @return un user s'il trouve ou null ;
	 */
	@Query(value = "Select * from \"User\" u where u.identifiant = ?1 AND u.password = ?2", nativeQuery = true)
	User findUserByIdentifiantAndPassword(String identifiant, String password);
}