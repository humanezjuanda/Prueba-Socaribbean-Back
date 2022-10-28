CREATE TABLE IF NOT EXISTS  `pacientes`  (
 `nmid` int NOT NULL AUTO_INCREMENT,
  `nomespecie` varchar(30) NOT NULL,
  `especie` varchar(150) NOT NULL,
  `raza` varchar(150) NOT NULL,
  `fechanaci` date DEFAULT NULL,
  `tipoid` varchar(30) NOT NULL,
  `iddue` int (100) DEFAULT NULL,
  `nomdue` varchar(30) NOT NULL,
  `ciudad` varchar(150) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono`  int (100) DEFAULT NULL,
   `fecharegis` date DEFAULT NULL,
  PRIMARY KEY (`nmid`)
);

