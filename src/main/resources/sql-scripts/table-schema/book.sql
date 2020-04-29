-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
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

ALTER TABLE public.book
    OWNER to postgres;