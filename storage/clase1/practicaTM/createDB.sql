-- MySQL Script generated by MySQL Workbench
-- Wed Aug 18 13:00:00 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema emple_depto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema emple_depto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emple_depto` DEFAULT CHARACTER SET utf8 ;
USE `emple_depto` ;

-- -----------------------------------------------------
-- Table `emple_depto`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emple_depto`.`Departamento` ;

CREATE TABLE IF NOT EXISTS `emple_depto`.`Departamento` (
  `idDepto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepto`),
  UNIQUE INDEX `idDepartamento_UNIQUE` (`idDepto` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emple_depto`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emple_depto`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `emple_depto`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `nroLegajo` INT NOT NULL,
  `dni` INT NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fecNac` DATETIME NOT NULL,
  `fecInc` DATETIME NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `sueldoNeto` VARCHAR(45) NOT NULL,
  `idDepto` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE INDEX `idEmpleado_UNIQUE` (`idEmpleado` ASC) ,
  INDEX `idDepto_idx` (`idDepto` ASC) ,
  CONSTRAINT `idDepto`
    FOREIGN KEY (`idDepto`)
    REFERENCES `emple_depto`.`Departamento` (`idDepto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;