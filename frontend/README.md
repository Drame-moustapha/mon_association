# Frontend

Ce dossier contient la structure de base pour l'application Angular.

Pour générer un projet Angular complet :
1. Installer Angular CLI: npm install -g @angular/cli
2. Depuis ce dossier frontend, lancer: ng new mon-association-frontend --routing --style=scss
3. Copier les fichiers de services et modèles fournis ici dans le projet généré, ou utiliser ces exemples comme référence.

Exemples de services à créer dans src/app/services:
- auth.service.ts : login/logout + stockage token
- activity.service.ts : récupération des activités depuis /api/activities

Le backend expose l'API sur http://localhost:8080/api

