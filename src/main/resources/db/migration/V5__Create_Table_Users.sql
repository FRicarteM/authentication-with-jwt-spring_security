CREATE TABLE users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    user_name character varying(255) UNIQUE DEFAULT NULL,
	full_name character varying(255) DEFAULT NULL,
	password character varying(255) DEFAULT NULL,
	account_non_expired bit(1) DEFAULT NULL,
	account_non_locked bit(1) DEFAULT NULL,
	credentials_non_expired bit(1) DEFAULT NULL,
	enabled bit(1) DEFAULT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER SEQUENCE IF EXISTS authentication.users_id_seq
    OWNED BY users.id;