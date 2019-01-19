package com.back.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.back.dao.AdresseRepository;
import com.back.dao.AgenceRepository;
import com.back.dao.CompteRepository;
import com.back.dao.UserRepository;
import com.back.dao.VirementRepository;
import com.back.entities.Adresse;
import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.User;
import com.back.entities.Virement;
import com.back.metier.UserMetier;
import com.google.gson.Gson;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class JMSListeners {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdresseRepository adresseRepository;

	@Autowired
	private AgenceRepository agenceRepository;
	
	@Autowired
	private VirementRepository virementRepository;
	
	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private UserMetier userMetier;

	@JmsListener(destination = "photos1")
	public void receive(Message message) throws JMSException, ParseException {

		if (message instanceof TextMessage) {

			String contenu = ((TextMessage) message).getText();
			System.out.println("**************************************************");
			System.out.println("Réception de : " + contenu);
			System.out.println("**************************************************");

			ActiveMQConnectionFactory jmsConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection connection = jmsConnectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			

			Destination destination = session.createQueue("photos2");
			MessageProducer messageProducer = session.createProducer(destination);

			if (contenu.equals("users")) {

				Destination destinationn = session.createQueue("user");
				MessageProducer messageProducerr = session.createProducer(destinationn);
				//List<User> ll=userRepository.listUser();
				List<User> ll = userRepository.findAll();
				ArrayList<String> arrayList=new ArrayList<String>();
				System.out.println(ll.size());
				for(int i=0;i<ll.size();i++) {
					//u.id_user, u.CIN, u.email, u.password, u.nom, u.prenom, u.pays, u.ville, u.date_naissance, u.date_ouverture, u.date_adhesion
					String ss=ll.get(i).getId_user()+","+ll.get(i).getCIN()+","+ll.get(i).getEmail()+","+ll.get(i).getPassword()+","+ll.get(i).getNom()+","+ll.get(i).getPrenom()+","+ll.get(i).getPays()+","+ll.get(i).getVille()+","+ll.get(i).getDate_naissance()+","+ll.get(i).getDate_ouverture()+","+ll.get(i).getDate_adhesion();
					arrayList.add(ss);
					System.out.println("User number "+i+" is added to arraylist in jmslistener");
				}
				
				//arrayList.addAll(ll);
				
				
				ObjectMessage objectMessage = session.createObjectMessage();
				objectMessage.setObject(arrayList);
				messageProducerr.send(objectMessage);
				System.out.println("list sent");
				/*
				 * ArrayList<String> obj = new ArrayList<String>(); // ArrayList is serialized
				 * 
				 * List<User> ll=userRepository.listUser(); for(int i=0;i<ll.size();i++) {
				 * String s=ll.get(i). } obj.addAll();
				 * 
				 * 
				 * 
				 * try { ObjectMessage objectMessage = session.createObjectMessage();
				 * objectMessage.setObject(obj);
				 * System.out.println("the list of users is not yet sent");
				 * messageProducer.send(objectMessage);
				 * System.out.println("the list of users is sent"); } catch (Exception e) {
				 * System.out.println(e); }
				 */

			} else if (contenu.startsWith("email")) {// "email|kl@gmail.com|kl1234"
				
				int l = contenu.length();
				System.out.println(l);
				String emailandpass = contenu.substring(6, l);
				System.out.println(emailandpass);
				String[] parts = emailandpass.split(",");

				String email = parts[0];
				String password = parts[1];
				System.out.println(email);
				System.out.println(password);
				
				try {
					

					User u = new User();
					u = userRepository.authentify(email, password);

					if (u != null) {
						System.out.println("in ok");
						TextMessage textMessage = session.createTextMessage();
						textMessage.setText("ok");
						messageProducer.send(textMessage);
					} else {

						System.out.println("in not ok");
						TextMessage textMessage = session.createTextMessage();
						textMessage.setText("notok");
						messageProducer.send(textMessage);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (contenu.equals("agences")) {
				Destination destinationn = session.createQueue("agence");
				MessageProducer messageProducerr = session.createProducer(destinationn);
				List<String> la = agenceRepository.findAllAgenceNames();
				String s = "";
				for (int i = 0; i < la.size(); i++) {
					s = s+la.get(i)+ ",";
				}
				s = s.substring(0, s.length() - 1);
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(s);
				messageProducerr.send(textMessage);
				System.out.println(s);
				System.out.println("agence sent to :"+destination.toString());
			}
			else if(contenu.startsWith("lop")) {
				Destination destinationn = session.createQueue("lopag");
				MessageProducer messageProducerr = session.createProducer(destinationn);
				int l = contenu.length();
				String agence = contenu.substring(4, l);
				
				
				Long lagence = agenceRepository.findagenceidByName(agence);
				
				
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(Long.toString(lagence));
				messageProducerr.send(textMessage);
				System.out.println("agence sent to :"+destination.toString());
			}else if(contenu.startsWith("oneuser")) {
				System.out.println("I am in litener one user in JMSLis.. ");
				Destination destinationn = session.createQueue("userone");
				MessageProducer messageProducerr = session.createProducer(destinationn);
				int l = contenu.length();
				System.out.println(l);
				System.out.println(contenu);
				String userid = contenu.substring(7, l);
				System.out.println(userid);
				Long id=Long.parseLong(userid);
				
				
				User u = userRepository.getoneuser(id);
				
				String ss=u.getId_user()+","+u.getCIN()+","+u.getEmail()+","+u.getPassword()+","+u.getNom()+","+u.getPrenom()+","+u.getPays()+","+u.getVille()+","+u.getDate_naissance()+","+u.getDate_ouverture()+","+u.getDate_adhesion();
				System.out.println("user befor"+ss);
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(ss);
				messageProducerr.send(textMessage);
				System.out.println("user sent");
			}else if(contenu.equals("virements")) {
				Destination destinationn = session.createQueue("virements");
				MessageProducer messageProducerr = session.createProducer(destinationn);
				
				List<Virement> ll = virementRepository.findAll();
				ArrayList<String> arrayList=new ArrayList<String>();
				System.out.println(ll.size());
				for(int i=0;i<ll.size();i++) {
					
					String ss=ll.get(i).getId_virement()+","+ll.get(i).getFrom_RIB().getId_compte()+","+ll.get(i).getTo_RIB()+","+ll.get(i).getDate_virement()+","+ll.get(i).getMontant()+","+ll.get(i).getEtat_virement();
					arrayList.add(ss);
					System.out.println("Virment number "+i+" is added to arraylist in jmslistener");
					System.out.println(ss);
				}
				
				//arrayList.addAll(ll);
				
				
				ObjectMessage objectMessage = session.createObjectMessage();
				objectMessage.setObject(arrayList);
				messageProducerr.send(objectMessage);
				System.out.println("list sent");
			}
			else if(contenu.startsWith("compte")) {
				System.out.println("I am in litener one user in JMSLis.. ");
				Destination destinationn = session.createQueue("compteone");
				MessageProducer messageProducerr = session.createProducer(destinationn);
				int l = contenu.length();
				System.out.println(l);
				System.out.println(contenu);
				String userid = contenu.substring(6, l);
				System.out.println(userid);
				Long id=Long.parseLong(userid);
				
				
				Compte c=compteRepository.findCompteById(id);
				
				String ss=c.getId_compte()+","+c.getMoney()+","+c.getMoney_for_transactions()+","+c.getRIB()+","+c.getDate_creation_compte()+","+c.getEtat();
				System.out.println("compte befor"+ss);
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(ss);
				messageProducerr.send(textMessage);
				System.out.println("user sent");
			}else if(contenu.startsWith("deleteoneuser")) {
				int l = contenu.length();
				System.out.println(l);
				System.out.println(contenu);
				String userid = contenu.substring(13, l);
				Long id=Long.parseLong(userid);
				userRepository.deleteById(id);
			}else if(contenu.startsWith("updatethis")) {
				int l = contenu.length();
				System.out.println(l);
				System.out.println(contenu);
				String userupdated = contenu.substring(10, l);
				String[] ss=userupdated.split(",");
				//nom+","+prenom+","+email+","+password+","+cin+","+pays+","+ville+","+;
				
				Long id_user=Long.parseLong(ss[7]);
				
				User u = userRepository.getoneuser(id_user);
				u.setNom(ss[0]);
				u.setPrenom(ss[1]);
				u.setEmail(ss[2]);
				u.setPassword(ss[3]);
				u.setCIN(ss[4]);
				u.setPays(ss[5]);
				u.setVille(ss[6]);
				
				userRepository.save(u);
				System.out.println("user is saved");
				
			}
			/*
			 * TextMessage textMessage=session.createTextMessage();
			 * textMessage.setText("SANDAL"); messageProducer.send(textMessage);
			 */
		}else if(message instanceof ObjectMessage) {
			ObjectMessage om = (ObjectMessage) message;
			Object ob = om.getObject();
			User u =  (User) ob;
			try {
				userRepository.save(u);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
	}

}