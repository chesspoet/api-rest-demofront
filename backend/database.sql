CREATE SCHEMA IF NOT EXISTS todotask
AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS todotask.task(
    id integer NOT NULL DEFAULT nextval('todotask.task_id_seq'::regclass),
    descripcion character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    titulo character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    CONSTRAINT task_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS todotask.task
    OWNER to postgres;

INSERT INTO todotask.task (descripcion, titulo)
VALUES ('Ir al gimnasio por la mañana', 'Ejercicio físico');

INSERT INTO todotask.task (descripcion, titulo)
VALUES ('Preparar el desayuno saludable', 'Alimentación');

INSERT INTO todotask.task (descripcion, titulo)
VALUES ('Llamar a un amigo para quedar a tomar café', 'Socializar');

INSERT INTO todotask.task (descripcion, titulo)
VALUES ('Hacer una caminata al aire libre', 'Tiempo libre');

INSERT INTO todotask.task (descripcion, titulo)
VALUES ('Leer al menos un capítulo de un libro', 'Crecimiento personal');


INSERT INTO todotask.usuario (email, password)
VALUES ('oswrher@gmail.com', '$2a$10$rvcpmu.gHPqtrBzXv5ImBuR48KuzMYy9BgDwOB3ahwIbDo1veOGnC');

