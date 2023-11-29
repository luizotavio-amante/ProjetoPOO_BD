DROP DATABASE IF EXISTS `Projeto_POO_BD`;
CREATE DATABASE `Projeto_POO_BD`;
USE `Projeto_POO_BD` ;

-- -----------------------------------------------------
-- Table `Projeto_POO_BD`.`Org`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto_POO_BD`.`Org` (
  `idOrg` INT AUTO_INCREMENT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `membros_time` INT NOT NULL,
  PRIMARY KEY (`idOrg`));

-- -----------------------------------------------------
-- Table `Projeto_POO_BD`.` Status_jog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto_POO_BD`.`status_jog` (
  `idstatus_jog` INT AUTO_INCREMENT NOT NULL,
  `kills` INT NOT NULL,
  `deaths` INT NOT NULL,
  `horas_p_dia` VARCHAR(5) NULL,
  PRIMARY KEY (`idstatus_jog`));

-- -----------------------------------------------------
-- Table `Projeto_POO_BD`.`Jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto_POO_BD`.`Jogador` (
  `idJogador` INT AUTO_INCREMENT NOT NULL,
  `nick_apelido` VARCHAR(45) NOT NULL,
  `funcao` VARCHAR(25) NOT NULL,
  `Org_idOrg` INT NOT NULL,
  `status_jog_idstatus_jog` INT NOT NULL,
  PRIMARY KEY (`idJogador`),
  INDEX `fk_Jogador_Org_idx` (`Org_idOrg` ASC) VISIBLE,
  INDEX `fk_Jogador_status_jog1_idx` (`status_jog_idstatus_jog` ASC) VISIBLE,
  CONSTRAINT `fk_Jogador_Org`
    FOREIGN KEY (`Org_idOrg`)
    REFERENCES `Projeto_POO_BD`.`Org` (`idOrg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogador_status_jog1`
    FOREIGN KEY (`status_jog_idstatus_jog`)
    REFERENCES `Projeto_POO_BD`.`status_jog` (`idstatus_jog`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `Projeto_POO_BD`.`Campeonato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto_POO_BD`.`Campeonato` (
  `idCampeonato` INT AUTO_INCREMENT NOT NULL,
  `premiacao` DOUBLE NOT NULL,
  `times_inscritos` INT NULL,
  `data` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idCampeonato`));

-- -----------------------------------------------------
-- Table `Projeto_POO_BD`.`Org_has_Campeonato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto_POO_BD`.`Org_has_Campeonato` (
  `Org_idOrg` INT AUTO_INCREMENT NOT NULL,
  `Campeonato_idCampeonato` INT NOT NULL,
  PRIMARY KEY (`Org_idOrg`, `Campeonato_idCampeonato`),
  INDEX `fk_Org_has_Campeonato_Campeonato1_idx` (`Campeonato_idCampeonato` ASC) VISIBLE,
  INDEX `fk_Org_has_Campeonato_Org1_idx` (`Org_idOrg` ASC) VISIBLE,
  CONSTRAINT `fk_Org_has_Campeonato_Org1`
    FOREIGN KEY (`Org_idOrg`)
    REFERENCES `Projeto_POO_BD`.`Org` (`idOrg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Org_has_Campeonato_Campeonato1`
    FOREIGN KEY (`Campeonato_idCampeonato`)
    REFERENCES `Projeto_POO_BD`.`Campeonato` (`idCampeonato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    select * from org;
    select * from jogador;
    select * from status_jog;
    select * from campeonato;
