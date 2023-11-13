-- DELETE SCRIPT
ALTER SEQUENCE kilometrage_kilometrage_id_seq restart WITH 1;
TRUNCATE TABLE Kilometrage;

ALTER SEQUENCE vehicule_vehicule_id_seq RESTART WITH 1;
TRUNCATE TABLE Vehicule CASCADE;

ALTER SEQUENCE marque_marque_id_seq RESTART WITH 1;
TRUNCATE TABLE Marque CASCADE;

ALTER SEQUENCE societe_societe_id_seq RESTART WITH 1;
TRUNCATE TABLE Societe CASCADE;