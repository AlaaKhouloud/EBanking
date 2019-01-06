package com.back.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back.entities.Adresse;
import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Role_values;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.entities.Virement;
import com.back.metier.*;

@Component("myRmiService")
public class EBankingRmiRemoteImpl implements EBankingRmiRemote {

	@Autowired
	private UserMetier userMetier;
	@Autowired
	private AgenceMetier agenceMetier;
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private AdresseMetier adresseMetier;
	
	
	// gestion des utilisateurs
	
	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.getUser(id);
	}
	
	@Override
	public List<String> getUser2(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.getUser2(id);
	}
	
	@Override
	public User authUser(String email, String pass) throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.authUser(email, pass);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#addUser(com.back.entities.User)
	 */
	@Override
	public User addUser(User u) throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.addUser(u);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#modifUser(com.back.entities.User)
	 */
	@Override
	public User modifUser(User u) throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.modifUser(u);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#deleteUser(java.lang.Long)
	 */
	@Override
	public void deleteUser(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		userMetier.deleteUser(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#listUsert()
	 */
	@Override
	public List<User> listUser() throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.listUser();
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#roleUser(java.lang.Long)
	 */
	@Override
	public Role_values roleUser(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return userMetier.roleUser(id);
	}
	
	
	@Override
	public String getAdresse(Long id_user) {
		// TODO Auto-generated method stub
		return adresseMetier.getAdresse(id_user);
	}

	@Override
	public List<User> findByIdUser2(Long id){
		// TODO Auto-generated method stub
		return userMetier.findByIdUser2(id);
	}
	
	
	
	//Informations sur agence
	@Override
		public Agence AgenceInfos(Long id_agence){
			return userMetier.AgenceInfos(id_agence);
		
	}
	
	//Informations de l'Adresse
		@Override
	public Adresse AdresseInfos(Long id_user){
		return userMetier.AdresseInfos(id_user);
		
	}	
	
		//Informations telephone
		@Override
	public Telephone TelephoneInfos(Long id_user){
			
				return userMetier.TelephoneInfos(id_user);
				
			}
		
//gestion compte 
		@Override
		public Compte getidcomte(Long id_user)  {
			// TODO Auto-generated method stub
			return userMetier.getidcomte(id_user);
		}
		
//gestion virement 	
		@Override
		public Virement getMontant(Long id_compte) throws RemoteException {
			// TODO Auto-generated method stub
			return userMetier.getMontant(id_compte);
		}

	
	// gestion des Agences

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#getAgence(java.lang.Long)
	 */
	
	@Override
	public Agence getAgence(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return agenceMetier.getAgence(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#creerAgence(com.back.entities.Agence)
	 */
	@Override
	public Agence creerAgence(Agence a) throws RemoteException {
		// TODO Auto-generated method stub
		return agenceMetier.creerAgence(a);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#listAgence()
	 */
	@Override
	public List<Agence> listAgence() throws RemoteException {
		// TODO Auto-generated method stub
		return agenceMetier.listAgence();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#listAgence()
	 */
	@Override
	public Agence findByName(String name){
		// TODO Auto-generated method stub
		return agenceMetier.findByName(name);
	}
	
/**
 * 
 */
	@Override
	public List<Agence> findAllAgence(String banque) throws RemoteException {
		// TODO Auto-generated method stub
		return agenceMetier.findAllAgence(banque);
	}


	
	
	
	// gestion des Comptes

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#getCompte(java.lang.Long)
	 */
	@Override
	public Compte getCompte(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.getCompte(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#listCompt()
	 */
	@Override
	public List<Compte> listCompt() throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.listCompt();
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#creerCompte(com.back.entities.Compte)
	 */
	@Override
	public Compte creerCompte(Compte c) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.creerCompte(c);
	}

	/*
	 * (non-Javadoc)
	 * @see com.back.rmi.EBankingRmiRemote#SupprimerCompte(java.lang.Long)
	 */
	@Override
	public void SupprimerCompte(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		compteMetier.SupprimerCompte(id);
	}

	


	

	

}
