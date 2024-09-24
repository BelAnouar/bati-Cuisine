# 🛠️ Bati-Cuisine

**Bati-Cuisine** est une application Java conçue spécialement pour les professionnels de la construction et de la rénovation de cuisines. Elle vous permet d'estimer rapidement et précisément les coûts de projets, en prenant en compte les matériaux et la main-d'œuvre. Simplifiez la gestion de vos devis et clients avec cet outil puissant et intuitif !

---

![Java](https://img.shields.io/badge/Java-8%2B-blue) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue) ![Git](https://img.shields.io/badge/Git-Version--Control-yellowgreen)

## 🚀 Fonctionnalités principales
- **Estimation des coûts** : Calculez automatiquement le coût total en fonction des matériaux et de la main-d'œuvre.
- **Gestion des clients** : Gérez efficacement vos clients et suivez vos projets.
- **Création de devis** : Génération facile de devis personnalisés pour vos clients.
- **Base de données intégrée** : Stockez toutes les informations sur une base PostgreSQL robuste.
  
---

## 🎯 Objectif
L'objectif principal de **Bati-Cuisine** est d'aider les professionnels à estimer les coûts de rénovation de cuisines de manière précise, tout en facilitant la gestion quotidienne des clients et des devis. Fini les calculs approximatifs et les pertes de temps, Bati-Cuisine s'occupe de tout !

---

## 🛠️ Technologies utilisées
- **Java** (version 8 ou supérieure)
- **PostgreSQL** (gestion des bases de données)
- **JDBC** (pour la communication avec la base de données)
- **Git** (contrôle de version)
- **JIRA** (gestion des tâches)

---

## 🗂️ Structure du projet

- `models/` : Définit les entités comme les projets, clients, matériaux, main-d'œuvre et devis.
- `config/` : Gère la configuration (base de données, etc.).
- `services/` : Contient la logique métier de gestion des projets et devis.
- `repository/` : Accès aux données via la base de données PostgreSQL.
- `view/` : Interface utilisateur, avec support CLI (interface graphique à venir).
- `utils/` : Classes utilitaires pour les validations et la gestion des dates.

---

## 🏗️ Architecture

L'application suit une architecture en couches, permettant une séparation claire des responsabilités :
- **Vue (view)** : Gère l'interaction avec l'utilisateur.
- **Service (services)** : Logique métier et calculs.
- **Persistance (repository)** : Communication avec la base de données.
- **Utilitaires (utils)** : Fonctions annexes (validation, dates).
- **Configuration (config)** : Configuration globale de l'application.

---

## 📥 Installation

### Prérequis
- **Java 8** ou supérieur
- **PostgreSQL**

### Étapes d'installation
1. Clonez le dépôt Git :
   ```bash
   git clone https://github.com/JavaAura/Anouar_Belhassan_S1_B3_BatiCuisine.git
### Execute jar file
1. jar file :
   ```bash
   java -jar ./target/baticuisine-1.0-SNAPSHOT-jar-with-dependencies.jar

### Conception UML
![DiagrammeClass](https://github.com/user-attachments/assets/824b8cbb-04d8-4f9d-bb7b-d259719c80dc)

### Planification JIRA
https://cinemy.atlassian.net/jira/software/projects/BAT/boards/7?sprintStarted=true&atlOrigin=eyJpIjoiZjVlNDA4N2VhNDlkNGQxYWE3ZTkyZmE4NTU3MzhhZmEiLCJwIjoiaiJ9

### Presentation canva
https://www.canva.com/design/DAGRtGEzW90/OFnsDw9AeN56CzmeAwqIjA/edit?utm_content=DAGRtGEzW90&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton
