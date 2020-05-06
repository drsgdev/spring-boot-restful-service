-- Table: public.facts

-- DROP TABLE public.facts;

CREATE TABLE public.facts
(
    oid integer NOT NULL,
    date timestamp NOT NULL,
    retailer integer NOT NULL,
    cust integer NOT NULL,
    book integer,
    amnt integer,
    cost integer NOT NULL,
    CONSTRAINT facts_pkey PRIMARY KEY (oid),
    CONSTRAINT facts_book_fkey FOREIGN KEY (book)
        REFERENCES public.book (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT facts_cust_fkey FOREIGN KEY (cust)
        REFERENCES public.cust (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT facts_retailer_fkey FOREIGN KEY (retailer)
        REFERENCES public.shop (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.facts
    OWNER to postgres;