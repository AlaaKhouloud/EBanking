package com.back.metier;

import java.util.List;


import com.back.entities.*;

import com.back.entities.User;

public interface UserMetier {
	
	public User getUser(Long id);
	public User addUser(User u);
	public User modifUser(User u);
	public void deleteUser(Long id);
	public List<User> listUser();
	
	//verifier le role de l'utilisateur
	public Role_values roleUser(Long id); 

	
}
