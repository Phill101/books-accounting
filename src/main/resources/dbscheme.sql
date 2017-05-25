SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema book_accounting
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema book_accounting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `book_accounting` DEFAULT CHARACTER SET utf8 ;
USE `book_accounting` ;

-- -----------------------------------------------------
-- Table `book_accounting`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_accounting`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_accounting`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_accounting`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `author` VARCHAR(255) NULL,
  `lib_quantity` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`, `category_id`),
  INDEX `fk_book_category_idx` (`category_id` ASC),
  CONSTRAINT `fk_book_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `book_accounting`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_accounting`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_accounting`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_accounting`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_accounting`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `role_id` INT NOT NULL DEFAULT 2,
  PRIMARY KEY (`id`, `role_id`),
  INDEX `fk_user_role1_idx` (`role_id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `book_accounting`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_accounting`.`user_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_accounting`.`user_book` (
  `user_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `book_id`),
  INDEX `fk_user_has_book_book1_idx` (`book_id` ASC),
  INDEX `fk_user_has_book_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_book_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `book_accounting`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_book_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `book_accounting`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
