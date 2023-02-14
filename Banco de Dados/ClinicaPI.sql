-- -----------------------------------------------------
-- Schema pi
-- -----------------------------------------------------
CREATE DATABASE ClinicaPI;
USE ClinicaPI;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE usuario (
  idusuario INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  perfil INT NOT NULL,
  admin TINYINT NOT NULL,
  PRIMARY KEY (idusuario));


-- -----------------------------------------------------
-- Table `mydb`.`medico`
-- -----------------------------------------------------
CREATE TABLE medico (
  id_medico INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(50) NOT NULL,
  cpf BIGINT NOT NULL,
  crm VARCHAR(30) NOT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (id_medico), FOREIGN KEY (usuario_idusuario) REFERENCES usuario (idusuario));



-- -----------------------------------------------------
-- Table `mydb`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE medicamento (
  id_medicamento INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  tarja VARCHAR(45) NOT NULL,
  formula VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_medicamento));



-- -----------------------------------------------------
-- Table `mydb`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE Paciente (
  id_paciente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf BIGINT NOT NULL,
  telefone BIGINT NOT NULL,
  sexo CHAR(1) NOT NULL,
  email VARCHAR(45) NOT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (id_paciente), FOREIGN KEY (usuario_idusuario) REFERENCES usuario (idusuario));
    


-- -----------------------------------------------------
-- Table `mydb`.`agenda_paciente`
-- -----------------------------------------------------
CREATE TABLE agenda_paciente (
  idagenda_cliente INT NOT NULL AUTO_INCREMENT,
  periodo VARCHAR(45) NOT NULL,
  hora DATETIME NOT NULL,
  descricao VARCHAR(300) NOT NULL,
  medicamento_id_medicamento INT NOT NULL,
  Paciente_id_paciente INT NOT NULL,
  medico_id_medico INT NOT NULL,
  PRIMARY KEY (idagenda_cliente),
    FOREIGN KEY (medicamento_id_medicamento) REFERENCES medicamento (id_medicamento),
    FOREIGN KEY (Paciente_id_paciente) REFERENCES Paciente (id_paciente),
    FOREIGN KEY (medico_id_medico) REFERENCES medico (id_medico));

-- -----------------------------------------------------
-- Table `mydb`.`secretaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS secretaria (
  idsecretaria INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf BIGINT NOT NULL,
  telefone BIGINT NOT NULL,
  email VARCHAR(45) NOT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (idsecretaria), FOREIGN KEY (usuario_idusuario) REFERENCES usuario (idusuario));
   



-- -----------------------------------------------------
-- Table `mydb`.`agenda_medico`
-- -----------------------------------------------------
CREATE TABLE agenda_medico (
  idagenda_medico INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  hora TIME NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  medico_id_medico INT NOT NULL,
  Paciente_id_paciente INT NOT NULL,
  PRIMARY KEY (idagenda_medico), FOREIGN KEY (medico_id_medico) REFERENCES medico (id_medico),
    FOREIGN KEY (Paciente_id_paciente) REFERENCES Paciente (id_paciente));
	