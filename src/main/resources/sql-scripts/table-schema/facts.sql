-- Table: spring.facts

-- DROP TABLE spring.facts;

CREATE TABLE spring.facts
(
    oid integer NOT NULL,
    date date NOT NULL,
    retailer integer NOT NULL,
    cust integer NOT NULL,
    book integer,
    amnt integer,
    cost integer NOT NULL,
    CONSTRAINT facts_pkey PRIMARY KEY (oid),
    CONSTRAINT facts_book_fkey FOREIGN KEY (book)
        REFERENCES spring.book (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT facts_cust_fkey FOREIGN KEY (cust)
        REFERENCES spring.cust (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT facts_retailer_fkey FOREIGN KEY (retailer)
        REFERENCES spring.shop (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE spring.facts
    OWNER to postgres;