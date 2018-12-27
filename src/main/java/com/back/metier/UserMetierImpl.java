package com.back.metier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.dao.UserRepository;
import com.back.entities.Role_values;
import com.back.entities.User;

@Service
public class UserMetierImpl implements UserMetier{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
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
	 
	  return u.getRole().getRole();
	  
		 
	}

	@Override
	public User modifUser(User u) {
		// TODO Auto-generated method stub
		return null;                                 /////// à implementer !!!!!!!!!!!!!!!!!!!!!!!!
	}

	
}
