# spring-boot-testes-automatizados
Spring Boot - Testes Automatizados

#Instruções - Banco de Dados

create database dbtestes
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE dbtestes.funcionarios (
	id INTEGER NOT NULL AUTO_INCREMENT,
	nome varchar(100) NULL,
	salario DECIMAL(10,2) NULL,
	CONSTRAINT funcionarios_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;

