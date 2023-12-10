create table telegram_user
(
    chat_id        bigint not null,
    id             bigserial
        primary key,
    system_user_id bigint not null
);

alter table telegram_user
    owner to postgres;

