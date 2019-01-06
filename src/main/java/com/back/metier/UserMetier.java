package com.back.metier;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.entities.*;

public interface UserMetier {
	
	public User getUser(Long id);
	public List<String> getUser2(Long id);
	public User authUser(String email, String pass);
	public User addUser(User u);
	public User modifUser(User u);
	public void deleteUser(Long id);
	public List<User> listUser();
	
	//verifier le role de l'utilisateur
	public Role_values roleUser(Long id); 

	
	
	public List<User> findByIdUser2(Long id);
	
	
	//Information sur Agence
	public Agence AgenceInfos(Long id_agence);
	//Information de l'adresse
	public Adresse AdresseInfos(Long id_user);
	//Information telephone
	public Telephone TelephoneInfos(Long id_user);
	
	//information compte
	public Compte getidcomte(Long id_user);
	
	//information virment 
	public Virement getMontant(Long id_compte);
	
	//changer status enabled 
	
	//public void changer_status_client(Long id_user);

	
}
