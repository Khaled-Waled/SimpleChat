/*Create The Database*/
CREATE SCHEMA `SimpleChat` ;


/*Create Users Table*/
CREATE TABLE `SimpleChat`.`Users` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(50) NULL,
  `Passphrase` VARCHAR(15) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `imgDir` VARCHAR(100) NULL,
  `birthDay` DATETIME NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE);
  
  