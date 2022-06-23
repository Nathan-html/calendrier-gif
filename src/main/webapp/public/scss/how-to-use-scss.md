# Crée le style de l'application grace au SCSS

## Prérequis

Installer  sass

- via node
```cmd
npm install -g sass
```

## En production
```cmd
sass src/main/webapp/public/scss/main.scss src/main/webapp/public/style.css
```

## En développement

Ajouter le flag "--watch" en mode développement pour dire sass de générer un nouveau index.css à chaque changement apporter au dossier scss
```cmd
sass src/main/webapp/public/scss/main.scss src/main/webapp/public/style.css --watch
```