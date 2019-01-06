package com.back.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.back.entities.Adresse;
import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Role_values;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.entities.Virement;

public interface EBankingRmiRemote extends Remote {


	/*
	 * traitements sur l'utilisateur
	 */
	public User getUser(Long id)throws RemoteException;
	public User authUser(String email, String pass)throws RemoteException;
	public User addUser(User u)throws RemoteException;
	public User modifUser(User u)throws RemoteException;
	public void deleteUser(Long id)throws RemoteException;
	public List<User> listUser()throws RemoteException;
	public List<String> getUser2(Long id)throws RemoteException;
	
	//verifier le role de l'utilisateur
	public Role_values roleUser(Long id)throws RemoteException;
	
	
	//selectionser les adresses de l'utilisateur
	public String getAdresse(Long id_user)throws RemoteException;
	
	
	
	public List<User> findByIdUser2(Long id)throws RemoteException;
	
	//Informations sur agence
	public Agence AgenceInfos(Long id_agence)throws RemoteException;
	//Informations de l'adresse
	public Adresse AdresseInfos(Long id_user)throws RemoteException; 
	//Informations Telephone
	public Telephone TelephoneInfos(Long id_user)throws RemoteException; 
	
	//Information compte 
	public Compte getidcomte(Long id_user) throws RemoteException; 
	
	
	//Information virement 
	
	public Virement getMontant(Long id_compte)throws RemoteException; 
	
	
	
	/*
	 * traitements sur l'agence 
	 */
	
	public Agence getAgence(Long id) throws RemoteException;
	public Agence creerAgence(Agence a)throws RemoteException;
	public List<Agence> listAgence()throws RemoteException;
	public Agence findByName(String name)throws RemoteException;
	public List<Agence> findAllAgence(String banque)throws RemoteException;
	
	/*
	 * traitements sur le compte
	 */
	
	public Compte getCompte(Long id)throws RemoteException;
	public List<Compte> listCompt()throws RemoteException;
    public Compte creerCompte(Compte c)throws RemoteException;
    public void SupprimerCompte(Long id)throws RemoteException;
	//public void changer_status_client(Long id_user)throws RemoteException;
    
	 
}
