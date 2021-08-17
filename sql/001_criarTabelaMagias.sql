CREATE TABLE IF NOT EXISTS public.magias (
	id serial NOT NULL,
	titulo varchar NOT NULL,
	categoria varchar NOT NULL,
	nivel int NOT NULL,
	escola varchar NOT NULL,
	execucao varchar NOT NULL,
	alcance varchar NOT NULL,
	alvo varchar NULL,
	duracao varchar NULL,
	descricao text NOT NULL,
	aprimoramentos text NULL,
	resistencia varchar NULL,
	area varchar NULL,
	alvo_ou_area varchar NULL,
	alvos varchar NULL,
	efeito varchar NULL,
	CONSTRAINT magias_pk PRIMARY KEY (id)
);
