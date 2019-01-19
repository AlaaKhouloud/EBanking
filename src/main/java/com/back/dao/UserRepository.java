package com.back.dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.back.entities.Adresse;
import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.entities.Virement;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u where email = :x1 and password = :x2")
	public User findByEmail(@Param("x1") String email,@Param("x2")  String mot_de_passe);
	
	
	@Query("SELECT u FROM User u where email = :x1")
	public User findByUsername(@Param("x1")String email);
	
	@Query("SELECT u FROM User u where id_user = :x1")
	public List<User> findByIdUser2(@Param("x1") Long id);
	
	@Query("SELECT u FROM User u where nom = :x1")
	public User findByName(@Param("x1") String name);
	
	@Query("SELECT u FROM User u where email = :x1 and password = :x2")
	public User authentify(@Param("x1") String email , @Param("x2") String mdp );
	

	@Query("SELECT u FROM User u where email = :x1")
	public User findByEmailIgnoreCase(@Param("x1") String username);
	
	@Query("SELECT u.prenom, u.nom FROM User u where id_user = :x1")
	public List<String> getUser2(@Param("x1") Long id);
	
	@Query("SELECT a FROM Agence a where id_agence = :x1")
	public Agence AgenceInfos(@Param("x1") Long id_agence);
	
	@Query("SELECT a FROM Adresse a INNER JOIN User u on a.user.id_user = u.id_user where  a.user.id_user = :x1")
	public Adresse AdresseInfos(@Param("x1") Long id_user);
	
	@Query("SELECT t FROM Telephone t INNER JOIN User u on t.user.id_user = u.id_user where  t.user.id_user = :x1")
	public Telephone TelephoneInfos(@Param("x1") Long id_user);
	@Query("SELECT t FROM Compte t INNER JOIN User u on t.user_cpt.id_user = u.id_user where  t.user_cpt.id_user = :x1")
	public Compte getidcomte(@Param("x1") Long id_user);
	@Query("SELECT t FROM Virement t INNER JOIN Compte u on t.from_RIB.id_compte = u.id_compte where  t.from_RIB.id_compte = :x1")
	public Virement getMontant(@Param("x1") Long id_compte);
	
	
	@Query("SELECT u FROM User u where u.id_user = :x1")
	public User getoneuser(@Param("x1") Long id);
 
}
