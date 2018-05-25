### Projet 6 : Site communautaire escalade.

Cette application est divisée en 5 sous-modules :

-   escalade-france-business
-   escalade-france-consumer
-   escalade-france-model
-   escalade-france-technical
-   escalade-france-webapp

Cette application est à déployer sur un serveur Apache Tomcat 9 et utilise une base de données PostgreSQL 9.6. 

L'application web escalade-france-webapp.war est packagée avec Apache Maven 3.5.3. 

Les ressources JNDI relatives à la base de données PostgreSQL 9.6 sont dans le fichier escalade-france-webapp.war/META-INF/context.xml. Un fichier backup de la base de données est disponible dans le répertoire escalade-france/backup-bdd. A noter que les scripts SQL de création de la base de données et d'insertion du jeu de données de démo sont disponibles dans le répertoire script-SQL.