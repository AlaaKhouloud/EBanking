package com.back.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Role_values;
import com.back.entities.User;

public interface EBankingRmiRemote extends Remote {


	/*
	 * traitements sur l'utilisateur
	 */
	public User getUser(Long id)throws RemoteException;
	public User addUser(User u)throws RemoteException;
	public User modifUser(User u)throws RemoteException;
	public void deleteUser(Long id)throws RemoteException;
	public List<User> listUser()throws RemoteException;
	
	//verifier le role de l'utilisateur
	public Role_values roleUser(Long id)throws RemoteException;
	
	
	/*
	 * traitements sur l'agence 
	 */
	
	public Agence getAgence(Long id) throws RemoteException;
	public Agence creerAgence(Agence a)throws RemoteException;
	public List<Agence> listAgence()throws RemoteException;
	
	/*
	 * traitements sur le compte
	 */
	
	public Compte getCompte(Long id)throws RemoteException;
	public List<Compte> listCompt()throws RemoteException;
    public Compte creerCompte(Compte c)throws RemoteException;
    public void SupprimerCompte(Long id)throws RemoteException;
    
	 
}
