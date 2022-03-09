create table patient (
    idPatient SERIAL PRIMARY KEY,
    nomPrenom varchar(255),
    genre varchar(50),
    adresse varchar(100),
    dateDeNaissance date
);

create table categorieDocteur (
    idCategorieDocteur SERIAL PRIMARY KEY,
    designation varchar(255),
    salaireJournalier double precision
);

create table docteur (
    idDocteur SERIAL PRIMARY KEY,
    nomPrenom varchar(255),
    idCategorieDocteur int,
    foreign key (idCategorieDocteur) references categorieDocteur(idCategorieDocteur)
);

/*create table categorieChambre (
    idCategorieChambre SERIAL PRIMARY KEY,
    designation varchar (100),
    nbLits int,
    tarif int
);*/

create table chambre (
    idChambre SERIAL PRIMARY KEY,
    designation varchar(100),
    nbLits int,
    tarif int
);

create table sejour (
    idSejour SERIAL PRIMARY KEY,
    idPatient int,
    idChambre int,
    dateEntree date,
    dateSortie date,
    paye boolean,
    foreign key (idPatient) references patient(idPatient),
    foreign key (idChambre) references chambre(idChambre)
);

create table prestation(
    idPrestation SERIAL PRIMARY KEY,
    idPatient int,
    idDocteur int,
    datePrestation date,
    foreign key (idPatient) references patient(idPatient),
    foreign key (idDocteur) references docteur(idDocteur)
);

create table facture (
    idFacture SERIAL PRIMARY KEY,
    idPatient int,
    montant int,
    dateFacture date,
    foreign key (idPatient) references patient(idPatient)
);

create table payement(
    idPayement SERIAL PRIMARY KEY,
    idSejour int,
    somme double precision,
    foreign key (idSejour) references sejour(idSejour)
);

insert into patient values (default,'Rakoto Abel','Homme','Antananarivo','1995-03-04');
insert into patient values (default,'Andria Jean de Dieu','Homme','Manakara','1999-12-25');
insert into patient values (default,'Pharlin Marie Egyptienne','Femme','Majunga','2001-08-11');

insert into categorieDocteur values (default, 'Infirmier', 20000 );
insert into categorieDocteur values (default, 'Médecin généraliste', 35000);
insert into categorieDocteur values (default, 'Médecin spécialiste', 50000 );
insert into categorieDocteur values (default, 'Professeur', 70000 );

insert into chambre values (default, 'Chambre 1', 5, 10000)
insert into chambre values (default, 'Chambre 2', 3, 20000)
insert into chambre values (default, 'Chambre 3', 1, 30000)

insert into sejour values (default, 1, 1, '2022-03-03',null, false);
insert into sejour values (default, 2, 2, '2022-03-02',null, false);
insert into sejour values (default, 3, 3, '2022-03-04',null, false);

insert into payement values (default,1,5000);


/*select * from sejour where idPatient = ?
select patient.*,sejour.* from sejour join patient on patient.idPatient = sejour.idPatient
select patient.* from sejour join patient on patient.idPatient = sejour.idPatient where idPatient = ?
select docteur.*, prestation.* from docteur join prestation on prestation.idDocteur = docteur.idDocteur where idDocteur = */

create view dureeSejour as select (CURRENT_DATE-dateEntree) as jours,idSejour,idChambre from sejour group by idSejour

create view getSommeTotal as select sum(dureeSejour.jours*chambre.tarif) as totalAPayer,sejour.idSejour from dureeSejour join sejour on sejour.idSejour = dureeSejour.idSejour join
chambre on dureeSejour.idChambre = chambre.idChambre group by dureeSejour.jours,chambre.tarif, sejour.idSejour;

create view resteAPayer as select sum(getSommeTotal.totalAPayer-payement.somme) as reste,getSommeTotal.idSejour from payement join getSommeTotal on payement.idSejour = getSommeTotal.idSejour
group by getSommeTotal.idSejour, getSommeTotal.totalAPayer, payement.idPayement;