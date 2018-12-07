Role (id_role , role , description)
Agence (id_agence , nom , pays , ville , adresse)
Compte (id_compte , id_agence , id_role , CIN , mdp , nom , prenom , pays , ville , adresse , telephone , date_naissance , RIB , solde , Date_adhésion , état_compte)
Virement (id_virement , id_compte_from , id_compte_to , date_virement , etat_virement , montant)
Recharge_tel (id_recharge , id_compte_from , telephone , date_recharge , montant_recharge)

