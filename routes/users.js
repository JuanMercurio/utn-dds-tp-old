var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/solicitudes', function(req, res, next) {
  res.render('index', { title: 'Solicitudes de Miembros', index: "SolicitudMiembros", cssDependencies: "dependencies/SolicitudMiembros/cssDependencies", jsDependencies: "dependencies/SolicitudMiembros/jsDependencies"});
});

module.exports = router;
