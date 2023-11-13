INSERT INTO Societe(nom_societe) VALUES ('ITUniversity');
INSERT INTO Societe(nom_societe) VALUES ('Madauto');
INSERT INTO Societe(nom_societe) VALUES ('Fly Emirates');

INSERT INTO Marque (nom_marque) VALUES ('BMW');
INSERT INTO Marque (nom_marque) VALUES ('Mercedes');
INSERT INTO Marque (nom_marque) VALUES ('Mazda');
INSERT INTO Marque (nom_marque) VALUES ('Ford');

INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('ABC123', 1, 1);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('XYZ789', 2, 2);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('DEF456', 3, 1);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('GHI789', 4, 2);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('JKL012', 1, 3);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('MNO345', 2, 1);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('PQR678', 3, 2);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('STU901', 4, 3);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('VWX234', 1, 1);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('YZA567', 2, 2);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('BCD890', 3, 1);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('EFG123', 4, 2);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('HIJ456', 1, 3);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('KLM789', 2, 1);
INSERT INTO Vehicule (immatriculation, marque_id_vehicule, societe_id_vehicule) VALUES ('NOP012', 3, 2);


INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur1@example.com', 'motdepasse1', 'Utilisateur 1');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur2@example.com', 'motdepasse2', 'Utilisateur 2');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur3@example.com', 'motdepasse3', 'Utilisateur 3');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur4@example.com', 'motdepasse4', 'Utilisateur 4');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur5@example.com', 'motdepasse5', 'Utilisateur 5');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur6@example.com', 'motdepasse6', 'Utilisateur 6');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur7@example.com', 'motdepasse7', 'Utilisateur 7');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur8@example.com', 'motdepasse8', 'Utilisateur 8');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur9@example.com', 'motdepasse9', 'Utilisateur 9');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur10@example.com', 'motdepasse10', 'Utilisateur 10');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur11@example.com', 'motdepasse11', 'Utilisateur 11');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur12@example.com', 'motdepasse12', 'Utilisateur 12');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur13@example.com', 'motdepasse13', 'Utilisateur 13');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur14@example.com', 'motdepasse14', 'Utilisateur 14');
INSERT INTO Utilisateur (email, mot_de_passe, nom_utilisateur) VALUES ('utilisateur15@example.com', 'motdepasse15', 'Utilisateur 15');

INSERT INTO Role (role_name) VALUES ('ROLE_USER');
INSERT INTO Role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO Utilisateurs_role (role_id, utilisateur_id) VALUES (1, 1);
INSERT INTO Utilisateurs_role (role_id, utilisateur_id) VALUES (1, 2);
INSERT INTO Utilisateurs_role (role_id, utilisateur_id) VALUES (2, 1);
