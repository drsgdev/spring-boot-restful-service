-- Table: spring.book

-- DROP TABLE spring.book;

CREATE TABLE spring.book
(
    id integer NOT NULL,
    title character varying(30) COLLATE pg_catalog."default" NOT NULL,
    cost integer NOT NULL,
    warehouse character varying(50) COLLATE pg_catalog."default",
    amnt integer,
    CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE spring.book
    OWNER to postgres;