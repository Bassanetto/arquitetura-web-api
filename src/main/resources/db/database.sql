CREATE DATABASE alunos
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.aluno
(
    id BIGSERIAL PRIMARY KEY,
    nome character varying COLLATE pg_catalog."default",
    documento character varying COLLATE pg_catalog."default",
    curso character varying COLLATE pg_catalog."default",
    idade integer
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.aluno
    OWNER to postgres;