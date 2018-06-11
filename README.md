### Projet 6 : Site communautaire escalade.

Cette application est divisée en 5 sous-modules :

-   escalade-france-business
-   escalade-france-consumer
-   escalade-france-model
-   escalade-france-technical
-   escalade-france-webapp

L'application web escalade-france-webapp.war est packagée avec Apache Maven 3.5.3.

Cette application est à déployer sur un serveur Apache Tomcat 9 et utilise une base de données PostgreSQL 9.6. 

Les ressources JNDI relatives à la base de données PostgreSQL 9.6 sont dans le fichier escalade-france-webapp.war/META-INF/context.xml.

Un fichier backup de la base de données est disponible dans le répertoire backup-bdd/SiteCommunautaireEscalade.backup

Les scripts SQL de création de la base de données et d'insertion du jeu de données de démo sont disponibles dans le répertoire script-SQL.
Si vous souhaitez utiliser ces fichiers, voici comment procéder : 

-   Le serveur PostgreSQL est configuré avec les paramètres par défaut :
	- Host name/address : localhost
	- Port : 5432
	- Username : postgres
-   Créer une database sous PostgreSQL :
	- Nommer la database : SiteCommunautaireEscalade.
	- L'associer à l'Owner par défaut postgres. Le mot de passe pour se connecter à la base de données est  : admin
-   Importer les fichiers SQL dans l'ordre indiqué ci-dessous :
	- 01_Creation_DB_Site_communautaire_escalade_v1.sql : Ce fichier permet de mettre en place la structure de la base de données : tables, attributs, séquences, clés primaires, étrangères, index uniques.
	- 02_Insertion_donnees_DB_Site_communautaire_escalade_v1.sql : Ce fichier permet d'insérer les données relatives au jeu de données de démo pour tester l'application.

Vous êtes libres de paramétrer PostgreSQL de manière personnalisée. Mais dans ce cas-là, il faut bien répercuter votre paramétrage dans le fichier escalade-france-webapp.war/META-INF/context.xml.