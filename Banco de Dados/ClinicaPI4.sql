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
  UF VARCHAR(2) NOT NULL,
  crm BIGINT(30) NOT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (usuario_idusuario) REFERENCES usuario (id));

ALTER TABLE clinicapi.medico 
ADD UNIQUE INDEX cpf_UNIQUE (cpf ASC) VISIBLE,
ADD UNIQUE INDEX crm_UNIQUE (crm ASC) VISIBLE;
;

CREATE TABLE paciente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf BIGINT(20) NOT NULL,
  telefone BIGINT(20) NOT NULL,
  sexo CHAR(1) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  
  ALTER TABLE clinicapi.paciente 
ADD UNIQUE INDEX cpf_UNIQUE (cpf ASC) VISIBLE;
;

CREATE TABLE agenda_medico (
  id INT NOT NULL AUTO_INCREMENT,
<<<<<<< HEAD
  data DATE NOT NULL,
  hora TIME NOT NULL,
  descricao VARCHAR(100) NOT NULL,
=======
  data VARCHAR(11) NOT NULL,
  hora VARCHAR(5) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor BIGINT NOT NULL,
>>>>>>> TelaConsulta
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
    
ALTER TABLE clinicapi.secretaria 
ADD UNIQUE INDEX cpf_UNIQUE (cpf ASC) VISIBLE;

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
insert into paciente (nome, cpf, telefone, sexo, email) values ('Rovberto Carlos', 92992893221, 88985566, 'M', 'rovber122344@gmail.com');
insert into paciente (nome, cpf, telefone, sexo, email) values ('Amy da Silva', 65258515244, 95252151, 'F', 'amysilva77@gmail.com');
insert into paciente (nome, cpf, telefone, sexo, email) values ('Kerly Zimmermann', 45465568899, 55455454, 'F', 'kzimmermann@gmail.com');

insert into usuario (id, login, senha, perfil) values (3, 'Francisco', 'fra', 1);
insert into medico (nome, cpf, uf, crm, usuario_idusuario) values ('Dr.Francisco Pereira', 12332123122, 'SC', 335598, 3);
insert into usuario (id, login, senha, perfil) values (4, 'Lucas', 'luc', 1);
insert into medico (nome, cpf, uf, crm, usuario_idusuario) values ('Dr.Lucas pereira', 55457844517, 'SP', 952565, 4);
insert into usuario (id, login, senha, perfil) values (5, 'Pedro', 'ped', 1);
insert into medico (nome, cpf, uf, crm, usuario_idusuario) values ('Dr.Pedro Vargas', 84512154125, 'AC', 656598, 5);
insert into usuario (id, login, senha, perfil) values (6, 'Alex', 'ale', 1);
insert into medico (nome, cpf, uf, crm, usuario_idusuario) values ('Dr.Alex Gomes', 54545454788, 'AC', 554554, 6);
insert into usuario (id, login, senha, perfil) values (7, 'Ana', 'ana', 1);
insert into medico (nome, cpf, uf, crm, usuario_idusuario) values ('Dr.Ana Paula', 56154651599, 'SC', 255456, 7);

insert into usuario (id, login, senha, perfil) values (8, 'Francisco', 'fra', 4);
insert into secretaria (nome, cpf, telefone, email, usuario_idusuario) values ('Matilda Frank', 65656595956, 54545888, 'mfrank@gmail.com', 8);


