
CREATE SCHEMA IF NOT EXISTS actions;

CREATE TABLE IF NOT EXISTS actions.data (
	id int primary key not null,
	dateData VARCHAR(100),
	Open VARCHAR(100),
	High VARCHAR(100),
	Low VARCHAR(100),
	Last VARCHAR(100),
	Volume VARCHAR(100),
	Turnover VARCHAR(100),
	idInformation int not null
);

CREATE TABLE IF NOT EXISTS actions.information (
	id int primary key not null,
	annee VARCHAR(100),
	croissanceFutureEnPourcentage VARCHAR(100),
	resultatNet VARCHAR(100),
	resultatNetParGroupe VARCHAR(100),
	chiffreAffaire VARCHAR(100),
	totalActif VARCHAR(100),
	totalPassif VARCHAR(100),
	capitauxPropre VARCHAR(100),
	idSociete VARCHAR(100) not null
);

CREATE TABLE IF NOT EXISTS actions.societe (
	id VARCHAR(100) primary key not null,
 	idElement VARCHAR(100),
	secteurActivite VARCHAR(100),
	codeIsin VARCHAR(100),
	symbSociete VARCHAR(100),
	indicePrincipal VARCHAR(100),
	bourseLabel VARCHAR(100),
	code VARCHAR(100),
	isin VARCHAR(100),
	nom VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS actions.rendement (
	id int primary key not null,
 	annee VARCHAR(100),
	montant NUMERIC,
	cours NUMERIC,
	rendement NUMERIC,
	idSociete VARCHAR(100) not null
);

create sequence actions.data_id;
ALTER TABLE actions.data alter id set default nextval('actions.data_id');
Select setval('actions.data_id', 1 );
create sequence actions.information_id;
ALTER TABLE actions.information alter id set default nextval('actions.information_id');
Select setval('actions.information_id', 1 );
create sequence actions.rendement_id;
ALTER TABLE actions.rendement alter id set default nextval('actions.rendement_id');
Select setval('actions.rendement_id', 1 );


ALTER TABLE actions.data ADD FOREIGN KEY(idInformation) REFERENCES actions.information(id);
ALTER TABLE actions.information ADD FOREIGN KEY(idSociete) REFERENCES actions.societe(id);
ALTER TABLE actions.rendement ADD FOREIGN KEY(idSociete) REFERENCES actions.societe(id);