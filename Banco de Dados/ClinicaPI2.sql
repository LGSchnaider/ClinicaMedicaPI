CREATE DATABASE ClinicaPi;
USE ClinicaPi;

CREATE TABLE usuario (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  perfil INT NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE medico (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  cpf BIGINT(20) NOT NULL,
  crm BIGINT(30) NOT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (usuario_idusuario) REFERENCES usuario (id));

CREATE TABLE paciente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf BIGINT(20) NOT NULL,
  telefone BIGINT(20) NOT NULL,
  sexo CHAR(1) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE agenda_medico (
  id INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  hora TIME NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  medico_id_medico INT NOT NULL,
  Paciente_id_paciente INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (medico_id_medico) REFERENCES medico (id),
    FOREIGN KEY (Paciente_id_paciente) REFERENCES paciente (id));

CREATE TABLE medicamento (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  tarja VARCHAR(45) NOT NULL,
  formula VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE secretaria (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf BIGINT(20) NOT NULL,
  telefone BIGINT(20) NOT NULL,
  email VARCHAR(45) NOT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (usuario_idusuario) REFERENCES usuario (id));

CREATE TABLE prontuario (
  id INT NOT NULL AUTO_INCREMENT,
  data DATETIME NOT NULL,
  observacao VARCHAR(300) NOT NULL,
  medico_id_medico INT NOT NULL,
  paciente_id_paciente INT NOT NULL,
  PRIMARY KEY (id, medico_id_medico, paciente_id_paciente),
    FOREIGN KEY (medico_id_medico) REFERENCES medico (id),
    FOREIGN KEY (paciente_id_paciente) REFERENCES paciente (id));

CREATE TABLE medicamento_has_prontoario (
  medicamento_id_medicamento INT NOT NULL,
  prontoario_idprontoario INT NOT NULL,
  PRIMARY KEY (medicamento_id_medicamento, prontoario_idprontoario),
    FOREIGN KEY (medicamento_id_medicamento)REFERENCES medicamento (id), 
	FOREIGN KEY (prontoario_idprontoario) REFERENCES prontuario (id));
 
 
 insert into usuario (login, senha, perfil	) values ('admin', 'admin', 0);
 
 insert into paciente (nome, cpf, telefone, sexo, email) values ('Pedro Nome Comum', 01024507702, 99099974, 'M', 'pedronomecomum@gmail.com');
 insert into paciente (nome, cpf, telefone, sexo, email) values ('Miguel dias', 09101502903, 94056942, 'M', 'miguel@gmail.com');
 
 insert into medico (nome, cpf, crm, usuario_idusuario) values ('Marcos Marco LG Junior', 12087902955, 0666, 1);
 insert into medico (nome, cpf, crm, usuario_idusuario) values ('Dr.Pedro Rocha da Silva', 12333325521, 3711, 1);
 insert into medico (nome, cpf, crm, usuario_idusuario) values ('Me.Augusto Oliveira Pereira', 22255588830, 2811, 1);
 insert into medico (nome, cpf, crm, usuario_idusuario) values ('Dra.Ana Beatrir Ribeiro', 09505508805, 2647, 1);
 insert into medico (nome, cpf, crm, usuario_idusuario) values ('Dr.Roberto Ferreira', 05506607802, 3163, 1);


