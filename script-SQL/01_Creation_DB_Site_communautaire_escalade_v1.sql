
CREATE SEQUENCE public.pays_id_seq;

CREATE TABLE public.pays (
                id INTEGER NOT NULL DEFAULT nextval('public.pays_id_seq'),
                nom_pays VARCHAR(20) NOT NULL,
                CONSTRAINT pays_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.pays_id_seq OWNED BY public.pays.id;

CREATE SEQUENCE public.region_id_seq;

CREATE TABLE public.region (
                id INTEGER NOT NULL DEFAULT nextval('public.region_id_seq'),
                nom_region VARCHAR(100) NOT NULL,
                pays_id INTEGER NOT NULL,
                CONSTRAINT region_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.region_id_seq OWNED BY public.region.id;

CREATE SEQUENCE public.departement_id_seq;

CREATE TABLE public.departement (
                id INTEGER NOT NULL DEFAULT nextval('public.departement_id_seq'),
                nom_departement VARCHAR(100) NOT NULL,
                region_id INTEGER NOT NULL,
                CONSTRAINT departement_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.departement_id_seq OWNED BY public.departement.id;

CREATE SEQUENCE public.utilisateur_id_seq;

CREATE TABLE public.utilisateur (
                id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_seq'),
                civilite VARCHAR(8) NOT NULL,
                nom VARCHAR(100) NOT NULL,
                prenom VARCHAR(100) NOT NULL,
                pseudo VARCHAR(100) NOT NULL,
                adresse_mail VARCHAR(100) NOT NULL,
                salt VARCHAR(30) NOT NULL,
                mot_de_passe_securise VARCHAR(44) NOT NULL,
                telephone CHAR(14),
                date_naissance DATE,
                adresse VARCHAR(100),
                code_postal VARCHAR(10),
                ville VARCHAR(100),
                pays VARCHAR(20),
                administrateur BOOLEAN NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;

CREATE UNIQUE INDEX utilisateur_idx
 ON public.utilisateur
 ( pseudo );

CREATE UNIQUE INDEX utilisateur_idx1
 ON public.utilisateur
 ( adresse_mail );

CREATE UNIQUE INDEX utilisateur_idx2
 ON public.utilisateur 
 ( salt );

CREATE UNIQUE INDEX utilisateur_idx3
 ON public.utilisateur
 ( mot_de_passe_securise );

CREATE UNIQUE INDEX photo_idx
 ON public.photo
 (nom_photo);

CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.site (
                id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
                nom_site VARCHAR(100) NOT NULL,
                descriptif VARCHAR,
                commentaire_personnel VARCHAR,
                topo_disponible BOOLEAN NOT NULL,
                pays_id INTEGER NOT NULL,
                region_id INTEGER NOT NULL,
                departement_id INTEGER NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                date_ajout_site TIMESTAMP NOT NULL,
                date_maj_site TIMESTAMP NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id;

CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                nom_secteur VARCHAR(100) NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE SEQUENCE public.photo_id_seq;

CREATE TABLE public.photo (
                id INTEGER NOT NULL DEFAULT nextval('public.photo_id_seq'),
                nom_photo VARCHAR(100) NOT NULL,
                utilisateur_id INTEGER,
                site_id INTEGER,
                secteur_id INTEGER,
                CONSTRAINT photo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.photo_id_seq OWNED BY public.photo.id;

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                nom_voie VARCHAR(100) NOT NULL,
                cotation VARCHAR(100),
                hauteur VARCHAR(100),
                nb_points VARCHAR(100),
                duree VARCHAR(100),
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;

CREATE SEQUENCE public.commentaire_id_seq;

CREATE TABLE public.commentaire (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_id_seq'),
                commentaire VARCHAR NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                site_id INTEGER NOT NULL,
                date_commentaire TIMESTAMP NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;

CREATE SEQUENCE public.formulaire_contact_id_seq;

CREATE TABLE public.formulaire_contact (
                id INTEGER NOT NULL DEFAULT nextval('public.formulaire_contact_id_seq'),
                nom_na VARCHAR(100),
                adresse_mail_na VARCHAR(100),
                objet VARCHAR(100) NOT NULL,
                message VARCHAR NOT NULL,
                utilisateur_id INTEGER,
                date_form_contact TIMESTAMP NOT NULL,
                CONSTRAINT formulaire_contact_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.formulaire_contact_id_seq OWNED BY public.formulaire_contact.id;

CREATE SEQUENCE public.reservation_topo_id_seq;

CREATE TABLE public.reservation_topo (
                id INTEGER NOT NULL DEFAULT nextval('public.reservation_topo_id_seq'),
                date_de_debut DATE NOT NULL,
                heure_de_debut CHAR(5) NOT NULL,
                date_de_fin DATE NOT NULL,
                heure_de_fin CHAR(5)NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                site_id INTEGER NOT NULL,
                date_reservation TIMESTAMP NOT NULL,
                CONSTRAINT reservation_topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.reservation_topo_id_seq OWNED BY public.reservation_topo.id;

ALTER TABLE public.site ADD CONSTRAINT pays_site_fk
FOREIGN KEY (pays_id)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.region ADD CONSTRAINT pays_region_fk
FOREIGN KEY (pays_id)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT region_site_fk
FOREIGN KEY (region_id)
REFERENCES public.region (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.departement ADD CONSTRAINT region_departement_fk
FOREIGN KEY (region_id)
REFERENCES public.region (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT departement_site_fk
FOREIGN KEY (departement_id)
REFERENCES public.departement (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.formulaire_contact ADD CONSTRAINT utilisateur_formulaire_contact_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT utilisateur_site_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT utilisateur_photo_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT site_commentaire_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT site_photo_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT secteur_photo_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation_topo ADD CONSTRAINT utilisateur_reservation_topo_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation_topo ADD CONSTRAINT site_reservation_topo_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
