CREATE TABLE address
(
    id bigint NOT NULL DEFAULT nextval('address_id_seq'::regclass),
    cep character varying(255) NOT NULL,
    street character varying(255) NOT NULL,
    number int,
    city character varying(255) NOT NULL,
    CONSTRAINT address_pkey PRIMARY KEY (id)
);

ALTER SEQUENCE IF EXISTS authentication.address_id_seq
    OWNED BY address.id;