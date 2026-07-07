# Backend README

Squelette Spring Boot pour le backend de l'application "mon_association".

Prérequis:
- Java 17
- Maven
- PostgreSQL (ou utiliser docker-compose)

Exécution locale:
1. Editer les variables de connexion dans backend/src/main/resources/application.yml ou exporter les variables d'environnement:
   SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD
2. Lancer PostgreSQL (docker-compose up db) ou utiliser une base existante.
3. Depuis le dossier backend: mvn spring-boot:run

Endpoints importants:
- POST /api/auth/create-user -> créer un utilisateur (endpoint prévu pour être protégé aux admins)
- POST /api/auth/login -> connexion (placeholder)
- GET /api/activities
- CRUD /api/committees

Prochaines tâches recommandées:
- Implémenter JWT pour l'authentification et protéger les endpoints admin
- Ajouter DTOs et validation des requêtes
- Ajouter tests unitaires et d'intégration
- Ajouter Flyway/Liquibase pour migrations

