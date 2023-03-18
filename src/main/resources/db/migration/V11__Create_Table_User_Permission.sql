CREATE TABLE user_permission
(
  id bigint NOT NULL DEFAULT nextval('user_permission_id_seq'::regclass),
  id_user bigint NOT NULL,
  id_permission bigint NOT NULL,
  CONSTRAINT user_permission_pkey PRIMARY KEY (id),
  CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES users (id),
  CONSTRAINT fk_permission FOREIGN KEY (id_permission) REFERENCES permission (id)
);

ALTER SEQUENCE IF EXISTS authentication.user_permission_id_seq
    OWNED BY user_permission.id;