-- Table: spring.cust

-- DROP TABLE spring.cust;

CREATE TABLE spring.cust
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

ALTER TABLE spring.cust
    OWNER to postgres;