package com.back.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Role_values;
import com.back.entities.User;
import com.back.metier.*;

@Component("myRmiService")
public class EBankingRmiRemoteImpl implements EBankingRmiRemote {

	@Autowired
	private UserMetier userMetier;
	@Autowired
	private AgenceMetier agenceMetier;
	@Autowired
	private CompteMetier compteMetier;
	
	
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
