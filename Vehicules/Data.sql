create table utilisateur (
    id_utilisateur serial primary key,
    nom_utilisateur varchar(100),
    prenom_utilisateur varchar(100),
    ville VARCHAR(50),
    contact VARCHAR(50),
    mail VARCHAR(100),
    mdp varchar(100)
);
insert into utilisateur(nom_utilisateur, prenom_utilisateur, ville, contact, mail, mdp) values ('Rakoto','Jean','Antananarivo','+261 34 01 437 24','jean@gmail.com','jean');

create table admin (
    id_admin serial primary key,
    nom_admin varchar(50),
    email varchar(50),
    mdp varchar(50)
);

create table categorie (
    id_categorie serial primary key,
    nom_categorie varchar(50)
);
insert into categorie(nom_categorie) values('Voiture de sport');
insert into categorie(nom_categorie) values('Poids lourd');
insert into categorie(nom_categorie) values('Voiture legere');

create table marque (
    id_marque serial primary key,
    nom_marque varchar(50)
);

create table etat (
    id_etat serial primary key,
    nom_etat varchar(50)
);

create table entretien (
    id_entretien serial primary key,
    changement varchar(50),
    date_entretien date
);

create table detail (
    id_detail serial primary key,
    nom_modele varchar(50),
    puissance float,
    carburant varchar(50),
    nom_moteur varchar(50),
    id_etat int references etat(id_etat),
    id_entretien int references entretien(id_entretien),
    prix decimal,
    commission float,
    kilometrage int,
    boite_vitesse varchar(50),
    date_sortie date,
    commentaire varchar(100)
);

create table photo (
    id_photo serial primary key,
    lien_photo varchar(100)
);

create table voiture (
    id_voiture serial primary key,
    id_categorie int references categorie(id_categorie),
    id_marque int references marque(id_marque),
    id_detail int references detail(id_detail),
    id_photo int references photo(id_photo),
    disponibilite int
);

create table annonce (
    id_annonce serial primary key,
    id_utilisateur int references utilisateur(id_utilisateur),
    id_voiture int references voiture(id_voiture),
    date_annonce timestamp,
    accepte_annonce int
);

create table interaction (
    id_interaction serial primary key,
    id_annonce int references annonce(id_annonce),
    id_utilisateur int references utilisateur(id_utilisateur),
    favoris int
);
create table ville
(
    id_ville serial primary key,
    nom varchar(50)
);
insert into ville(nom) values('Antananarivo');
insert into ville(nom) values('Majunga');
insert into ville(nom) values('Fianarantsoa');
insert into ville(nom) values('Tamatave');

INSERT INTO marque(nom_marque) VALUES('BMW');
INSERT INTO marque(nom_marque) VALUES('Toyota');
INSERT INTO marque(nom_marque) VALUES('Audi');
INSERT INTO marque(nom_marque) VALUES('Mercedes');
INSERT INTO marque(nom_marque) VALUES('Mazda');
INSERT INTO marque(nom_marque) VALUES('Ford');
INSERT INTO marque(nom_marque) VALUES('Kia');
INSERT INTO marque(nom_marque) VALUES('Jeep');

-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE1','X6',2006);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE1','X1',2004);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE1','X2',2003);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE1','X3',2002);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE1','M1',2012);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE2','Yaris',2020);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE2','Hilux',2019);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE2','LC300',2023);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE3','Q5',2000);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE3','RS7',2003);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE3','M1',2021);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE4','MayBach',2004);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE4','Sprinter',1999);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE4','Actros',2000);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE5','BT50',2004);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE5','Cx3',2001);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE5','Cx5',2003);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE5','RX5',2001);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE6','Ranger',2010);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE6','GT50',2002);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE6','Mustang',2008);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE7','Pride Phase3',2004);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE7','Sorento',2009);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE7','Bongo',2010);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE8','Wrangler',2001);
-- INSERT INTO model(id_marque,nom,annee) VALUES('MARQUE8','Grand Cherokee',2009);

-- {
--     "nom_utilisateur": "Landria",
--     "prenom_utilisateur": "Liantsoa",
--     "ville": "Antananarivo",
--     "contact": "+261 34 00 001 01",
--     "mail": "liantsa@gmail.com",
--     "mdp": "liantsoa"
-- }