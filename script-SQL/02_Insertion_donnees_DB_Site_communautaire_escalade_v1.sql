-- *********************************************************************
-- pays
-- *********************************************************************
INSERT INTO public.pays (nom_pays) VALUES ('France'),('Suisse');

-- *********************************************************************
-- region
-- *********************************************************************
INSERT INTO public.region (nom_region,pays_id) VALUES ('Auvergne-Rhône-Alpes',1),('Bourgogne-Franche-Comté',1),('Bretagne',1),('Centre-Val de Loire',1),('Corse',1),('Grand Est',1),
								 					  ('Hauts-de-France',1),('Île-de-France',1),('Normandie',1),('Nouvelle-Aquitaine',1),('Occitanie',1),('Pays de la Loire',1),
								 					  ('Provence-Alpes-Côte d''Azur',1),('Guadeloupe',1),('Guyane (française)',1),('Martinique',1),('La Réunion',1),('Mayotte',1),
								 					  ('Région lémanique',2),('Espace Mittelland',2),('Suisse du Nord-Ouest',2),('Zurich',2),('Suisse orientale',2),('Suisse centrale',2),('Tessin',2);


-- *********************************************************************
-- departement
-- *********************************************************************
INSERT INTO public.departement (nom_departement,region_id) VALUES ('Ain',1),('Allier',1),('Ardèche',1),('Cantal',1),('Drôme',1),('Isère',1),('Loire',1),('Haute-Loire',1),
																  ('Puy-de-Dôme',1),('Rhône',1),('Métropole de Lyon',1),('Savoie',1),('Haute-Savoie',1),
																  ('Côte-d''Or',2),('Doubs',2),('Jura',2),('Nièvre',2),('Haute-Saône',2),
																  ('Saône-et-Loire',2),('Yonne',2),('Territoire de Belfort',2),
																  ('Côtes-d''Armor',3),('Finistère',3),('Ille-et-Vilaine',3),('Morbihan',3),
																  ('Cher',4),('Eure-et-Loir',4),('Indre',4),('Indre-et-Loire',4),('Loir-et-Cher',4),('Loiret',4),
																  ('Corse-du-Sud',5),('Haute-Corse',5),
																  ('Ardennes',6),('Aube',6),('Marne',6),('Haute-Marne',6),('Meurthe-et-Moselle',6),('Meuse',6),('Moselle',6),
																  ('Bas-Rhin',6),('Haut-Rhin',6),('Vosges',6),
																  ('Aisne',7),('Nord',7),('Oise',7),('Pas-de-Calais',7),('Somme',7),
																  ('Paris',8),('Seine-et-Marne',8),('Yvelines',8),('Essonne',8),('Hauts-de-Seine',8),('Seine-Saint-Denis',8),
																  ('Val-de-Marne',8),('Val-d''Oise',8),
																  ('Calvados',9),('Eure',9),('Manche',9),('Orne',9),('Seine-Maritime',9),
																  ('Charente',10),('Charente-Maritime',10),('Corrèze',10),('Creuse',10),('Dordogne',10),('Gironde',10),
																  ('Landes',10),('Lot-et-Garonne',10),('Pyrénées-Atlantiques',10),('Deux-Sèvres',10),('Vienne',10),('Haute-Vienne',10),
																  ('Ariège',11),('Aude',11),('Aveyron',11),('Gard',11),('Haute-Garonne',11),('Gers',11),('Hérault',11),
																  ('Lot',11),('Lozère',11),('Hautes-Pyrénées',11),('Pyrénées-Orientales',11),('Tarn',11),('Tarn-et-Garonne',11),
																  ('Loire-Atlantique',12),('Maine-et-Loire',12),('Mayenne',12),('Sarthe',12),('Vendée',12),
																  ('Alpes-de-Haute-Provence',13),('Hautes-Alpes',13),('Alpes-Maritimes',13),('Bouches-du-Rhône',13),
																  ('Var',13),('Vaucluse',13),
																  ('Guadeloupe',14),('Guyane (française)',15),('Martinique',16),('La Réunion',17),('Mayotte',18),
																  ('Genève',19),('Valais',19),('Vaud',19),
																  ('Berne',20),('Fribourg',20),('Jura',20),('Neuchâtel',20),('Soleure',20),
																  ('Argovie',21),('Bâle-Campagne',21),('Bâle-Ville',21),
																  ('Zurich',22),
																  ('Appenzell Rhodes-Extérieures',23),('Appenzell Rhodes-Intérieures',23),('Glaris',23),('Grisons',23),('Saint-Gall',23),('Schaffhouse',23),('Thurgovie',23),
																  ('Lucerne',24),('Nidwald',24),('Obwald',24),('Schwytz',24),('Uri',24),('Zoug',24),
																  ('Tessin',25);

-- *********************************************************************
-- utilisateur
-- *********************************************************************
INSERT INTO public.utilisateur(civilite,nom,prenom,pseudo,adresse_mail,salt,mot_de_passe_securise,telephone,date_naissance,adresse,code_postal,ville,pays,administrateur)
VALUES 
-- Mot de passe non sécurisé :M0tp@SAdM83!!
('Monsieur', 'Monnier','André','André M.','andre.monnier@hotmail.fr','duWHFkUYaDVcIY2F52OFhYM08rSp2U','ukdUT1hmMrcHbEC2lFb5/3CoeH1hSJyhWlslAs6k0GU=','07-74-13-52-09','1983-09-03','667 Chemin de sur la ville','74340','Samoëns','France',true),
-- Mot de passe non sécurisé :M@rt1R@778?
('Monsieur', 'Durand','Martin','Martin D','martin.durand@gmail.com','nwhMGwRv5k1HTLIGjmrdyQsoBSYmcb','96MJCGUsI6yzRM53HIugWIF/s1E5ykiQ+GIe1BXi8XM=','06-31-47-36-82','1982-10-03','1 AVENUE BERTHOLLET','74000','ANNECY','France',false),
-- Mot de passe non sécurisé :GEsc@L@Dais?
('Monsieur', 'Gallet','Romuald','Romu G.','romuald.gallet@yahoo.fr','lLGSalPUNp8LaK5YezAzvGiuqvH5Va','QYWhASzYFe0L1TYrKNMovzj9hQ5fLfEaYlqkjP5iKFc=',NULL,NULL,NULL,NULL,NULL,NULL,false);															  

-- *********************************************************************
-- site
-- *********************************************************************
INSERT INTO public.site (nom_site,descriptif,commentaire_personnel,topo_disponible,pays_id,region_id,departement_id,utilisateur_id,date_ajout_site,date_maj_site)
VALUES 
		-- Site Les Monts
	   ('Les Monts','Ce site offre une vue dominante sur la ville de Chambéry et sur le massif de la Chartreuse','Très beau site qui comporte 2 secteurs avec de nombreuses voies !',
		true,1,1,12,1,'2018-05-06 10:00:00','2018-05-06 10:00:00'),
	   
	   -- Site SuperU
	   ('SuperU','Située sur la commune de Montmélian cette superbe barre rocheuse est idéale pour les amoureux de tranquillité et de nouveautés.','L''orientation Sud-Est vous permettra,
	   	pendant le printemps, de profiter pleinement du lieu et du panorama. Vous viendrez avant tout à SuperU pour goûter aux plaisirs d''un accès typé montagne comme pour ses voies de 
	   	continuités. Vous trouverez aussi des itinéraires à sections blocs et d''autres plus résistants.',true,1,1,12,1,'2018-05-07 10:00:00','2018-05-07 10:00:00'),

	   -- Site Bassin Long
	   ('Bassin Long','Site situé dans un cadre agréable et facile d''accès. Ce site comporte 5 secteurs.','La vallée est le lieu habituel de pâturage des chèvres.
	   	Il est conseillé de ne pas rester sous les falaises lors du passage des troupeaux. Chute de pierres possible. A bassin Long on peut piquer une tête.
	   	N’oubliez pas d’emporter avec vous les déchets en partant.',true,1,17,101,2,'2018-05-08 14:35:00','2018-05-08 14:35:00'),

	   --Site Les Aiguilles de Baulmes / Sous la croix
	   ('Site Les Aiguilles de Baulmes / Sous la croix','Le site "Les aiguilles de Baulmes" est composé de 4 secteurs. Il est situé à plus de 1500m, généralement au dessus du brouillard, 
	   	et orienté au sud ce qui le rend particulièrement agréable en automne et hiver. Le secteur Sous la croix, est une falaise orienté sud-est avec une belle vue sur la plaine. 
	   	Il est constitué de plusieurs couennes destinées aux grimpeurs avancés.','Il est conseillé d''emporter quelques friends et coinceurs pour certaines voies.',false,2,19,105,2,'2018-05-10 14:35:00','2018-05-10 14:35:00');


-- *********************************************************************
-- secteur
-- *********************************************************************
INSERT INTO public.secteur(nom_secteur,site_id) VALUES ('Combe nord',1),('Grand face',1),
													   ('Secteur de gauche',2),('Les dévers',2),('Proue',2),
													   ('Secteur Millefeuilles',3),('Secteur Morinda',3),('Secteur Lock Ness',3),('Secteur Bella vista',3),('Secteur Dôme',3),
													   ('Aiguilles de Baulmes face Sud 1',4),('Aiguilles de Baulmes face Sud 2',4),('Aiguilles de Baulmes face Sud 3',4),('Sous la croix',4);

-- *********************************************************************
-- voie
-- *********************************************************************
INSERT INTO public.voie(nom_voie,cotation,hauteur,nb_points,duree,secteur_id)
VALUES 
		-- Voies associées aux secteurs du site Les Monts
	   ('Naze goal','5a','12m','5 points','10 minutes',1),('Gobe ligne','6b+','12m','7 points','10 minutes',1),('Le Hobit','7a','12m','5 points','10 minutes',1),
	   ('Freudon','7b','12m','6 points','10 minutes',1),('Mordur ou je fais un malheur','7b','12m','5 points','10 minutes',1),('Easyledur Sordide','7b+','12m','6 points','10 minutes',1),
	   ('Dragon fire','6c+','12m','5 points','10 minutes',1),('Anneau maléfique','7c','12m','5 points','10 minutes',1),
	   ('Hello le nain','7c','35m','15 points','15 minutes',2),('Un trolls pour monter','7b+','35m','15 points','15 minutes',2),('Zone elfique','7a','35m','15 points','15 minutes',2),
	   ('Le gnome','7b+','35m','20 points','15 minutes',2),('Biceps d’ork','7b','35m','15 points','15 minutes',2),('Tais toi quand tu voles','7c+','35m','20 points','15 minutes',2),
	   ('Loup gars ou es tu','7b+','35m','20 points','15 minutes',2),('Roi des cavernes','6c','35m','15 points','15 minutes',2),('Roi des cavernes','7b','35m','20 points','15 minutes',2),
	   ('Le seigneur des abdos','7b+','35m','20 points','15 minutes',2),('Des abdos pour faire le beau','7c','35m','15 points','15 minutes',2),
	   ('Triceptératos','7c+','35m','20 points','15 minutes',2),('Biceps du soir','7c','35m','20 points','15 minutes',2),('Gueule d’orque','7c','35m','20 points','15 minutes',2),
	   ('Blouse de là','7b+','35m','20 points','15 minutes',2),

	   -- Voies associées aux secteurs du site SuperU
	   ('Croutenard','7c','12 mètres','5 points','10 minutes',3),('Frotteur','7a','12 mètres','5 points','10 minutes',3),('Les tatours','6b+','12 mètres','5 points','10 minutes',3),
	   ('Frigide cageot','7a+','12 mètres','5 points','10 minutes',3),('CAF''s touch','6c+','25 mètres','12 points','20 minutes',3),
	   ('Le berlot du perfo','7a','12 mètres','5 points','10 minutes',3),('Panne sèche','7a','25 mètres','14 points','20 minutes',3),
	   ('UBS m''a trahi','7b+','18 mètres','14 points','20 minutes',3),('Dodo la saumure','7c','18 mètres','14 points','20 minutes',3),
	   ('Gégé en Suisse','6c','20 mètres','16 points','20 minutes',3),('Le sport du moineau','7a','17 mètres','13 points','15 minutes',3),
	   ('L’étoile du matin','7a+','30 mètres','20 points','25 minutes',4),('L''enfoncement du clou','7b+','30 mètres','15 points','25 minutes',4),
	   ('Le coup du taureau','8a','30 mètres','20 points','25 minutes',4),('Paire de pincettes','7b','30 mètres','15 points','25 minutes',4),
	   ('La grimpeuse à l''arbre','7c','30 mètres','20 points','25 minutes',4),('Vendredi serein','8a','30 mètres','17 points','20 minutes',4),
	   ('Porcelaine','8a+','30 mètres','20 points','25 minutes',4),('Le bond du tigre','8a','30 mètres','18 points','20 minutes',4),
	   ('Shere kan','8a+','30 mètres','20 points','25 minutes',4),('Révélation','7c+','30 mètres','17 points','20 minutes',4),
	   ('Renaissance','7c+','30 mètres','20 points','25 minutes',4),('Rédemption','8a','30 mètres','20 points','25 minutes',4),
	   ('Le Bikaboué L1','7a','30 mètres','20 points','25 minutes',4),('Le Bikaboué','8a','30 mètres','20 points','20 minutes',4),
	   ('Le vieux chauve L1','7a','30 mètres','20 points','25 minutes',4),('Le vieux chauve','8b?','30 mètres','20 points','20 minutes',4),
	   ('L''An L1','7b','30 mètres','20 points','25 minutes',4),('L''An','8a','30 mètres','20 points','25 minutes',4),
	   ('Noël au balcon L1','7a','30 mètres','20 points','25 minutes',4),('Noël au balcon','8a','30 mètres','20 points','25 minutes',4),
	   ('Prasinus','7b','25 mètres','12 points','20 minutes',5),('Les 4 sans coups ','7c','25 mètres','12 points','20 minutes',5),

	   -- Voies associées aux secteurs du site Bassin Long
	   ('A: La réglette du bonheur','7b','8m','3 points','10 minutes',6),
	   ('A: Gelato al limone','7a','5m','2 points','10 minutes',7),('B: Troullalla','6c','5m','2 points','10 minutes',7),
	   ('A: Le funambule','6a+','8m','4 points','10 minutes',8),('B: La dallette des rois','6b','8m','5 points','10 minutes',8),
	   ('C: Doigts de pieds en éventail','5a','8m','5 points','10 minutes',8),('D: Juste un pas','5c','8m','5 points','10 minutes',8),
	   ('E: Physique d’Apollon','5b','8m','4 points','10 minutes',8),
	   ('A: Le chemin du bonobo','5c','20m','8 points','20 minutes',9), ('B: La dalle en prise aux niais','6b+','15m','6 points','15 minutes',9),
	   ('C: Pilier de comptoir','6c','15m','6 points','15 minutes',9), ('D: Beaucoup de Doigtée','6b','12m','6 points','15 minutes',9),
	   ('E: Mammamia','7b?','20m','8 points','20 minutes',9),
	   ('A: Negrita','6a en passant par la fissure, 6b tout droit','12m','5 points','12 minutes',10),('B: Hypertrichose Palmaire','5c','10m','5 points','10 minutes',10),
	   ('C: Arrête pleur d’si','6b','15m','6 points','15 minutes',10),('D: Fat in the frok','6c','15m','6 points','15 minutes',10),
	   ('E: Ce lak se bon','6c','18m','9 points','20 minutes',10),('F: Roger Ladalle','6b+','10m','7 points','10 minutes',10),
	   ('G: Faillenfeu','6c','10m','6 points','10 minutes',10),('H: P''tit bonhomme','5c','10m','5 points','10 minutes',10),

	   -- Voies associées aux secteurs du site Les Aiguilles de Baulmes / Sous la croix
	   ('Jane-Marie','6c','20 mètres','10 points','30 minutes',11),('Déception','6c','20 mètres','10 points','30 minutes',11),('Crack','7a','20 mètres','10 points','30 minutes',11),
	   ('Collet','7a+','15 mètres','8 points','25 minutes',12),('Bruand','7b+','15 mètres','8 points','25 minutes',12),('Namaskar','6c','15 mètres','8 points','25 minutes',12),
	   ('Pilier','7a+','15 mètres','15 points','35 minutes',13),('Tashi delek','6b','15 mètres','15 points','35 minutes',13),('Namaste','6b','15 mètres','15 points','35 minutes',13),
	   ('Sous la croix Voie 1','7a+','15 mètres','15 points','20 minutes',14),('Sous la croix Voie 2','6b','15 mètres','12 points','35 minutes',14),('Sous la croix Voie 3','6b','15 mètres','11 points','35 minutes',14);
	  
-- *********************************************************************
-- commentaire
-- *********************************************************************
INSERT INTO public.commentaire(commentaire,utilisateur_id,site_id,date_commentaire) VALUES ('J''y suis déjà allé. Très beau site effectivement !!!',2,1,'2018-05-06 18:23:35'),
																		  				   ('Beaucoup de voies pratiquables, mais certaines sont très compliquées !',2,2,'2018-05-07 22:38:40'),
																		  				   ('Je vais profiter de mes vacances à la Réunion pour aller sur ce site.',1,3,'2018-05-12 14:05:00'),
																		  				   ('Effectivement, je te le conseille. C''est aussi ce que j''ai fait ;)',2,3,'2018-05-12 18:15:38'),
																		  				   ('C''est bien vrai!!!',1,2,'2018-05-12 18:15:39'),
																		  				   ('Je confirme que c''est bien le cas.',1,2,'2018-05-12 18:15:40'),
																		  				   ('Oui je suis d''accord, surtout pour le secteur les Dévers qui a des voies très compliquées.',3,2,'2018-05-18 16:50:33'),
																		  				   ('En ce qui me concerne, j''y vais assez régulièrement.',1,1,'2018-05-31 17:03:06');
																		  				   

-- *********************************************************************
-- formulaire_contact
-- *********************************************************************
INSERT INTO public.formulaire_contact(nom_na,adresse_mail_na,objet,message,utilisateur_id,date_form_contact)
VALUES (NULL,NULL,'Proposer une nouvelle catégorie','Pourriez-vous créer une catégorie réservée pour les blocs?',2,'2018-05-18 14:00:00'),
	   (NULL,NULL,'Proposer une amélioration','Pourriez-vous envisager une saisie semi-automatique dans la zone de recherche de sites?',3,'2018-05-19 15:30:02'),
	   ('Anderson','gillian.anderson@gmail.com','Proposer une amélioration','Serait-il possible d''intégrer des cartes de type Google Maps pour repérer un site?',NULL,'2018-05-20 08:33:33'),
	   ('Pasquier','sebastien.pasquier@gmail.com','Proposer une nouvelle catégorie','Pourriez-vous créer un espace réservé aux blocs?',NULL,'2018-05-20 09:33:33'),
	   ('FanEscalade','fanEscalade@gmail.com','Contacter l’administrateur','Bonjour, je souhaiterais vous proposer une amélioration. Êtes-vous d''accord pour en parler. Cdlt.',NULL,'2018-05-22 00:02:05'),
	   ('FanEscalade','fanEscalade@gmail.com','Contacter l’administrateur','Bonjour, je me permet de vous relancer, car je n''ai toujours pas eu de réponses de votre part.',NULL,'2018-05-25 12:00:05'),
	   (NULL,NULL,'Proposer une nouvelle catégorie','Êtes-vous d''accord pour ajouter une section bloc? Cdlt.',3,'2018-05-26 13:00:00');

-- *********************************************************************
-- photo
-- *********************************************************************
INSERT INTO public.photo(nom_photo,utilisateur_id,site_id,secteur_id)
VALUES ('jsp/assets/images/utilisateur_1.jpg',1,NULL,NULL),
	   ('jsp/assets/images/site_1.jpg',NULL,1,NULL),
	   -- Chaque photo de secteur sera renommée Secteur_XY où X désigne le secteur_id et Y la Yième photo d'un secteur
	   ('jsp/assets/images/secteur_11.jpg',NULL,NULL,1),
	   ('jsp/assets/images/secteur_21.jpg',NULL,NULL,2),
	   ('jsp/assets/images/secteur_22.jpg',NULL,NULL,2),
	   ('jsp/assets/images/site_2.jpg',NULL,2,NULL),
	   ('jsp/assets/images/secteur_31.jpg',NULL,NULL,3),
	   ('jsp/assets/images/secteur_41.jpg',NULL,NULL,4),
	   ('jsp/assets/images/secteur_42.jpg',NULL,NULL,4),
	   ('jsp/assets/images/secteur_51.jpg',NULL,NULL,5),
	   ('jsp/assets/images/utilisateur_2.jpg',2,NULL,NULL),
	   ('jsp/assets/images/site_3.jpg',NULL,3,NULL),
	   ('jsp/assets/images/secteur_61.jpg',NULL,NULL,6),
	   ('jsp/assets/images/secteur_71.jpg',NULL,NULL,7),
	   ('jsp/assets/images/secteur_81.jpg',NULL,NULL,8),
	   ('jsp/assets/images/secteur_91.jpg',NULL,NULL,9),
	   ('jsp/assets/images/secteur_101.jpg',NULL,NULL,10),
	   ('jsp/assets/images/secteur_102.jpg',NULL,NULL,10),
	   ('jsp/assets/images/utilisateur_3.jpg',3,NULL,NULL),
	   ('jsp/assets/images/site_4.jpg',NULL,4,NULL),
	   ('jsp/assets/images/secteur_111.jpg',NULL,NULL,11),
	   ('jsp/assets/images/secteur_112.jpg',NULL,NULL,11),
	   ('jsp/assets/images/secteur_113.jpg',NULL,NULL,11),
	   ('jsp/assets/images/secteur_121.jpg',NULL,NULL,12),
	   ('jsp/assets/images/secteur_122.jpg',NULL,NULL,12),
	   ('jsp/assets/images/secteur_123.jpg',NULL,NULL,12),
       ('jsp/assets/images/secteur_131.jpg',NULL,NULL,13),
	   ('jsp/assets/images/secteur_132.jpg',NULL,NULL,13),
	   ('jsp/assets/images/secteur_141.jpg',NULL,NULL,14),
	   ('jsp/assets/images/secteur_142.jpg',NULL,NULL,14),
	   ('jsp/assets/images/secteur_143.jpg',NULL,NULL,14);

-- *********************************************************************
-- reservation_topo
-- *********************************************************************
INSERT INTO public.reservation_topo(date_de_debut,heure_de_debut,date_de_fin,heure_de_fin,utilisateur_id,site_id,date_reservation)
VALUES ('2018-06-20','10:00','2018-06-20','14:00',2,1,'2018-06-12 08:02:03'),
	   ('2018-06-22','08:00','2018-06-22','18:00',3,1,'2018-06-15 18:05:07'),
	   ('2018-06-25','08:00','2018-06-25','13:00',2,2,'2018-06-18 19:05:30'),
	   ('2018-06-25','13:00','2018-06-25','16:00',3,2,'2018-06-18 19:05:30'),
	   ('2018-06-25','14:00','2018-06-25','16:00',1,3,'2018-06-20 20:05:07'),
	   ('2018-07-02','08:00','2018-07-02','12:00',1,3,'2018-06-26 18:05:07'),
	   ('2018-07-02','13:00','2018-07-02','17:00',3,3,'2018-06-20 07:15:17'),
	   ('2018-05-29','08:00','2018-05-29','09:00',3,3,'2018-05-24 19:06:07'),
	   ('2018-07-02','12:00','2018-07-02','13:00',3,3,'2018-05-29 19:09:23'),
	   ('2018-07-03','13:00','2018-07-03','17:00',3,3,'2018-05-29 19:10:27'),
	   ('2018-06-25','16:00','2018-06-25','18:00',1,3,'2018-05-29 19:20:56'),
	   ('2018-07-03','12:00','2018-07-03','13:00',1,3,'2018-05-30 09:27:17'),
	   ('2018-06-25','16:00','2018-06-25','17:00',2,2,'2018-05-30 09:54:40'),
	   ('2018-06-23','10:00','2018-06-23','12:00',3,1,'2018-05-30 14:26:18'),
	   ('2018-06-30','08:00','2018-06-30','12:00',3,1,'2018-05-30 14:27:38');