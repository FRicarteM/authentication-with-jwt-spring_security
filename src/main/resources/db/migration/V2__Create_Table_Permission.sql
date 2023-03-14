CREATE TABLE permission
(
    id bigint NOT NULL DEFAULT nextval('permission_id_seq'::regclass),
    description character varying(255) NOT NULL,
    CONSTRAINT permission_pkey PRIMARY KEY (id)
);

ALTER SEQUENCE IF EXISTS authentication.permission_id_seq
    OWNED BY permission.id;