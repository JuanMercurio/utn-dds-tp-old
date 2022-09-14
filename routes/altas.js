var express = require('express');
var router = express.Router();

router.get('/transporte', function(req, res, next) {
  res.render('index', { title: 'Alta de Transporte', index: "altaTransporte", cssDependencies: "dependencies/altaTransporte/cssDependencies", jsDependencies: "dependencies/altaTransporte/jsDependencies"});
});

router.get('/trayecto', function(req, res, next) {
  res.render('index', { title: 'Alta de Trayecto', index: "altaTrayecto", cssDependencies: "dependencies/altaTrayecto/cssDependencies", jsDependencies: "dependencies/altaTrayecto/jsDependencies"});
});

router.get('/miembro', function(req, res, next) {
  res.render('index', { title: 'Alta de Miembro', index: "AltaMiembros", cssDependencies: "dependencies/AltaMiembros/cssDependencies", jsDependencies: "dependencies/AltaMiembros/jsDependencies"});
});

router.get('/organizacion', function(req, res, next) {
  res.render('index', { title: 'Alta de Organización', index: "AltaOrganizacion", cssDependencies: "dependencies/AltaOrganizacion/cssDependencies", jsDependencies: "dependencies/AltaOrganizacion/jsDependencies"});
});

module.exports = router;
