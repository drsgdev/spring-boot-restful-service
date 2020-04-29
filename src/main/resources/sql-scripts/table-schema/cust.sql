-- Table: public.cust

-- DROP TABLE public.cust;

CREATE TABLE public.cust
(
    id integer NOT NULL,
    lname character varying(30) COLLATE pg_catalog."default" NOT NULL,
    district character varying(50) COLLATE pg_catalog."default",
    discount integer,
    CONSTRAINT cust_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cust
    OWNER to postgres;