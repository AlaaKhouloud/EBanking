package com.back.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.dao.UserRepository;
import com.back.entities.Adresse;
import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Role_values;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.entities.Virement;

@Service
public class UserMetierImpl implements UserMetier{

	@Autowired
	private UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public List<String> getUser2(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getUser2(id);
		
	}
	
	@Override
	public User authUser(String email, String pass) {
		// TODO Auto-generated method stub
		return userRepository.authentify(email, pass);
	}
	
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(u);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub	 
		  userRepository.deleteById(id);
		  
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Role_values roleUser(Long id) {
		
	  User u =  userRepository.findById(id).get();
	 
	  return u.getRole();
	  
		 
	}

	@Override
	public User modifUser(User u) {
		// TODO Auto-generated method stub
//Optional<User> userOptional = userRepository.findById(u.getId_user());
		
		//if(userOptional.isPresent());
		
	/*User user_modif = userRepository.findById(u.getId_user()).get();
		
	user_modif.setPrenom(u.getPrenom());
	user_modif.setNom(u.getNom());
	user_modif.setCIN(u.getCIN());
	user_modif.setDate_naissance(u.getDate_naissance());
	user_modif.setPrenom(u.getPrenom());
	user_modif.setPrenom(u.getPrenom());
	user_modif.setPrenom(u.getPrenom());
	user_modif.setPrenom(u.getPrenom());
	
		return userRepository.save(user_modif);   
		
	*/
		return userRepository.save(u);
	}

	@Override
	public List<User> findByIdUser2(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findByIdUser2(id);
	}

	@Override
	public Agence AgenceInfos(Long id_agence) {
		// TODO Auto-generated method stub
		return userRepository.AgenceInfos(id_agence);
	}

	@Override
	public Adresse AdresseInfos(Long id_user) {
		// TODO Auto-generated method stub
		return userRepository.AdresseInfos(id_user);
	}

	@Override
	public Telephone TelephoneInfos(Long id_user) {
		// TODO Auto-generated method stub
		return userRepository.TelephoneInfos(id_user);
	}

	@Override
	public Compte getidcomte(Long id_user) {
		// TODO Auto-generated method stub
		return  userRepository.getidcomte(id_user);
	}

	@Override
	public Virement getMontant(Long id_compte) {
		// TODO Auto-generated method stub
		return  userRepository.getMontant(id_compte);
	}

	
}