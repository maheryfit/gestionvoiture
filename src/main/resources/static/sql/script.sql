-- CREATE TABLE SCRIPT
CREATE TABLE Societe (
    societe_id SERIAL PRIMARY KEY,
    nom_societe VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE Marque (
    marque_id SERIAL PRIMARY KEY ,
    nom_marque varchar(35) NOT NULL UNIQUE
);

CREATE TABLE Vehicule (
    vehicule_id SERIAL PRIMARY KEY,
    immatriculation varchar(20) UNIQUE NOT NULL,
    marque_id_vehicule INTEGER REFERENCES Marque(marque_id),
    societe_id_vehicule INTEGER REFERENCES Societe(societe_id)
);

CREATE TABLE Kilometrage (
    kilometrage_id       SERIAL  NOT NULL  ,
    vehicule_id_kilometrage integer  NOT NULL  ,
    date_kilometrage     date DEFAULT CURRENT_DATE NOT NULL,
    debut_km             bigint  NOT NULL  ,
    fin_km               bigint  NOT NULL  ,
    CONSTRAINT pk_kilometrage PRIMARY KEY ( kilometrage_id )
);
ALTER TABLE Kilometrage ADD CONSTRAINT fk_kilometrage_vehicule FOREIGN KEY ( vehicule_id_kilometrage ) REFERENCES Vehicule( vehicule_id );

CREATE TABLE Utilisateur (
    utilisateur_id       bigserial NOT NULL  ,
    email                varchar(255)  NOT NULL  ,
    mot_de_passe         varchar(255)  NOT NULL  ,
    nom_utilisateur      varchar(255)  NOT NULL  ,
    CONSTRAINT utilisateur_pkey PRIMARY KEY ( utilisateur_id ),
    CONSTRAINT uk_rma38wvnqfaf66vvmi57c71lo UNIQUE ( email )
);

CREATE TABLE Role(
    role_id       SERIAL  NOT NULL  PRIMARY KEY,
    role_name     varchar(25)  NOT NULL
);


CREATE TABLE Utilisateurs_role (
    role_id         INTEGER NOT NULL REFERENCES Role(role_id),
    utilisateur_id  BIGINT NOT NULL REFERENCES Utilisateur(utilisateur_id)
);
