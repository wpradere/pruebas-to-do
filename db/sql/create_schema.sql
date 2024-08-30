CREATE TABLE user_todo
(
    id          bigint  GENERATED ALWAYS AS IDENTITY,
    full_name     varchar(50) NOT NULL,
    user_name     varchar(50) NOT NULL,
    password      varchar(50),
    CONSTRAINT pk_customer PRIMARY KEY ( id )
);

CREATE TABLE list
(
    id_list    bigint GENERATED ALWAYS AS IDENTITY ,
    name_list    varchar(50) NOT NULL,
    state        varchar(50) NOT NULL,
    id_user      bigserial NOT NULL,
    date_start   date NOT NULL,
    date_update  date NULL,
    CONSTRAINT pk_list PRIMARY KEY ( "id_list" ),
    CONSTRAINT fk_user_todo FOREIGN KEY ( id_user ) REFERENCES user_todo ( id ) ON DELETE CASCADE
);