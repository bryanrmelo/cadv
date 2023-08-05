CREATE TABLE tipo (id serial PRIMARY KEY, nome varchar(255));

INSERT INTO
	tipo (nome)
VALUES
	('admin');

INSERT INTO
	tipo (nome)
VALUES
	('especialista');

INSERT INTO
	tipo (nome)
VALUES
	('normal');

CREATE TABLE usuario (
	id serial PRIMARY KEY,
	nome varchar(255),
	senha varchar(255),
	email varchar(255),
	telefone varchar(9),
	codigoRecuperacao varchar(10),
	horarioRecuperacao timestamp,
	dataAssinaturaTermos timestamp,
	status boolean,
	tipo_id int,
	CONSTRAINT fk_tipo FOREIGN KEY (tipo_id) REFERENCES tipo(id)
);

INSERT INTO
	usuario (nome, senha, status, tipo_id)
VALUES
	(
		'admin',
		'e1d92412bc45a6151d5b52e44100a957',
		true,
		1
	);

CREATE TABLE playlist (
	id serial PRIMARY KEY,
	nome varchar(255),
	usuario_id int,
	CONSTRAINT fk_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);

INSERT INTO
	playlist (nome, usuario_id)
VALUES
	('videos', 1);

CREATE TABLE video (
	id serial PRIMARY KEY,
	titulo varchar(255) NOT NULL,
	link varchar(255) NOT NULL UNIQUE,
	autor_id int NOT NULL,
	privado boolean NOT NULL,
	categoria varchar(255) NOT NULL,
	playlist_id int,
	fonte_id int,
	verificacao_id int,
	CONSTRAINT fk_autor FOREIGN KEY(autor_id) REFERENCES usuario(id),
	CONSTRAINT fk_playlist FOREIGN KEY(playlist_id) REFERENCES playlist(id),
	CONSTRAINT fk_fonte FOREIGN KEY (fonte_id) REFERENCES fonte(id),
	CONSTRAINT fk_verificacao FOREIGN KEY(verificacao_id) REFERENCES verificacao(id)
);

CREATE TABLE fonte (
	id serial PRIMARY KEY,
	nome varchar(255),
	dados bytea
);

CREATE TABLE verificacao (
	id serial PRIMARY KEY,
	verificado boolean,
	video_id int NOT NULL,
	especialista_id int,
	CONSTRAINT fk_video FOREIGN KEY(video_id) REFERENCES video(id),
	CONSTRAINT fk_especialista FOREIGN KEY(especialista_id) REFERENCES usuario(id)
);