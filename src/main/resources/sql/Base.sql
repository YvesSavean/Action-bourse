
CREATE USER actionProfil
CREATE SCHEMA IF NOT EXISTS actions AUTHORIZATION actionProfil;

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
	ProduitNetBancaire VARCHAR(100),
	ChargesGeneralesExploitation VARCHAR(100),
	ResultatBrutExploitation VARCHAR(100),
	CoutDuRisque VARCHAR(100),
	ResultatExploitation VARCHAR(100),
	QuotePartResultatsDesSociétesMisesEnEquivalence VARCHAR(100),
	ResultatCourantAvantImpot VARCHAR(100),
	ResultatNet VARCHAR(100),
	ResultatNetPartDuGroupe VARCHAR(100),
	CaisseBanquesCentralesCcp VARCHAR(100),
	ActifsFinALaJusteValeurParResultat VARCHAR(100),
	InstrumentsDerivesDeCouverture VARCHAR(100),
	ActifsFinanciersDispoALaVente VARCHAR(100),
	ActifsFinDétenusALecheance VARCHAR(100),
	PretsEtAvancesSurLesEtsDeCrédit VARCHAR(100),
	TotalCreancesClientele VARCHAR(100),
	Immobilisations VARCHAR(100),
	AutresActifs VARCHAR(100),
	TotalActif VARCHAR(100),
	BanquesCentralesCCP VARCHAR(100),
	PassifsFinALaJusteValPaResultat VARCHAR(100),
	DettesEnversLesEtsDeCredit VARCHAR(100),
	DettesAupresDeLaClientele VARCHAR(100),
	DettesRepresenteesParUnTitre VARCHAR(100),
	DettesSubordonnees VARCHAR(100),
	ProvisionsTechniquesDesContratsAss VARCHAR(100),
	CapitauxPropres VARCHAR(100),
	AutresPassifs VARCHAR(100),
	TotalPassif VARCHAR(100),
	ResultatNetPartDuGroupeParAction VARCHAR(100),
	ResultatNetPartDuGroupeDilueParAction VARCHAR(100),
	CoefficientExploitation VARCHAR(100),
	RatioInternationalDeSolvabilité VARCHAR(100),
	RentabiliteDesFondsPropres VARCHAR(100),
	EffectifEnFinAnnee VARCHAR(100),
	EffectifMoyen VARCHAR(100),
	idSociete int not null
);

CREATE TABLE IF NOT EXISTS actions.societe (
	id int primary key not null,
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
	montant VARCHAR(100),
	Cours VARCHAR(100),
	rendement VARCHAR(100),
	idSociete int not null
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