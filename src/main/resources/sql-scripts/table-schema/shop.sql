-- Table: spring.shop

-- DROP TABLE spring.shop;

CREATE TABLE spring.shop
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    district character varying(50) COLLATE pg_catalog."default",
    fee integer,
    CONSTRAINT shop_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE spring.shop
    OWNER to postgres;