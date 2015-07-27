#customer tables
CREATE TABLE `dionysus`.`customer` (
  `customerId` INT NOT NULL COMMENT '',
  `firstName` VARCHAR(45) NOT NULL COMMENT '',
  `lastName` VARCHAR(45) NOT NULL COMMENT '',
  `middleName` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(128) NOT NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `verified` BIT NOT NULL DEFAULT 0 COMMENT '',
  `nickName` VARCHAR(45) NULL COMMENT '',
  `registerTime` TIMESTAMP NOT NULL COMMENT '',
  `lastLoginTime` TIMESTAMP NOT NULL COMMENT '',
  PRIMARY KEY (`customerId`)  COMMENT '');
  
ALTER TABLE  `dionysus`.`customer` ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '';

CREATE TABLE `dionysus`.`customer_address` (
  `addressId` INT NOT NULL COMMENT '',
  `customerId` INT NOT NULL COMMENT '',
  `line1` VARCHAR(1024) NOT NULL COMMENT '',
  `line2` VARCHAR(1024) NULL COMMENT '',
  `postalCode` VARCHAR(45) NOT NULL COMMENT '',
  `city` VARCHAR(45) NOT NULL COMMENT '',
  `Province` VARCHAR(45) NOT NULL COMMENT '',
  `country` VARCHAR(45) NOT NULL COMMENT '',
  `buzzCode` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`addressId`)  COMMENT '');
  
CREATE TABLE `dionysus`.`customer_phone` (
  `phoneId` INT NOT NULL COMMENT '',
  `customerId` INT NOT NULL COMMENT '',
  `countryCode` INT NOT NULL COMMENT '',
  `phoneNumber` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`phoneId`)  COMMENT '');

