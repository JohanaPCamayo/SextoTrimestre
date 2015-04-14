-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tiendaenlinea
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tiendaenlinea` ;

-- -----------------------------------------------------
-- Schema tiendaenlinea
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tiendaenlinea` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `tiendaenlinea` ;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`carritodecompras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`carritodecompras` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`carritodecompras` (
  `idCarritoDeCompras` VARCHAR(255) NOT NULL COMMENT 'Llave primaria de carrito de compras ',
  `subtotal` FLOAT NOT NULL COMMENT 'Subtotasl del carrito',
  `precioTotal` FLOAT NOT NULL COMMENT 'Precio total del carrito',
  `impuestos` FLOAT NOT NULL COMMENT 'Impuestos carritos',
  PRIMARY KEY (`idCarritoDeCompras`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`categoria` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de categoria',
  `nombreCategoria` VARCHAR(100) NOT NULL COMMENT 'Nombre de la categoria',
  `activa` TINYINT(1) NOT NULL,
  `pariente` INT(11) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`usuario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`usuario` (
  `idUsuario` VARCHAR(20) NOT NULL COMMENT 'Llave primaria del usuario',
  `contrasena` VARCHAR(45) NOT NULL COMMENT 'Contraseña del usuario',
  `rol` VARCHAR(45) NOT NULL COMMENT 'Rol del Usuario',
  `estado` VARCHAR(20) NOT NULL COMMENT 'Estado del usuario',
  `email` VARCHAR(45) NOT NULL COMMENT 'Correo Electronico del Usuario',
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`cuenta` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`cuenta` (
  `tipoDocumento` VARCHAR(10) NOT NULL COMMENT 'Llave priamria tipo documento cuenta',
  `numeroDocumento` VARCHAR(45) NOT NULL COMMENT 'Llave priamria número documento cuenta',
  `primerNombre` VARCHAR(100) NOT NULL COMMENT 'Primer nombre de la persona',
  `segundoNombre` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Segundo nombre de la persona',
  `primerApellido` VARCHAR(100) NOT NULL COMMENT 'Primer apellido de la persona',
  `segundoApellido` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Segundo apellido de la persona',
  `Usuario_idUsuario` VARCHAR(20) NOT NULL COMMENT 'Llave foránea ID usuario',
  PRIMARY KEY (`tipoDocumento`, `numeroDocumento`),
  INDEX `fk_Cuenta_Usuario1` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Cuenta_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `tiendaenlinea`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`departamento` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`departamento` (
  `idDepartamento` VARCHAR(2) NOT NULL COMMENT 'Llave primaria del departamento',
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del departamento',
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`municipio` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`municipio` (
  `idMunicipio` VARCHAR(4) NOT NULL COMMENT 'Llave primaria municipio',
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del municipio',
  `Departamento_idDepartamento` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idMunicipio`),
  INDEX `fk_Municipio_Departamento1` (`Departamento_idDepartamento` ASC),
  CONSTRAINT `fk_Municipio_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento`)
    REFERENCES `tiendaenlinea`.`departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`domicilio_cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`domicilio_cuenta` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`domicilio_cuenta` (
  `Cuenta_tipoDocumento` VARCHAR(10) NOT NULL COMMENT 'Llave primaria Cuenta tipo Documento',
  `Cuenta_numeroDocumento` VARCHAR(45) NOT NULL COMMENT 'Llave primaria Cuenta Número docuemnto',
  `telefono` VARCHAR(45) NOT NULL COMMENT 'Teléfono del domicilio',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Dirección del domicilio',
  `barrio` VARCHAR(100) NOT NULL COMMENT 'Barrio del Domicilio',
  `localidad` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Localidad del domicilio',
  `Municipio_idMunicipio` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Cuenta_tipoDocumento`, `Cuenta_numeroDocumento`),
  INDEX `fk_Domicilio_Municipio1` (`Municipio_idMunicipio` ASC),
  CONSTRAINT `fk_Domicilio_Cuenta1`
    FOREIGN KEY (`Cuenta_tipoDocumento` , `Cuenta_numeroDocumento`)
    REFERENCES `tiendaenlinea`.`cuenta` (`tipoDocumento` , `numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Domicilio_Municipio1`
    FOREIGN KEY (`Municipio_idMunicipio`)
    REFERENCES `tiendaenlinea`.`municipio` (`idMunicipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`proveedor` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`proveedor` (
  `idProveedor` VARCHAR(45) NOT NULL COMMENT 'Llave primaria compuesta de proveedor ',
  `tipoDeIdentificacion` VARCHAR(20) NOT NULL COMMENT 'Llave primaria compuesta de proveedor',
  `nombre` VARCHAR(200) NOT NULL COMMENT 'Nombre del proveedor',
  `email` VARCHAR(45) NOT NULL COMMENT 'Correo electrónico del proveedor',
  PRIMARY KEY (`idProveedor`, `tipoDeIdentificacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`domicilio_proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`domicilio_proveedor` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`domicilio_proveedor` (
  `Proveedor_idProveedor` VARCHAR(45) NOT NULL,
  `Proveedor_tipoDeIdentificacion` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL COMMENT 'Teléfono del domicilio',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Dirección del domicilio',
  `barrio` VARCHAR(100) NOT NULL COMMENT 'Barrio del Domicilio',
  `localidad` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Localidad del domicilio',
  `Municipio_idMunicipio` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Proveedor_idProveedor`, `Proveedor_tipoDeIdentificacion`),
  INDEX `fk_Domicilio_Municipio10` (`Municipio_idMunicipio` ASC),
  CONSTRAINT `fk_Domicilio_Municipio10`
    FOREIGN KEY (`Municipio_idMunicipio`)
    REFERENCES `tiendaenlinea`.`municipio` (`idMunicipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Domicilio_Proveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor` , `Proveedor_tipoDeIdentificacion`)
    REFERENCES `tiendaenlinea`.`proveedor` (`idProveedor` , `tipoDeIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`factura` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`factura` (
  `idFactura` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de la factura',
  `fecha` DATETIME NOT NULL COMMENT 'Fecha y Hora de la factura',
  `total` FLOAT NOT NULL COMMENT 'Total de la factura',
  `Cuenta_tipoDocumento` VARCHAR(10) NOT NULL COMMENT 'Llave foránea tipo Documento de cuenta',
  `Cuenta_numeroDocumento` VARCHAR(45) NOT NULL COMMENT 'Llave foránea número de docuemnto de cuenta',
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Cuenta1` (`Cuenta_tipoDocumento` ASC, `Cuenta_numeroDocumento` ASC),
  CONSTRAINT `fk_Factura_Cuenta1`
    FOREIGN KEY (`Cuenta_tipoDocumento` , `Cuenta_numeroDocumento`)
    REFERENCES `tiendaenlinea`.`cuenta` (`tipoDocumento` , `numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`producto` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`producto` (
  `idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave primaria producto',
  `nombre` VARCHAR(300) NOT NULL COMMENT 'Nombre del producto',
  `marca` VARCHAR(45) NOT NULL COMMENT 'Marca del producto',
  `referencia` VARCHAR(45) NOT NULL COMMENT 'Referencia del producto ',
  `descripcion` VARCHAR(500) NOT NULL COMMENT 'Descripcion del producto',
  `material` VARCHAR(45) NOT NULL COMMENT 'Material del producto',
  `color` VARCHAR(45) NOT NULL COMMENT 'Color del producto',
  `foto` LONGBLOB NULL DEFAULT NULL COMMENT 'Foto del producto',
  `cantidad` INT(11) NOT NULL COMMENT 'Unidades existentes del producto',
  `activo` TINYINT(1) NOT NULL COMMENT 'Estado del producto',
  `precioUnitario` FLOAT NOT NULL COMMENT 'Precio Unitario del producto',
  `descuento` FLOAT NOT NULL COMMENT 'Descuento del producto',
  `Categoria_idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Categoria1` (`Categoria_idCategoria` ASC),
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `tiendaenlinea`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`inventario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`inventario` (
  `idInventario` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria inventario',
  `fecha` DATE NOT NULL COMMENT 'Fecha de la compra',
  `cantidad` INT(11) NOT NULL COMMENT 'Cantidad comprada',
  `Producto_idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave foranea ID Producto',
  `Proveedor_idProveedor` VARCHAR(45) NOT NULL COMMENT 'Llave foranea Id Proveedor',
  `Proveedor_tipoDeIdentificacion` VARCHAR(20) NOT NULL COMMENT 'Llave foraena Proveedor tipo de Identificacion',
  PRIMARY KEY (`idInventario`, `Producto_idProducto`, `Proveedor_idProveedor`, `Proveedor_tipoDeIdentificacion`),
  INDEX `fk_Inventario_Producto1` (`Producto_idProducto` ASC),
  INDEX `fk_Inventario_Proveedor1` (`Proveedor_idProveedor` ASC, `Proveedor_tipoDeIdentificacion` ASC),
  CONSTRAINT `fk_Inventario_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `tiendaenlinea`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventario_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor` , `Proveedor_tipoDeIdentificacion`)
    REFERENCES `tiendaenlinea`.`proveedor` (`idProveedor` , `tipoDeIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`pedido` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`pedido` (
  `Factura_idFactura` INT(11) NOT NULL COMMENT 'Llave foránea primaria ID factura',
  `total` FLOAT NOT NULL COMMENT 'Precio Total del pedido',
  `subtotal` FLOAT NOT NULL COMMENT 'Subtotal del pedido',
  `impuestos` FLOAT NOT NULL COMMENT 'Impuestos del pedido',
  PRIMARY KEY (`Factura_idFactura`),
  CONSTRAINT `fk_Pedido_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `tiendaenlinea`.`factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`item` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`item` (
  `Producto_idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave foránea ID producto\n',
  `Pedido_Factura_idFactura` INT(11) NOT NULL COMMENT 'Llave foránea Pedido',
  `cantidad` INT(11) NOT NULL COMMENT 'Cantidad del producto',
  `costoUnitario` FLOAT NOT NULL COMMENT 'Costo Unitario del producto',
  `costoTotal` FLOAT NOT NULL COMMENT 'Costo Total del Item',
  PRIMARY KEY (`Producto_idProducto`, `Pedido_Factura_idFactura`),
  INDEX `fk_Item_Pedido1` (`Pedido_Factura_idFactura` ASC),
  CONSTRAINT `fk_Item_Pedido1`
    FOREIGN KEY (`Pedido_Factura_idFactura`)
    REFERENCES `tiendaenlinea`.`pedido` (`Factura_idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `tiendaenlinea`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`item_carrito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`item_carrito` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`item_carrito` (
  `Producto_idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave foránea ID producto',
  `CarritoDeCompras_idCarritoDeCompras` VARCHAR(255) NOT NULL,
  `cantidad` INT(11) NOT NULL COMMENT 'Cantidad del producto',
  `costoUnitario` FLOAT NOT NULL COMMENT 'Costo Unitario del producto',
  `costoTotal` FLOAT NOT NULL COMMENT 'Costo Total del Item',
  PRIMARY KEY (`Producto_idProducto`, `CarritoDeCompras_idCarritoDeCompras`),
  INDEX `fk_Item_Carrito_CarritoDeCompras1` (`CarritoDeCompras_idCarritoDeCompras` ASC),
  CONSTRAINT `fk_Item_Carrito_CarritoDeCompras1`
    FOREIGN KEY (`CarritoDeCompras_idCarritoDeCompras`)
    REFERENCES `tiendaenlinea`.`carritodecompras` (`idCarritoDeCompras`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Producto_has_CarritoDeCompras_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `tiendaenlinea`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaenlinea`.`pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaenlinea`.`pago` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaenlinea`.`pago` (
  `Factura_idFactura` INT(11) NOT NULL COMMENT 'Llave foranea primaria de ID Factura',
  `numTarCredito` VARCHAR(45) NOT NULL COMMENT 'Número Tarjeta del pago',
  `banco` VARCHAR(100) NOT NULL COMMENT 'Banco Tarjeta',
  `tipoCuentaTar` VARCHAR(20) NOT NULL COMMENT 'Tipo de Cuenta Tarjeta',
  `tipoTransaccion` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Factura_idFactura`),
  CONSTRAINT `fk_Pago_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `tiendaenlinea`.`factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
