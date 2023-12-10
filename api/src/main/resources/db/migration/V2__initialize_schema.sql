CREATE TABLE SPRING_SESSION
(
    PRIMARY_ID            CHAR(36) NOT NULL,
    SESSION_ID            CHAR(36) NOT NULL,
    CREATION_TIME         BIGINT   NOT NULL,
    LAST_ACCESS_TIME      BIGINT   NOT NULL,
    MAX_INACTIVE_INTERVAL INT      NOT NULL,
    EXPIRY_TIME           BIGINT   NOT NULL,
    PRINCIPAL_NAME        VARCHAR(100),
    CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES
(
    SESSION_PRIMARY_ID CHAR(36)     NOT NULL,
    ATTRIBUTE_NAME     VARCHAR(200) NOT NULL,
    ATTRIBUTE_BYTES    BYTEA        NOT NULL,
    CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
    CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION (PRIMARY_ID) ON DELETE CASCADE
);

create sequence device_seq
    increment by 50;

alter sequence device_seq owner to postgres;

create sequence device_user_seq
    increment by 50;

alter sequence device_user_seq owner to postgres;

create sequence repair_seq
    increment by 50;

alter sequence repair_seq owner to postgres;

create sequence verification_seq
    increment by 50;

alter sequence verification_seq owner to postgres;

create table device_user
(
    id         bigint       not null
        primary key,
    login      varchar(255) not null
        unique,
    password   varchar(255) not null,
    production varchar(255) not null
);

alter table device_user
    owner to postgres;

create table device
(
    verification_period integer      not null,
    id                  bigint       not null
        primary key,
    user_id             bigint
        constraint fk65uxac56qwsu8ysqxbn07yjwk
            references device_user,
    inventory_number    varchar(255) not null,
    note                varchar(255) not null,
    registry_number     varchar(255) not null,
    title               varchar(255) not null,
    type_brand          varchar(255) not null
);

alter table device
    owner to postgres;

create table repair
(
    date_of_repair date         not null,
    device_id      bigint
        constraint fke2lm4qyk4g36lkdab4sqfxnwf
            references device,
    id             bigint       not null
        primary key,
    characteristic varchar(255) not null
);

alter table repair
    owner to postgres;

create table verification
(
    date_of_verification date         not null,
    device_id            bigint
        constraint fk9qruul3vuvdximhy8q3rw63xe
            references device,
    id                   bigint       not null
        primary key,
    conclusion           varchar(255) not null,
    type_of_verification varchar(255) not null,
    verification_place   varchar(255) not null
);

alter table verification
    owner to postgres;